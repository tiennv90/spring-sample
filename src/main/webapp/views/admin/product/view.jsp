<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/admin/header.jsp" %>

    <div id="main">
    <p class="lead"> Products </p>
		<table class="table table-bordered">
				<tr id="header">
					<th>ID</th>
					<th>Name</th>
					<th>Image</th>
					<th>Price</th>
					<th>Category</th>
					<th>Discount Price</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="p" items="${products}">
					<tr id="rows-data">
						<td>${p.id}</td>
						<td>${p.name }</td>	
						<td>
							<img src="${p.imageUrl}"/>
						</td>
						<td>$ ${p.price }</td>
						<td>${p.category.name }</td>
						<td>
							<c:if test="${not empty p.discountPrice }">
								$ ${p.discountPrice}
							</c:if>
						</td>
						<td><a href="#" class="btn btn-default btn-sm active" role="button">Edit</a>
						<a href="#" class="btn btn-default btn-sm active" role="button">Delete</a></td>		
					</tr>			
				</c:forEach>			
		</table>
    </div>
    <!-- //Main -->	
<%@ include file="/views/footer.jsp" %>