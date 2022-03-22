<%@
page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
%>
<%@
	page import = "user.UserDAO"
 %>
<%@
	page import = "java.io.PrintWriter"
%>
<%
	request.setCharacterEncoding ("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 액션</title>
</head>
<body>
	<%
	UserDAO userDAO = new UserDAO();
	int rst = userDAO.login(user.getUserID(),user.getUserPassword());
	PrintWriter script = response.getWriter();
	if(rst == 100){
		//로그인 성공페이지 이동
		script.println("<script>");
		script.println("alert('로그인 성공')");
		script.println("</script>");
	}else if(rst == -100){
		//패스워드 확인 바랍니다.
		script.println("<script>");
		script.println("alert('패스워드 확인 바랍니다')");
		script.println("</script>");
	}else if(rst == -200){
		//아이디가 존재하지 않습니다. 회원가입 페이지로 이동합니다.
		script.println("<script>");
		script.println("alert('아이디가 존재하지 않습니다')");
		script.println("</script>");
	}else if(rst == -300){
		//데이터 베이스가 고장났어요.
		script.println("<script>");
		script.println("alert('데이터베이스가 고장났어요')");
		script.println("</script>");
	}
	
	
	
	
	
	%>
</body>
</html>