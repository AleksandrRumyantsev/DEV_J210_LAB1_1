package com.example.dev_j210_lab1_1.servlets;

import com.example.dev_j210_lab1_1.entities.AddressEntity;
import com.example.dev_j210_lab1_1.entities.ClientEntity;
import com.example.dev_j210_lab1_1.repository.AppReposI;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletUpdate", value = "/ServletUpdate")
public class ServletUpdate extends HttpServlet {
    @EJB
    public AppReposI repository;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String clientid = request.getParameter("clientid");
        String addressid = request.getParameter("addressid");
        String operation = request.getParameter("operation");
        PrintWriter out = response.getWriter();
        ClientEntity client =repository.findClientById(Integer.parseInt(clientid));
        AddressEntity address = repository.findAddressById(Integer.parseInt(addressid));
        out.println("<html><body><center>");
        if ("update".equals(operation)) {
            out.println("<h1>Изменение данных клиента номер " + clientid + "</h1>");
        }else if ("addaddress".equals(operation)) {
            out.println("<h1>Добавление устройства к клиенту номер " + clientid + "</h1>");
        }
        out.println("<form action=\"ServletUpdate\" method=\"post\" align=\"center\">");
        out.println("<table align=\"center\" cellpadding=\"3\" border=\"0\" cellspacing=\"0\">");
        if ("update".equals(operation)) {

            out.println("<tr>");
            out.println(" <td>Данные клиента</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>client_name</td>");
            out.println("<td><input type=\"client_name\" value=\""+client.getClientName() +"\" name=\"client_name\" maxlength=\"100\" pattern=\"[а-яА-Я,.-]{1,100}\" placeholder=\"max 100 simbols\" required></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>type</td>");
            out.println("<td><select name=\"c_type\"  id=\"c_type\" required>");
            out.println("<option value =\""+client.getcType()+"\">"+client.getcType()+"</option>");
            out.println("<option value =\"Юридическое лицо\">Юридическое лицо</option>");
            out.println("<option value =\"Физическое лицо\">Физическое лицо</option>");
            out.println("</select></td>");
            out.println("</tr>");
            //out.println("<tr>");

        }
        out.println("<tr>");
        out.println(" <td>Данные устройства</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Сетевой IP адрес устройства</td>");
        out.println("<td><input type=\"ip\"");
        if ("update".equals(operation)) {out.println("value=\""+address.getIp() +"\"");}
        out.println("name=\"ip\" pattern=\"^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$\" placeholder=\"###.###.###.###\" required></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Физический MAC адрес устройства</td>");
        out.println("<td><input type=\"mac\"");
        if ("update".equals(operation)) {out.println("value=\""+address.getMac() +"\"");}
        out.println("name=\"mac\" pattern=\"^([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})$\" placeholder=\"##:##:##:##:##:##\" required></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Модель устройства</td>");
        out.println("<td><input type=\"model\"");
        if ("update".equals(operation)) {out.println("value=\""+address.getModel() +"\"");}
        out.println("name=\"model\" maxlength=\"100\" placeholder=\"max 100 simbols\" required></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Адрес места нахождения</td>");
        out.println("<td><input type=\"address\"");
        if ("update".equals(operation)) {out.println("value=\""+address.getAddress() +"\"");}
        out.println("name=\"address\" maxlength=\"200\" placeholder=\"max 200 simbols\" required></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<input type=\"hidden\" name=\"clientid\" value=\"" + clientid + "\">");
        out.println("<input type=\"hidden\" name=\"addressid\" value=\"" + addressid + "\">");
        out.println("<input type=\"hidden\" name=\"operation\" value=\"" + operation + "\">");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" value=\"");
        if ("update".equals(operation)) {
            out.println("Обновить данные");
        } else if ("addaddress".equals(operation)) {
            out.println("Добавить устройство");
        }
        out.println("\"></td></tr>");
        out.println("</form>");
        out.println("</center></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String clientid = request.getParameter("clientid");
        String addressid = request.getParameter("addressid");
        String operation = request.getParameter("operation");
        PrintWriter out = response.getWriter();
        ClientEntity client =repository.findClientById(Integer.parseInt(clientid));
        AddressEntity address = repository.findAddressById(Integer.parseInt(addressid));
        System.out.println(clientid+" : "+addressid+" : "+operation);
        System.out.println(client);
        System.out.println(address);
        if ("update".equals(operation)) {
            System.out.println("Update");
            client.setClientName(request.getParameter("client_name"));
            client.setcType(request.getParameter("c_type"));
            address.setIp(request.getParameter("ip"));
            address.setMac(request.getParameter("mac"));
            address.setModel(request.getParameter("model"));
            address.setAddress(request.getParameter("address"));
            repository.updateAddress(address);
            repository.updateClient(client);

            System.out.println(client);
            System.out.println(address);
        } else if ("addaddress".equals(operation)) {
            AddressEntity newAddress = new AddressEntity();
            newAddress.setIp(request.getParameter("ip"));
            newAddress.setMac(request.getParameter("mac"));
            newAddress.setModel(request.getParameter("model"));
            newAddress.setAddress(request.getParameter("address"));
            newAddress.setClient(repository.findClientById(Integer.parseInt(clientid)));
            repository.createAddress(newAddress);

        }
        response.sendRedirect("ServletViewList");
    }
}