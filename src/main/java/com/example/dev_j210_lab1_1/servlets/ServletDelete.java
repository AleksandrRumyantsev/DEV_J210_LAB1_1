package com.example.dev_j210_lab1_1.servlets;

import com.example.dev_j210_lab1_1.repository.AppReposI;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDelete", value = "/ServletDelete")
public class ServletDelete extends HttpServlet {
    @EJB
    public AppReposI repository;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String clientid = request.getParameter("clientid");
        String addressid = request.getParameter("addressid");
        PrintWriter out = response.getWriter();
        out.println("<html><body><center>");

        out.println("<h1>Ты действительно хочешь удалить клиент номер " + clientid + " c адресом номер " + addressid + "?  </h1>");
        out.println(" <br> </br>");
        out.println("<form action=\"ServletDelete\" method=\"post\" align=\"center\">");
        out.println("<input type=\"hidden\" name=\"clientid\" value=\"" + clientid + "\">");
        out.println("<input type=\"hidden\" name=\"addressid\" value=\"" + addressid + "\">");
        out.println("<input type=\"submit\" name=\"action\" value=\"delete\">");
        out.println("<input type=\"submit\" name=\"action\" value=\"cancel\">");
        out.println("</form>");

        out.println("</center></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int clientid = Integer.parseInt((String)request.getParameter("clientid"));
        int addressid = Integer.parseInt((String)request.getParameter("addressid"));

        if ("delete".equals(action)) {
            repository.deleteClient(clientid,addressid);
            response.sendRedirect("ServletViewList");
        } else if ("cancel".equals(action)) {
            response.sendRedirect("ServletViewList");
        }
    }
}