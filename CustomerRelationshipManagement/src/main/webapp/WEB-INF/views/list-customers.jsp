<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	
<link href="style.css" rel="stylesheet">
<title>Customer Information</title>
</head>
<body>
     <div  class="container">
     
          <h2 style="text-align:center; background-color:MediumSeaGreen; font-weight:bold;">CUSTOMER RELATIONSHIP MANAGEMENT</h2>
          <hr>
     
           <a href="/CustomerRelationshipManagement/customer/showFormForAdd"
           class="btn btn-primary btn-sm mb-3">Add Customer</a>
     
     
           <table class="table table-bordered table-hover table-striped">
             <caption>List of customers</caption>
              <thead class="thead-light">
                   <tr>
              		  <th style="text-align:center;">#</th>
					  <th style="text-align:center;">First Name </th>
					  <th style="text-align:center;">Last Name</th>
					  <th style="text-align:center;">Email</th>
					  <th style="text-align:center;">Action</th>
                   </tr>
             </thead>
           
             <tbody>
                 <c:forEach items="${Customers}" var="tempCustomer"> 
                   <tr>
                      <td style="text-align:center;"><c:out value="${tempCustomer.id}"/></td>
                      <td style="text-align:center;"><c:out value="${tempCustomer.fName}"/></td>
                      <td style="text-align:center;"><c:out value="${tempCustomer.lName}"/></td>
                      <td style="text-align:center;"><c:out value="${tempCustomer.email}"/></td>
                      <td style="text-align:center;">
             				<!-- Add "update" button/link --> 
							<a href="/CustomerRelationshipManagement/customer/showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> 
							 
							<!-- Add "delete" button/link -->
							<a href="/CustomerRelationshipManagement/customer/delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">
								Delete </a>           
           			  </td>
                  </tr>
                  </c:forEach>
             </tbody>
                           
           </table>
     
      
     </div>
</body>
</html>