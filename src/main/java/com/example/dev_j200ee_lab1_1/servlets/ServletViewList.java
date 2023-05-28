package com.example.dev_j200ee_lab1_1.servlets;

import com.example.dev_j200ee_lab1_1.model.Address;
import com.example.dev_j200ee_lab1_1.model.Client;
import com.example.dev_j200ee_lab1_1.sevices.ClientService;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "ServletViewList", value = "/ServletViewList")
public class ServletViewList extends HttpServlet {

    @EJB
    private ClientService clientService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        sendResponse(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendResponse(request, response);
    }
    private void sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filterParam = request.getParameter("filter");
        Map <Client, List<Address>> clientMap = new HashMap<>();
        clientMap = filter(clientService.getAllClients(), filterParam);
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Все клиенты</h1>");
        out.println("<form action=\"ServletViewList\" method=\"get\" align=\"center\">\n" +
                "    <input type=\"text\" name=\"filter\">\n" +
                "    <input type=\"submit\" value=\"Filter\">\n" +
                "</form><br><br>");
        out.println("<table align=\"center\" cellpadding=\"5\" border=\"1\" cellspacing=\"0\">");
        out.println("<tr>");
        out.println("<th>client ID</th>");
        out.println("<th>Client's name</th>");
        out.println("<th>Type</th>");
        out.println("<th>Date add</th>");
        out.println("<th>IP Adresses</th>");
        out.println("<th>MAC</th>");
        out.println("<th>Model</th>");
        out.println("<th>Address</th>");
        out.println("</tr>");
        for(Client client : clientMap.keySet()){
            if(client.getAddresses().size()>0) {
                for(Address address : clientMap.get(client)) {
                    out.println("<tr>");
                    out.println("<td>" + client.getClientid() + "</td>");
                    out.println("<td>" + client.getClient_name() + "</td>");
                    out.println("<td>" + client.getType() + "</td>");
                    out.println("<td>" + client.getAdded() + "</td>");
                    out.println("<td>" + address.getIp() + "</td>");
                    out.println("<td>" + address.getMac() + "</td>");
                    out.println("<td>" + address.getModel() + "</td>");
                    out.println("<td>" + address.getAddress() + "</td>");
                    out.println("</tr>");
                }
            }else {
                out.println("<tr>");
                out.println("<td>" + client.getClientid() + "</td>");
                out.println("<td>" + client.getClient_name() + "</td>");
                out.println("<td>" + client.getType() + "</td>");
                out.println("<td>" + client.getAdded() + "</td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
        out.println("</body></html>");
    }
    private Map<Client, List<Address>> filter(List<Client> clients, String filterparam){
        Map<Client, List<Address>> clientMap = new HashMap<>();
        for (Client client : clients) {
            clientMap.put(client, client.getAddresses());
        }
        if(filterparam!=null && !filterparam.isEmpty()) {
            Iterator<Client> clientIter = clientMap.keySet().iterator();
            while (clientIter.hasNext()){
                Client client = clientIter.next();
                if(!client.getClient_name().toLowerCase().contains(filterparam.toLowerCase())){
                    Iterator<Address> addressIter = clientMap.get(client).iterator();
                    while (addressIter.hasNext()){
                        Address address = addressIter.next();
                        if(!(address.getMac() + "" + address.getModel()).contains(filterparam)){
                            addressIter.remove();
                        }
                    }
                    if(clientMap.get(client).size()==0) clientIter.remove();
                }
            }
        }
        return clientMap;
    }
}
