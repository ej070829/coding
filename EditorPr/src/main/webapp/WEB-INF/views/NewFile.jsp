<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>Code Editor</title>
<style>
	#editor {
		height: 800px !important;
 		font-size: 25px;
	}
	
	#desc {
		height: 800px;
		font-size: 20px;
	}
</style>
</head>
<body>
 	<div style="display:flex;">
 		<div style="flex:0 0 30%;">
 			<div id="desc">
 				<h3>문제 설명</h3>
 				<b>상세한 설명</b>	
			</div>
 			<div style="margin-top:20px;">
				<button onclick="send_compiler();" style="width: 200px; 
				height: 100px; vertical-align:top;">Run</button>
				<div style="margin:5px 0 0 20px;">
					<div>경과시간: <span id="performance"></span> m/s</div>
				</div>
			</div>
 		</div>
 		<div style="flex:0 0 70%;">
 			<div style="display:flex; flex-direction :column;">
 				<div id="editor" style="flex:auto auto 60%;" ></div>
 				<div id="input_box" style="flex:auto auto 10%;">임시 입력 박스</div>
				<div style="flex:auto auto 10%;  margin-top:20px;">
					<div sytle="text-align: center;">===== 출력 =====<br></div>
				</div>
				<div style="flex:auto auto 20%; margin-top:20px;">
					<div id="OUTPUT" style="padding: 10px;">실행 결과가 여기에 표시됩니다.</div>
				</div>
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
				url: "http://localhost:8080/editor/postman",
				data : JSON.stringify({"lang":"python","code":code,"input":"1 1"}),
				dataType: "json",
				contentType: 'application/json; charset=utf-8',
				success: function(data,status) {
					console.log("status: ", status);
					console.log("data: ",data["output"][0]);
					
					// 응답 값 출력
					output=data["output"][0];					
					document.getElementById("OUTPUT").innerHTML = output;					
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
