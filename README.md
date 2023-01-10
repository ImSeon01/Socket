# Socket
## WebSocketBaisc
### 웹 소켓이란?
Web에서 수행하는 Socekt 통신  
기본적으로 Web은 비연결형 통신이라는 특징을 가지고 있음  
소켓은 기본적으로 연결형 통신임  

### 라이브러리 설치
https://mvnrepository.com/artifact/org.springframework/spring-websocket  
소켓은 Spring 4 버전 이상 부터 사용 가능
1. Spring WebSocket (스프링에 버전 5.3.18에 맞출 것이기 때문에 상관 없음)
2. Jackson Databind (2.11.2버전)

### TextWebSocketHanlder 상속
1. afterConnectionEstablished(WebSocketSession session) : void  
접속 시 호출되는 메소드 => 콜백(특정 상황에 실행되는 코드)
2. handlerTextMessaage(WebSocketSession session, TextMessage message) : void  
메시지 수신 시 호출되는 메소드 => 콜백
3. afterConnectionClosed(WebSocketSession session, CloseStatus status) : void  
접속 종료 시 호출되는 메소드 => 콜백

### servlet-context.xml에 빈 & websocket 등록

### 웹 소켓 함수
1. 연결 : ``socket = new WebSocket(uri)``
2. 종료 : ``socket.close()``
3. 메시지 전송 : ``socket.send(text)``

1. 소켓이 열리면 호출 : ``onopen = function(){}`` 
2. 소켓이 닫히면 호출 : ``onclose = function(){}``
3. 소켓에 에러가 발생하면 호출 : ``onerror = function(e){}``
4. 소켓에 메시지가 도착하면 호출 : ``onmessage = function(e){}``

****
## WebSocketGroup


