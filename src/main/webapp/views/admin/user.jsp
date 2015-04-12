<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/admin/header.jsp" %>

    <div id="main">
    <p class="lead"> Users </p>
		<table class="table table-bordered">
				<tr id="header">
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Image</th>
					<th>Address</th>
					<th>Products Ordered</th>
				</tr>
				
				<c:forEach var="u" items="${users}">
					<tr id="rows-data">
						<td>${u.id}</td>
						<td>${u.firstName }</td>	
						<td>${u.lastName}</td>
						<td>${u.email}</td>
						<td>${u.imageUrl}</td>
						<td>${u.address}</td>	
						<td>
							<c:set var="orders" value="${u.orders}" />
							<ul>
								<c:forEach var="order" items="${orders}">
									<c:forEach var="product" items="${order.products}">
										<li>${product.name}</li>
									</c:forEach>
								</c:forEach>
							</ul>
						</td>	
					</tr>			
				</c:forEach>			
		</table>
    </div>
    <!-- //Main -->	
<%@ include file="/views/footer.jsp" %>