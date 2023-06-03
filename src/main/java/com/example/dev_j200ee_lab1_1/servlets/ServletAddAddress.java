package com.example.dev_j200ee_lab1_1.servlets;

import com.example.dev_j200ee_lab1_1.entities.AddressEntity;
import com.example.dev_j200ee_lab1_1.entities.ClientEntity;
import com.example.dev_j200ee_lab1_1.repository.AppReposI;
import jakarta.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletAddAddress", value = "/ServletAddAddress")
public class ServletAddAddress extends HttpServlet {
    @EJB
    private AppReposI repository;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String clientid = request.getParameter("clientid");
        PrintWriter out = response.getWriter();
        out.println("<html><body><center>");
        out.println("<Добавление данных устройства для клиента номер" + clientid + ":  </h1>");
        out.println(" </br>");
        out.println("<form action=\"ServletAddAddress\" method=\"post\" align=\"center\">");
        out.println("<table align=\"center\" cellpadding=\"3\" border=\"0\" cellspacing=\"0\">");

        out.println(" <tr><td>Данные клиента</td></tr>");
        out.println("<tr>");
        out.println("<td>client_id</td>");
        out.println("<td><input type=\"clientid\" name=\"clientid\" value=\"" +clientid+ "\" readonly></td>");
        //out.println("<td>" + clientid + "</td>");
        out.println("</tr>");


        out.println(" <tr><td>Данные устройства</td></tr>");

        out.println("<tr>");
        out.println("<td>Сетевой IP адрес устройства</td>");
        out.println("<td><input type=\"ip\" name=\"ip\" pattern=\"^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$\" placeholder=\"###.###.###.###\" required></td>");
        out.println("</tr>");
        out.println("<td>Физический MAC адрес устройства</td>");
        out.println("<td><input type=\"mac\" name=\"mac\" pattern=\"^([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})$\" placeholder=\"##:##:##:##:##:##\" required></td>");
        out.println("</tr>");
        out.println("</tr>");
        out.println("<td>Модель устройства</td>");
        out.println("<td><input type=\"model\" name=\"model\" maxlength=\"100\" placeholder=\"max 100 simbols\" required></td>");
        out.println("</tr>");
        out.println("</tr>");
        out.println("<td>Адрес места нахождения</td>");
        out.println("<td><input type=\"address\" name=\"address\" maxlength=\"200\" placeholder=\"max 200 simbols\" required></td>");
        out.println("</tr>");
        out.println("</tr>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" value=\"Добавить адресс\"></td>");
        out.println("</tr>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientid=Integer.parseInt((String)request.getParameter("clientid"));
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        ClientEntity client1 = repository.findClientById(clientid);
        AddressEntity address1 = new AddressEntity();
        address1.setIp(request.getParameter("ip"));
        address1.setMac(request.getParameter("mac"));
        address1.setModel(request.getParameter("model"));
        address1.setAddress(request.getParameter("address"));
        address1.setClient(client1);
        repository.createAddress(address1);
        //System.out.println(address1);
        response.sendRedirect("ServletViewList");
    }
}