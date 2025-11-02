# Student Attendance Portal (JSP + Servlet + H2)

This is a minimal demo web application that shows a JSP form submitting attendance data to a Servlet that saves records to an H2 database using JDBC.

Contents:
- `src/main/webapp/attendance.jsp` - form UI to collect Student ID, Date, Status
- `src/main/java/com/example/attendance/AttendanceServlet.java` - servlet that handles POST, creates table if needed and inserts record
- `src/main/java/com/example/attendance/DBUtil.java` - simple JDBC connection helper to H2
- `src/main/webapp/success.jsp` - confirmation page
- `pom.xml` - Maven setup with H2 dependency and Jetty plugin

Quick run (requires Maven installed):

1. Build the project:

```powershell
mvn -DskipTests package
```

2. Run locally with Jetty (development):

```powershell
mvn jetty:run
```

Open http://localhost:8080/ in your browser. The welcome page `attendance.jsp` should appear.

Notes:
- The H2 database file will be created at `~\attendance_db.mv.db` (user home directory). You can change the JDBC URL in `DBUtil.java`.
- This demo uses a simple file-based H2 DB for convenience. In production, switch to a proper DB server, use connection pooling, and secure credentials.

Next steps / improvements:
- Add a page to list attendance records
- Add validation and better error handling
- Use connection pooling (HikariCP) for production
