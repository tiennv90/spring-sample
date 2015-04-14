<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/views/header.jsp" %> 

    <div id="main">
        <section class="products-list">
            <div class="container">
                <!-- Heading Starts -->
                <h2 class="product-head">${category.name}</h2>
                <!-- Heading Ends -->
                <!-- Products Row Starts -->
                <div class="row">
                	<c:set var="count" value="0"/>
					<c:forEach var="product" items="${category.products }">
						<c:if test="${count < 4 })">
				        	<div class="col-sm-6 col-md-3">
			                    <div class="thumbnail">
			                        <img src="${product.imageUrl }" alt="${product.name }">
			                        <div class="caption">
			                            <h3>${product.name }</h3>
			                            <p>$ ${product.price }</p>
			                            <p><a href="/cart/add?productId=${product.id}" class="btn btn-primary" role="button">Buy</a>
			                            </p>
			                        </div>
			                    </div>
			                </div>
			                <c:set var="count" value="${count + 1}"/>
		                </c:if>
		           </c:forEach>     
                </div>
            </div>
        </section>
        <!-- c -->
    </div>

    <!-- //Main -->
 <%@ include file="/views/footer.jsp" %>  