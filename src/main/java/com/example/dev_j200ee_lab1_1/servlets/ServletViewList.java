package com.example.dev_j200ee_lab1_1.servlets;

import com.example.dev_j200ee_lab1_1.entities.AddressEntity;
import com.example.dev_j200ee_lab1_1.entities.ClientEntity;
import com.example.dev_j200ee_lab1_1.repository.AppReposI;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletViewList", value = "/ServletViewList")
public class ServletViewList extends HttpServlet {

    @EJB
    private AppReposI clientService;
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
        // <Client, List<Address>> clientMap = new HashMap<>();
        //clientMap = filter(clientService.getAllClients(), filterParam);
        String filterType = request.getParameter("filtertype");
        List<ClientEntity> clientEntities = clientService.getClients(filterParam,filterType);
//        if (filterParam == null){filterParam = "";}
//        for (ClientEntity client: clientEntities) {
//            for (AddressEntity address : client.getAddressEntityList()) {
//                if (address.getAddress().contains(filterParam)){
//                    client.getAddressEntityList().remove(address);
//                }
//            }
//        }

        //List<AddressEntity> addressEntities = clientService.(DomainEntity.class);
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><center>");
        out.println("<h1>Все клиенты</h1>");
        out.println("<form action=\"ServletViewList\" method=\"get\" align=\"center\">\n");
        out.println("    <select name=\"filtertype\">");
        out.println("            <option value=\"\" selected enabled hidden>не выбран</option>");
        out.println("            <option value=\"Юридическое лицо\">Юридическое лицо</option>");
        out.println("            <option value=\"Физическое лицо\">Физическое лицо</option>");
        out.println("    </select>");
        out.println(       "    <input type=\"text\" name=\"filter\">\n" );
        out.println(        "    <input type=\"submit\" value=\"Filter\">\n" );
        out.println(        "</form><br><br>");
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
        out.println("<th>Delete</th>");
        out.println("<th>Update</th>");
        out.println("<th>Add address</th>");
        out.println("</tr>");
        for (ClientEntity client: clientEntities){
            for(AddressEntity address : client.getAddressEntityList()) {
                out.println("<tr>");
                out.println("<td>" + client.getClientid() + "</td>");
                out.println("<td>" + client.getClientName() + "</td>");
                out.println("<td>" + client.getcType() + "</td>");
                out.println("<td>" + client.getAdded() + "</td>");
                out.println("<td>" + address.getIp() + "</td>");
                out.println("<td>" + address.getMac() + "</td>");
                out.println("<td>" + address.getModel() + "</td>");
                out.println("<td>" + address.getAddress() + "</td>");
                out.println("<td>  <a href=\"ServletDelete?clientid=" + client.getClientid() + "&amp;addressid="+ address.getAddressid() + "\">Delete</a></td>");
                out.println("<td>  <a href=\"ServletUpdate?clientid=" + client.getClientid() + "&amp;addressid="+ address.getAddressid() + "\">Update</a></td>");
                out.println("<td>  <a href=\"ServletAddAddress?clientid=" + client.getClientid() + "\">Add address</a></td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");
        out.println(" <br> </br>");
        out.println("<form action=\"servlet-create\" method=\"get\" align=\"center\">");
        out.println("<button  onclick=\"href=\"servlet-create\">Create<//button>");
        out.println("</form>");
        out.println("</center></body></html>");
    }
//    private Map<Client, List<Address>> filter(List<Client> clients, String filterparam){
//        Map<Client, List<Address>> clientMap = new HashMap<>();
//        for (Client client : clients) {
//            clientMap.put(client, client.getAddresses());
//        }
//        if(filterparam!=null && !filterparam.isEmpty()) {
//            Iterator<Client> clientIter = clientMap.keySet().iterator();
//            while (clientIter.hasNext()){
//                Client client = clientIter.next();
//                if(!client.getClient_name().toLowerCase().contains(filterparam.toLowerCase())){
//                    Iterator<Address> addressIter = clientMap.get(client).iterator();
//                    while (addressIter.hasNext()){
//                        Address address = addressIter.next();
//                        if(!(address.getMac() + "" + address.getModel()).contains(filterparam)){
//                            addressIter.remove();
//                        }
//                    }
//                    if(clientMap.get(client).size()==0) clientIter.remove();
//                }
//            }
//        }
//        return clientMap;
//    }
}
