<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<h1>JSP</h1>
	<button onclick="connect();">접속</button>
	<button onclick="disconnect()">종료</button>
	
	<script>
		// 웹 소켓 접속 함수
		var socket;
		
		function connect(){
			var uri = 'ws://localhost:8111/ws/sc';
			socket = new WebSocket(uri);
			
			socket.onopen = function(){ // 소켓이 열리면 이 함수를 호출해라
				console.log('서버와 연결되었습니다.');
			}
			socket.onclose = function(){
				console.log('서버와 연결이 종료되었습니다.');
			}
			socket.onerror = function(e){
				console.log('서버와 연결과정에서 문제가 발생했습니다.');ㅣ
			}
			socket.onmessage = function(e){
				console.log('메시지가 도착했습니다.');
			}
		};
		function disconnect(){
			socket.close();
		};
		function send(){
			var text = $('#chat-input').val();
			if(!text){
				return;
			}
			
			socket.send(text);
			$('#chat-input').val('');
		}
		
	</script>
	
	<hr>
	<input type="text" id="chat-input">
	<button onclick="send();">전송</button>
	
</body>
</html>