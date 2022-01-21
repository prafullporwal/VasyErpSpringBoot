<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Lists</title>
<script type="text/javascript">
	function showForm() {
		document.getElementById("addCustomer").style.visibility = "visible";
	}

	function addCustomer() {
		if (confirm("Are you sure you want to add customer.")) {
			document.getElementById("customersForm").action = 'addOrUpdateCustomer';
			document.getElementById("customersForm").method = 'post';
			document.customersForm.submit();
			document.getElementById("addCustomer").style.visibility = "hidden";
		}

	}
	function updateCustomer(selectedValue) {
		if (confirm("Are you sure you want to update customer " + selectedValue)) {
			document.getElementById("selectedCustomer").value = selectedValue;
			document.getElementById("customersForm").action = 'addOrUpdateCustomer';
			document.getElementById("customersForm").method = 'post';
			document.customersForm.submit();
		}
	}
	function editable(selectedValue) {
		var checkBox = document.getElementById("editCheck" + selectedValue);
		if (checkBox.checked == true) {
			document.getElementById("name" + selectedValue).removeAttribute('readonly');
			document.getElementById("mobile_no" + selectedValue).removeAttribute('readonly');
			document.getElementById("Email_id" + selectedValue).removeAttribute('readonly');
			document.getElementById("edit" + selectedValue).disabled=false;
		} else {
			document.getElementById("name" + selectedValue).readOnly=true;
			document.getElementById("mobile_no" + selectedValue).readOnly=true;
			document.getElementById("Email_id" + selectedValue).readOnly=true;
			document.getElementById("edit" + selectedValue).disabled=true;
		}
	}
	function deleteCustomer(selectedValue) {
		if (confirm("Are you sure you want to delete customer " + selectedValue)) {

			document.getElementById("selectedCustomer").value = selectedValue;
			document.getElementById("customersForm").action = 'deleteCustomer';
			document.getElementById("customersForm").method = 'post';
			document.customersForm.submit();
		}

	}
	function addAddress() {
		document.getElementById("addresses").style.display='block';
		var inputAddress = document.getElementById("addresses");
		//var row =document.createElement("tr");
		 var x = document.createElement("td");
		  //var t = document.createTextNode("new cell");
		  x.innerHTML = "<input type='text' name='address' />  ";
		// x.appendChild(t);
		  document.getElementById("addresses").appendChild(x);
		//inputAddress.
	}
	
	
	function editAddress(selectedValue)
	{
		var checkBox = document.getElementById("addressId" + selectedValue);
		if (checkBox.checked == true) {
			document.getElementById("address" + selectedValue).removeAttribute('readonly');
			
		} else {
			document.getElementById("address" + selectedValue).readOnly=true;
			
		}
	}
</script>
<style type="text/css">
.button {
	background-color: blue;
	color: white;
	font-weight: bold;
}
</style>

</head>
<body>
	<form name="customersForm" id="customersForm" action="" method="post">
		<input type="hidden" id="selectedCustomer" value=""
			name="selectedCustomer" />
		<div align='center'>
			<header style="background-color: aqua; font-weight: bold;">
				<h2>Customers List</h2>
			</header>
		</div>

		<div id='Customers' align="center">
			<table border="1" style="width: 80%;">
				<tr style="background-color: silver;">
					<th>Name</th>
					<th>Mobile</th>
					<th>Email Id</th>

					<th>Addresses</th>
					<th>Id</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="customer" items="${Customers}">
					<tr align="center">
						<td><input type="text" name="name${customer.customerId}"
							id="name${customer.customerId}" value="${customer.name}"  readonly="readonly"/></td>
						<td><input type="text" name="mobile_no${customer.customerId}"
							id="mobile_no${customer.customerId}" value="${customer.mobileNo}" readonly="readonly" /></td>
						<td><input type="text" name="Email_id${customer.customerId}"
							id="Email_id${customer.customerId}" value="${customer.emailid}" readonly="readonly" /></td>
						<td><c:forEach var="customerAddress"
								items="${customer.addresses}">
								<input type="checkbox" name="addressId" id="addressId${customerAddress.addressId}"
									value="${customerAddress.addressId}"
									onchange="editAddress(${customerAddress.addressId})" />
								<input type="text" id="address${customerAddress.addressId}"
									name="address${customerAddress.addressId}"
									value="${customerAddress.address}" readonly="readonly" />
								<br>
							</c:forEach></td>
						<td><input size='3' type="text"
							value="${customer.customerId}" readonly="readonly" /></td>
						<td align="center">
						<input type="checkbox"
							id="editCheck${customer.customerId}"
							onchange="editable('${customer.customerId}')"><input
							type="button" id="edit${customer.customerId}"
							name="edit${customer.customerId}" class="button" value="Edit"
							onclick="updateCustomer('${customer.customerId}');"
							disabled="disabled"></td>
						<td align="center"><input type="button" class="button"
							value="Delete"
							onclick="deleteCustomer('${customer.customerId}');"></td>

					</tr>
				</c:forEach>
				<tr style="background-color: brown">
					<td colspan="3" align="center"><input type="button"
						class="button" value="Add Customer" onclick="showForm();"></td>
				</tr>
			</table>
		</div>
		<br>
		<div id='addCustomer' style="visibility: hidden" align="center">
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name='name' id="name" /></td>
				</tr>
				<tr>
					<td>Mobile No:</td>
					<td><input type="text" name='mobile_no' id="mobile_no" /></td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td><input type="text" name='Email_id' id="Email_id" /></td>
				</tr>

				
				
			<tr style="display: block" id="addresses">
					<td>Address</td>

				</tr>
			<tr>
					<td colspan="2"><input type="button" value="Add Address"
						onclick="addAddress()" /></td>
				</tr>
				
				
				<tr>
					<td colspan="2" align="center"><input type="button"
						value="Add" class="button" onclick="addCustomer();" /></td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>