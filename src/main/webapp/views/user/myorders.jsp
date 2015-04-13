<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/header.jsp" %>

    <div class="container">
        <div class="col-sm-3 col-md-2 sidebar">
            <h3>My Account</h3>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/user/myaccount">View Profile <span class="sr-only">(current)</span></a>
                </li>
                <li><a href="/user/edit">Edit Profile</a></li>
            </ul>
            <h3>My Orders</h3>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/user/myorders">View Orders</a>
                </li>
            </ul>

        </div>
        
        <div class="col-sm-9 col-md-10 mainarea">
		    <div id="main">
		    <c:choose>
				<c:when test="${not empty orders}">
					<c:forEach var="order" items="${orders }">
					  <c:set var="products" value="${order.products}"/>
					  <c:if test="${not empty  products}">
					      <section class="products-list">
					          <div class="container">
					              <!-- Heading Starts -->
					              <span style="font-weight: bold; color: #A52222; font-size: 20px;" class="product-head">ID Order: ${order.id} </span>
								  | <a style=" color: #777777; font-weight:bold;" href="/orders/remove?orderId=${order.id}">Cancel Order</a>
					              <!-- Heading Ends -->
					              <!-- Products Row Starts -->      
					               <div class="row">
					               	   <c:forEach var="product" items="${products}">
						                  <div class="col-sm-6 col-md-3">
						                      <div style="width: 150px;" class="thumbnail">
						                          <img src="${product.imageUrl}" alt="${product.name }">
						                          <div class="caption">
						                              <h3 style="font-size: 13px;">${product.name }</h3>
						                              <p style="color: #A52222;">$ ${product.price }</p>
						                              <p><a href="/orders/${order.id}/removeproduct?productId=${product.id }" class="btn btn-primary" role="button">Remove</a>
						                          </div>
						                      </div>
						                  </div>                	   
					               	   </c:forEach>
					              		
					               </div>  	
					          </div>
					        </section>  		
							<hr style="width: 95%; background-color: #A52222; height: 2px; border: 0;">
						</c:if>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>There are no orders</h3>
				</c:otherwise>
			</c:choose>	
		 	</div>        
        </div>
            	
    </div>
  <!-- //Main -->

<%@ include file="/views/footer.jsp" %>