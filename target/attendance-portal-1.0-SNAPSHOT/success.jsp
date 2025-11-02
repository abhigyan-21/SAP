<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Attendance Result</title>
    <style>body{font-family:Arial, sans-serif;margin:40px;}</style>
</head>
<body>
    <h1>Result</h1>
    <p>
        ${requestScope.message}
    </p>
    <p><a href="${pageContext.request.contextPath}/attendance.jsp">Record another</a></p>
</body>
</html>
