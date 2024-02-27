<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="client.demo.dto.cavab.CavabMusteri" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
   <c:if test="${not empty message}">
        <div style= "margin-bottom: 10px">
             <p style="color: red">${message}</p>
        </div>
   </c:if>
<a href="${pageContext.request.contextPath}/musteri/add"><input type="button" value="ADD NEW CUSTOMER"></a> <br>
    <h2>Customer List</h2>
    <table border="1">
        <tr>
            <th>Customer id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Address</th>
            <th>Dob</th>
            <th>Phone</th>
            <th>Pin</th>
            <th>Seria</th>
            <th>Cif</th>
            <td>view account</td>
        </tr>
        <% List<CavabMusteri> musteriList = (List<CavabMusteri>) request.getAttribute("musteriler");
                 for (CavabMusteri musteri : musteriList) { %>
                  <tr>
                      <td><%= musteri.getMusteriId() %></td>
                      <td><%= musteri.getName() %></td>
                      <td><%= musteri.getSurname() %></td>
                      <td><%= musteri.getAddress() %></td>
                      <td><%= musteri.getDob() %></td>
                      <td><%= musteri.getPhone() %></td>
                      <td><%= musteri.getPin() %></td>
                      <td><%= musteri.getSeria() %></td>
                      <td><%= musteri.getCif() %></td>
                      <td><a href="${pageContext.request.contextPath}/hesab?musteriId=<%=musteri.getMusteriId()%>">view account </a></td>                  </tr>
       <% } %>
    </table>
</body>
</html>