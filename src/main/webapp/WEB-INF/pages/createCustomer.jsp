<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
   <c:if test="${not empty message}">
        <div style= "margin-bottom: 10px">
             <p style="color: red">${message}</p>

        </div>
   </c:if>
          <form action="${pageContext.request.contextPath}/musteri/create" method="POST">
              <div style="margin-bottom: 10px" >
                                   <label>Name</label>
                                   <input type="text" name="name" placeholder="Enter name">
                            </div>
                            <div style="margin-bottom: 10px">
                                   <label>Surname</label>
                                   <input type="text"  name="surname"placeholder="Enter surname">
                            </div>
                            <div style="margin-bottom: 10px">
                                    <label>Address</label>
                                    <input type="text" name="address" placeholder="Enter address">
                            </div>
                            <div style="margin-bottom: 10px">
                                    <label>Dob</label>
                                    <input type="text" name="dob" placeholder="Enter DOB yyyy-mm-dd">
                            </div>
                            <div style="margin-bottom: 10px">
                                    <label>Phone</label>
                                    <input type="text" name="phone" placeholder="Enter phone">
                            </div>
                            <div style="margin-bottom: 10px">
                                    <label>Pin</label>
                                    <input type="text" name="pin" placeholder="Enter pin">
                            </div>
                             <div style="margin-bottom: 10px">
                                     <label>Seria</label>
                                     <input type="text" name="seria" placeholder="Enter seria">
                             </div>
                             <div style="margin-bottom: 10px">
                                      <label>Cif</label>
                                      <input type="text" name="cif" placeholder="Enter cif">
                             </div>
                             <div style="margin-bottom: 10px">
                                       <label>Gender</label>
                                       <input type="text" name="gender" placeholder="Enter gender">
                             </div>
                        <button type="submit">Submit</button>
              </div>
          </form>
</body>
</html>