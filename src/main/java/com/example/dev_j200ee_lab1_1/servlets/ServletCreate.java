package com.example.dev_j200ee_lab1_1.servlets;

import com.example.dev_j200ee_lab1_1.entities.AddressEntity;
import com.example.dev_j200ee_lab1_1.entities.ClientEntity;
import com.example.dev_j200ee_lab1_1.repository.AppReposI;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet(name = "ServletCreate", value = "/servlet-create")
public class ServletCreate extends HttpServlet {
    @EJB
    public AppReposI repository;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");


        PrintWriter out = response.getWriter();
        out.println("<html><body align=\"center\">");
        out.println("<h1> \"Создание новой записи\" </h1>");
        out.println("<br/>");
        out.println("<form action=\"servlet-create\" method=\"post\" align=\"center\">");
        out.println("<table align=\"center\" cellpadding=\"3\" border=\"0\" cellspacing=\"0\">");
        out.println("<tr>");
        out.println(" <td>Данные клиента</td>");
        out.println("</tr>");
//        out.println("<tr>");
//        out.println(" <td>cliendid</td>");
//        out.println("<td><input type=\"cliendid\" min=\"0\" name=\"cliendid\" required></td>");
//        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>client_name</td>");
        out.println("<td><input type=\"client_name\" name=\"client_name\" maxlength=\"100\" pattern=\"[\\u0401\\u0451\\u0410-\\u044f\\-\\,\\.\\s]\" placeholder=\"max 100 simbols\" required></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>type</td>");
        out.println("<td><select name=\"c_type\" id=\"c_type\" required>");
        out.println("<option value =\"\">-- Выберите тип --</option>");
        out.println("<option value =\"Юридическое лицо\">Юридическое лицо</option>");
        out.println("<option value =\"Физическое лицо\">Физическое лицо</option>");
        out.println("</select></td>");
        out.println("</tr>");
        out.println("<tr>");
//        out.println("<td>added</td>");
//        out.println("<td><input type=\"added\" name=\"Добавлен (дата)\" pattern=\"[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])\" placeholder=\"yyyy-mm-dd\" required></td>");
//        out.println("</tr>");
        out.println("<tr>");
        out.println(" <td>Данные устройства</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Сетевой IP адрес устройства</td>");
        out.println("<td><input type=\"ip\" name=\"ip\" pattern=\"^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$\" placeholder=\"###.###.###.###\" required></td>");
       // out.println("<td><a href=\"servlet-create\">Добавить</a></td>");
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
        //out.println("<td>Клиент</td>");
        //out.println("<td><input type=\"client\" name=\"client\" required></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" value=\"Записать\"></td>");
        //out.println("<td><input type=\"add\" value=\"Добавить адресс\"></td>");
        out.println("</tr>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        ClientEntity client1 = new ClientEntity();
        client1.setClientName(req.getParameter("client_name"));
        client1.setcType(req.getParameter("c_type"));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        client1.setAdded(timestamp);
        AddressEntity address1 = new AddressEntity();
        address1.setIp(req.getParameter("ip"));
        address1.setMac(req.getParameter("mac"));
        address1.setModel(req.getParameter("model"));
        address1.setAddress(req.getParameter("address"));
        address1.setClient(repository.createClient(client1));
        repository.createAddress(address1);
        System.out.println(address1);
        resp.sendRedirect("ServletViewList");

    }



    @Override
    public void destroy() {
        super.destroy();
    }
}
