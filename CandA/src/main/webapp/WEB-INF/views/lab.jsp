<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<%= request.getContextPath() %>/resources/css/lab.css" rel="stylesheet">
    <title>CandAProject</title>
</head>
<body>
	<nav class="nav">
        <!-- nav 바에서 Main으로 이동하는 부분 -->
        <a class="nav-content" href="./">Home</a>
        
        <p class="border-left"> </p>
        
        <!-- nav 바에서 각 프로젝트로 연결되는 부분 -->
        <a class="nav-content" href="#">생각하기</a>
        <a class="nav-content" href="#">만들기</a>
        <a class="nav-content" href="#">공유하기</a>
        <a class="nav-content" href="#">커뮤니티</a>
        
        <p class="border-left"></p>
        
        <!-- 로그인 페이지로 이동하는 부분 -->
        <a class="nav-content" href="./login">로그인</a>
    </nav>
    
    <div>
    	<img>
    	<div>
    		<div>원래 내용: </div>
    		<div class="lab-title">${Lab.name}</div>
    		<div class="lab-content">${Lab.content}</div>
    		
    		<div>수정사항 : </div>
  			  <div class="lab-container">
  			  <form:form modelAttribute = "lab"
    			action="./lab?${_csrf.parameterName}=${_csrf.token}"
   			 	class="" 
    			enctype="multipart/form-data">
    			<fieldset>
    			<div class="lab-name">
    				<label>프로젝트명</label>
    				<div>
    					<input  path="name"  class=""/>
    				</div>
    			</div>
    		
    			<div class="lab-content">
    				<label>프로젝트설명</label>
    				<div>
    					<input  path="content"  class=""/>
    				</div>
    			</div>
    		
    			<div>
    				<input type="submit" class="" value ="수정"/>
    			</div>
    			</fieldset>
    			</form:form>
    				<hr>
    	
    	
   			</div>
    	</div>
    
    </div>
</body>
</html>