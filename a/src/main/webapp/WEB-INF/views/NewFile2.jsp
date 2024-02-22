<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#editor {
		height: 800px !important;
 		font-size: 20px;
	}
	
	#desc {
		height: 800px;
		font-size: 15px;
	}
</style>
</head>
<body>
 	<div style="display:flex;">
 		<div style="flex:0 0 30%;">
 			<div id="desc">
 				<b>문제 설명</b><br>
 				<br>
				<b>B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오. 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다. A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35</b><br>
				<br>
				<b>입력</b><br>
				<b>첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.</b><br>
				<br>
				<b>출력</b><br>
				<b>첫째 줄에 B진법 수 N을 10진법으로 출력한다.</b><br>
			</div>
 			<div style="margin-top:20px;">
				<button onclick="send_compiler();" style="width: 200px; height: 100px; vertical-align:top;">Run</button>
				<div style="margin:5px 0 0 20px;">
					<div>결과: <span id="result"></span></div>
					<div>경과시간: <span id="performance"></span> m/s</div>
				</div>
			</div>
 		</div>
 		<div style="flex:0 0 70%;">
 			<div id="editor"></div>
			<div style="display:flex; margin-top:20px;">
				<div>출력:</div>
				<div id="OUTPUT" style="flex:1 1 auto; padding-left:10px;">실행 결과가 여기에 표시됩니다.</div>
			</div>
			<div style="display:flex; margin-top:20px;">
				<div>결과:</div>
				<div id="OUTPUT2" style="flex:1 1 auto; padding-left:10px;"></div>
			</div>
 		</div>
	</div>
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		var editor = ace.edit("editor");
		$(function() {
			editor.setTheme("ace/theme/pastel_on_dark");
			editor.getSession().setMode("ace/mode/java");
			editor.setOptions({ maxLines: 1000 });
			
		})
		function getEditorValue() {   
          // Ace 에디터의 현재 내용을 반환
          return editor.getValue();
      }

		var code = "";
	    var output = "";
	    function send_compiler() {
	       code = getEditorValue();
	       console.log(code);
	       $.ajax({
	          type: "POST",
	          url: "http://localhost:8080/controler/postman",
	          data : JSON.stringify({"lang":"python","code":code,"input":["ZZZZZ 36"]}),
	          dataType: "json",
	          contentType: 'application/json; charset=utf-8',
	          success: function(data,status) {
	             console.log("status: ", status);
	             console.log("data: ",data["output"][0]);
	               
	               // 응답 값 출력
	             answer = '오답'
	             output=data["output"][0];              
	             if(output == "60466175"){
	            	 answer = '정답'
	             }
	             document.getElementById("OUTPUT").innerHTML = output;     
	             document.getElementById("OUTPUT2").innerHTML = answer;
	          },
	          error: function(xhr, status,err) {
	             console.log("status: ", xhr.status);
	               console.log("statusText: ", xhr.statusText);
	               console.log("responseText: ", xhr.responseText);
	             console.log("err", err);
	          }
	            
	       })
	    }
		
	</script>
</body>
</html>