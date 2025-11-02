package com.example.attendance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String studentId = req.getParameter("studentId");
        String dateStr = req.getParameter("date");
        String status = req.getParameter("status");

        String message;
        if (studentId == null || studentId.trim().isEmpty() || dateStr == null || status == null) {
            message = "Missing required fields.";
            req.setAttribute("message", message);
            req.getRequestDispatcher("success.jsp").forward(req, resp);
            return;
        }

        try (Connection conn = DBUtil.getConnection()) {
            // create table if not exists
            String create = "CREATE TABLE IF NOT EXISTS attendance (id IDENTITY PRIMARY KEY, student_id VARCHAR(100), att_date DATE, status VARCHAR(20))";
            try (Statement st = conn.createStatement()) {
                st.execute(create);
            }

            String insert = "INSERT INTO attendance (student_id, att_date, status) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insert)) {
                ps.setString(1, studentId);
                ps.setDate(2, Date.valueOf(dateStr));
                ps.setString(3, status);
                ps.executeUpdate();
            }

            message = "Attendance recorded for student: " + studentId;

        } catch (Exception e) {
            message = "Error saving attendance: " + e.getMessage();
            e.printStackTrace();
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }
}
