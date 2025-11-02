<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Student Attendance</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        form { max-width: 400px; }
        label { display:block; margin-top:10px; }
        input, select { width:100%; padding:8px; margin-top:4px; }
        button { margin-top:12px; padding:8px 12px; }
    </style>
</head>
<body>
    <h1>Record Attendance</h1>
    <form action="${pageContext.request.contextPath}/attendance" method="post">
        <label for="studentId">Student ID</label>
        <input type="text" id="studentId" name="studentId" required />

        <label for="date">Date</label>
        <input type="date" id="date" name="date" required />

        <label for="status">Status</label>
        <select id="status" name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
            <option value="Leave">Leave</option>
        </select>

        <button type="submit">Submit Attendance</button>
    </form>

    <hr />
    <p>Small demo showing JSP form submission to a Servlet and storing records in H2 DB.</p>
</body>
</html>
