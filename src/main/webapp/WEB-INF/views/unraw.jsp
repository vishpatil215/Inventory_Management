<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.List" %>
  <%@ page import="com.Model.RawMaterial" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Dashboard</title>
  </head>
  <body>
    	<div class="container">
    	
    		<div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills">
      <li class="nav-item">
	<select class="nav-link active" onchange="location = this.value;">
	    <option >Add Material</option>
	    <option value="rawM">Add Raw Material</option>
	    <option value="procesM">Add Processed Material</option>
	  </select>
      </li>
      <li class="nav-item">
        <select class="nav-link active" onchange="location = this.value;">
	    <option >View Material</option>
	    <option value="viewRaw">View Raw Material</option>
	    <option value="viewPro">View Processed Material</option>
	  </select>
      </li>
      <li class="nav-item">
        <select class="nav-link active" onchange="location = this.value;">
	    <option >Logs</option>
	    <option value="viewlograw">Raw Material</option>
	    <option value="viewlogpro">Processed Material</option>
	  </select>
      <li class="nav-item">
        <select class="nav-link active" onchange="location = this.value;">
	    <option >Unavailable Materials</option>
	    <option value="unraw">Raw Material</option>
	    <option value="unpro">Processed Material</option>
	  </select>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="">Log out</a>
      </li>
    </ul>
  </div>
  </div>
</div>
<br><br>
<center>
 <h3 class="card-title">Unavailable Raw Material</h3>
    <br><br>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
		<th scope="col">Name</th>
		<th scope="col">Quantity</th>
		<th scope="col">Unit</th>
		<th scope="col">Cost per unit</th>
		<th scope="col"></th>
		<th scope="col">Action</th>
		<th scope="col"></th>
    </tr>
  </thead>
  
  <%
	List<RawMaterial> rawMaterial = (List<RawMaterial>) request.getAttribute("rawMaterial");
	for(RawMaterial rm : rawMaterial)
	{
		if(rm.getQuantity()==0)
		{
	%>
  
  <tbody>
    <tr>
		<td><%=rm.getId() %></td>
		<td><%=rm.getName() %></td>
		<td><%=rm.getQuantity() %></td>
		<td><%=rm.getUnit()%></td>
		<td><%=rm.getCostPerUnit() %></td>
		<td>
			<a href="delete/<%=rm.getId()%>">Delete</a>
			</td>
			 <td>
			<a href="updateR?id=<%=rm.getId()%>">update</a>
			</td>
			 <td>
			<a href="issueR?tid=<%=rm.getId()%>">Issue</a>
			</td>
    </tr>
   </tbody>
   <%
  }}
   %>
</table>
</center>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>


