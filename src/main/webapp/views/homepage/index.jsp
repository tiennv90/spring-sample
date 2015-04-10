<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/views/header.jsp" %>

<div id="main">

	<c:forEach var="category" items="${top5Categories}">
		 <section class="products-list">
		 	<div class="container">
		 		 <h2 class="product-head">${category.name} </h2>
	            <!-- Products Row Starts -->
	            <div class="row">
	            	<c:set var="products" value="${category.products}" />
	            	<c:set var="count" value="0" />
	            	<c:forEach var="product" items="${products}" >
	            		
	            		<c:if test="${count <= 3 }">
				        	<div class="col-sm-6 col-md-3">
			                    <div class="thumbnail">
			                        <img src="${product.imageUrl }" alt="${product.name }">
			                        <div class="caption">
			                            <h3>${product.name }</h3>
			                            <p>${product.price }</p>
			                            <p><a href="#" class="btn btn-primary" role="button">Buy</a>
			                            </p>
			                        </div>
			                    </div>
			                </div>
		                </c:if>
		                
		                <c:set var="count" value="${count + 1}" scope="page"/>
	            	</c:forEach>	 	
	            </div>	 
		 	</div>
		 </section>
	</c:forEach>
</div>

<%@ include file="/views/footer.jsp" %>