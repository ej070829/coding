<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<Link href="./resources/css/login.css" rel="stylesheet">
<title>로그인</title>
</head>
<body>
	<nav class="nav">
        <!-- nav 바에서 Main으로 이동하는 부분 -->
        <a class="nav-content" href="./home">Home</a>
        
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
    <div class="login-container">
        <div class="login-text">
            <h3>Please sign in</h3>
        </div>
        <c:if test="${not empty error}">  
            <div class="alert alert-danger">
                UserName과 Password가 올바르지 않습니다.<br />
            </div>
        </c:if> 
        <form class="form-signin" action="<c:url value="/login"/>"    method="post"> 
            <div class="form-group row">
                <input type="text" name="username" class="form-control" placeholder="User Name" required autofocus> 
            </div>
            <div class="form-group row">
                <input type="password" name="password" class="form-control"  placeholder="Password" required>  
            </div>
            <div class="form-group row">
                <button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>                
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />  
            </div>
        </form>
    </div>
</body>
</html>