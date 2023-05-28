package com.example.dev_j200ee_lab1_1.servlets;

import com.example.dev_j200ee_lab1_1.model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "ServletCreate", value = "/servlet-create")
public class ServletCreate extends HttpServlet {

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
        out.println("<td><select name=\"type\" id=\"type-select\" required>");
        out.println("<option value =\"\">-- Выберите тип --</option>");
        out.println("<option value =\"urik\">Юридическое лицо</option>");
        out.println("<option value =\"fizik\">Физическое лицо</option>");
        out.println("</select></td>");
        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>added</td>");
//        out.println("<td><input type=\"added\" name=\"Добавлен (дата)\" pattern=\"[0-9]{2}.[0-9]{2}.[0-9]{4}\" placeholder=\"##.##.####\" required></td>");
//        out.println("</tr>");
        out.println("<tr>");
        out.println(" <td>Данные устройства</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Сетевой IP адрес устройства</td>");
        out.println("<td><input type=\"IP\" name=\"IP\" pattern=\"^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$\" placeholder=\"###.###.###.###\" required></td>");
       // out.println("<td><a href=\"servlet-create\">Добавить</a></td>");
        out.println("</tr>");
        out.println("<td>Физический MAC адрес устройства</td>");
        out.println("<td><input type=\"MAC\" name=\"MAC\" pattern=\"^([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})$\" placeholder=\"##:##:##:##:##\" required></td>");
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
        String clientid = req.getParameter("cliendid");
        String client_name = req.getParameter("client_name");
        String type = req.getParameter("type");
        String added = req.getParameter("added");
        String IP = req.getParameter("IP");
        String MAC = req.getParameter("MAC");
        String model = req.getParameter("model");
        String address = req.getParameter("address");
        String client = req.getParameter("client");
        //out.println(clientid?c);
        //Client client1 = new Client(clientid, )
    }



    @Override
    public void destroy() {
        super.destroy();
    }
}
