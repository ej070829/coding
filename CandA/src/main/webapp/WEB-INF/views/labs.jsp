<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<%= request.getContextPath() %>/resources/css/labs.css" rel="stylesheet">
    <title>CandAProject</title>
</head>
<body>
    <nav class="nav">
        <!-- nav 바에서 Main으로 이동하는 부분 -->
        <a class="nav-content" href="./labs">Home</a>
        
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
    <div class="container container-column">
        <div class="labs-title">
            <h1>MainPage 입니다.!</h1>
        </div>
        <div class="container">
        	<div class="labs-items">
        		<c:forEach items="${LabList}" var="lab">
        			<div class="labs-Box labs-data">
        				<a class="lab-margin" href="#">
        					<p class="labs-name">${lab.name}</p>
        					<p class="labs-content">${fn:substring(lab.content, 0, 100)}</p>
        				</a>
        				<p><a href="<c:url value='/labs/lab?name=${lab.name}'/>" class="lab-detailbtn" role="button">상세정보&raquo;</a></p>
        			</div>
            	    
        		</c:forEach>
        		
        	</div>
        </div>
        
        	
                
            
        
    </div>
</body>
</html>
