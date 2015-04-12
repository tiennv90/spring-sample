<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/admin/header.jsp" %>

    <div id="main">
    <p class="lead"> Feedbacks </p>
		<table class="table table-bordered">
				<tr id="header">
					<th>ID</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Feedback</th>
				</tr>
				
				<c:forEach var="f" items="${feedbacks}">
					<tr id="rows-data">
						<td>${f.id}</td>
						<td>${f.name }</td>	
						<td>${f.phoneNumber}</td>
						<td>${f.email}</td>
						<td>${f.feedback}</td>		
					</tr>			
				</c:forEach>			
		</table>
    </div>
    <!-- //Main -->	
<%@ include file="/views/footer.jsp" %>