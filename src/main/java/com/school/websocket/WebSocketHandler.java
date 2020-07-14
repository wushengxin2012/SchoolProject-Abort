package com.school.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

@ServerEndpoint("/testWebSocket/{id}")
@Component
public class WebSocketHandler{
	// log the number of connection
	private static volatile int onlineCount = 0;
	// concurrent packaget, save each client's WebSocketHandler
	// private static CopyOnWriteArraySet<WebSocketHandler> webSocketSet = new CopyOnWriteArraySet<WebSocketHandler>();
	private static ConcurrentHashMap<String, WebSocketHandler> webSocketMap = new ConcurrentHashMap<>();
	
	// receive user id
	private String userId = "";
	// Client's session, which is used to send/receive with client
	private Session session;
	
	@OnOpen
	public void onOpen(Session session, @PathParam("id") String id) throws Exception{
		this.session = session;
		this.userId = id;
		System.out.println("web socket server is connecting with: " + this.session.getId());
		if(webSocketMap.containsKey(userId)){
			webSocketMap.remove(userId);
			webSocketMap.put(userId, this);
		}else{
			webSocketMap.put(userId, this);
			addOnlineCount();
		}
		
		try{
			sendMessage("connection success");
		}catch(IOException e){
			System.out.println("connect success, but fail in send data");
		}
		
	}
	
	@OnClose
	public void onClose(){
		if(webSocketMap.containsKey(userId)){
			webSocketMap.remove(userId);
			subOnlineCount();
		}
		System.out.println("user :" + userId + " is quit.");
	}
	
	@OnMessage
	public void onMessage(String message, Session session){
		System.out.println("web socket server receive: " + message);
		try{
			sendMessage("web server receive : " + message);
		}catch(Exception e){
			System.out.println("faild in send message, maybe there are not network connection");
		}
	}
	
	@OnError
	public void onError(Session session, Throwable error){
		System.out.println("web socket server occur an error : " + error.getMessage());
	}
	
	public void sendMessage(String message) throws Exception{
		if(this.session.isOpen()){
			this.session.getBasicRemote().sendText(message);
		}
	}
	
	public static void sendInfo(String message, @PathParam("id") String id) throws Exception{
		System.out.println("send message to : " + id + " with message : " + message);
		if(StringUtils.isNotBlank(id) && webSocketMap.containsKey(id)){
			webSocketMap.get(id).sendMessage(message);
		}else{
			System.out.println("user " + id + ", not online");
		}
	}
	
	public static synchronized int getOnlineCount(){
		return onlineCount;
	}
	
	public static synchronized void addOnlineCount(){
		WebSocketHandler.onlineCount++;
	}
	
	public static synchronized void subOnlineCount(){
		WebSocketHandler.onlineCount--;
	}
	
}