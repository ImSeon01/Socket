package com.kh.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketBaiscServer extends TextWebSocketHandler{
	// 접속 시 호출되는 메소드(특정 상황에 실행되는 코드) => 콜백
	// session : 접속한 사용자의 웹 소켓 정보(HttpSession 아님!!!)
	// 
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("접속 : ");
		System.out.println("session : " + session);
		// session : StandardWebSocketSession[id=a7d23de1-a478-eb48-616a-761d46a0b2bf, uri=ws://localhost:8111/ws/sc]
		// 누구 들어 왔어 작업
	}
	// 메시지 수신 시 호출되는 메소드
	// session : 사용자(전송한사람)의 웹 소켓정보(HttpSession이 아님!!!)
	// message : 사용자가 전송한 메시지 정보
				// payload : 실제 보낸 내용
				// byteCount : 보낸 메시지 크기 (Byte)
				// last : 메시지 종료 여부
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("session : " + session);
		System.out.println("message : " + message);
		
		// session : StandardWebSocketSession[id=1add37ea-be1e-a6a0-9cee-39330364db56, uri=ws://localhost:8111/ws/sc]
		// message : TextMessage payload=[안녕하세요!], byteCount=16, last=true]
		// payload : 전송시 보낸 데이터
		// byteCount : 바이트 수 
		// last :  1 / 2 / 3 / 4 마지막 메시지면 true/ 뒤에 더 붙을 것이 있으면 false
		
	}
	
	// 접속 종료 시 호출되는 메소드 => 콜백
	// session : 사용자의 웹 소켓 정보(HttpSession이 아님)
	// status : 접속이 종료된 원인과 관련된 정보
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("전화 끊었다.");
		System.out.println("session : " + session);
		System.out.println("status : " + status);
		// 전화 끊었다.
		// session : StandardWebSocketSession[id=877fd70d-f893-b5b8-d4c4-debeeb517a72, uri=ws://localhost:8111/ws/sc]
		// status : CloseStatus[code=1000, reason=null]
	}
}
