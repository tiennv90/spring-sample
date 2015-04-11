<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/header.jsp" %>

    <div id="main">

		<c:forEach var="order" items="${orders }">
	      <section class="products-list">
	          <div class="container">
	              <!-- Heading Starts -->
	              <span style="font-weight: bold; color: #A52222; font-size: 20px;" class="product-head">ID Order: ${order.id} </span>
				  <a style="margin-left: 20px; color: #777777; font-weight:bold;" href="#">Delete</a>
	              <!-- Heading Ends -->
	              <c:set var="products" value="${order.products}"/>
	              <!-- Products Row Starts -->      
	               <div class="row">
	               	   <c:forEach var="product" items="${products}">
		                  <div class="col-sm-6 col-md-3">
		                      <div style="width: 150px;" class="thumbnail">
		                          <img src="${product.imageUrl}" alt="${product.name }">
		                          <div class="caption">
		                              <h3 style="font-size: 13px;">${product.name }</h3>
		                              <p style="color: #A52222;">$ ${product.price }</p>
		                          </div>
		                      </div>
		                  </div>                	   
	               	   </c:forEach>
	              		
	               </div>  	
	          </div>
	        </section>  		
			<hr style="width: 95%; background-color: #A52222; height: 2px; border: 0;">
		</c:forEach>
 	</div>
  <!-- //Main -->

<%@ include file="/views/footer.jsp" %>