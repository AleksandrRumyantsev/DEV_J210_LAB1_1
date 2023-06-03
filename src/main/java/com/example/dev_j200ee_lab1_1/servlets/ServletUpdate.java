package com.example.dev_j200ee_lab1_1.servlets;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletUpdate", value = "/ServletUpdate")
public class ServletUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String clientid = request.getParameter("clientid");
        PrintWriter out = response.getWriter();
        out.println("<html><body><center>");
        out.println("<h1>Update " + clientid + "</h1>");
        out.println("</center></body></html>");
        System.out.println("doGet_ServletUpdate");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String clientid = request.getParameter("clientid");
        PrintWriter out = response.getWriter();
        out.println("<html><body><center>");
        out.println("<h1>Update " + clientid + "</h1>");
        out.println("</center></body></html>");

        System.out.println("doPost_ServletUpdate");
    }
}