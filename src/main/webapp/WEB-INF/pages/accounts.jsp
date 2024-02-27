<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="client.demo.dto.cavab.CavabHesab" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Account List</title>
</head>
<body>
    <h2>Account List</h2>
    <table border="1">
        <tr>
            <th>Account id</th>
            <th>Account owners fullname </th>
            <th>Account No</th>
            <th>Iban</th>
            <th>Balance</th>
            <th>Currency</th>
            <th>Created at</th>
        </tr>
        <% List<CavabHesab> hesablar = (List<CavabHesab>) request.getAttribute("accounts");
           for (CavabHesab hesab : hesablar) { %>
              <tr>
                  <td><%= hesab.getHesabId() %></td>
                  <td><%= hesab.getCavabMusteri().getName()+" "+hesab.getCavabMusteri().getSurname() %></td>
                  <td><%= hesab.getHesabNo() %></td>
                  <td><%= hesab.getIban() %></td>
                  <td><%= hesab.getBalance() %></td>
                  <td><%= hesab.getValyuta() %></td>
                  <td><%= hesab.getData_date() %></td>
              </tr>
        <% } %>
    </table>
</body>
</html>


