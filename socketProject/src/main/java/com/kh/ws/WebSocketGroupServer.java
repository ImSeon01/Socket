package com.kh.ws;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketGroupServer extends TextWebSocketHandler{
	
	/*
	 * 사용자들을 기억하기 위한 저장소
	 * - 중복 불가 : Set
	 * - 동기화 지원 : 
	 * 
	 */
	
	private Set<WebSocketSession> users = new CopyOnWriteArraySet();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		System.out.println("사용자 접속 ! 현재 " + users.size() + "명");
		// 사용자 접속 ! 현재 1명
		// 사용자 접속 ! 현재 2명
		// 사용자 접속 ! 현재 3명
	}
	

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 메시지를 모든 사용자에게 전송(사용자 수만큼 반복해서 전송)
		TextMessage newMessage = new TextMessage(message.getPayload()); // payload 필드에 있는 사용자가 실제로 보낸 내용(본문)
		
		// sesssion.sendMessage(newMessage);
		
		for(WebSocketSession ws : users) {
			ws.sendMessage(newMessage);
			// 사용자가 늘어나면 늘어날 수록 성능은 저하가 됨
			
		}
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		System.out.println("사용자 종료 ! 현재 " + users.size() + "명");
		// 사용자 종료 ! 현재 2명
		// 사용자 종료 ! 현재 1명
		// 사용자 종료 ! 현재 0명
	}

}
