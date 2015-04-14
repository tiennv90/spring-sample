<%@ include file="/views/headernoadvertising.jsp" %>    
    
    <div id="main">

        
        <section class="products-list">
            <div class="container">
                <!-- Heading Starts -->
                <h2 class="product-head">Deal of The Day </h2>
                <!-- Heading Ends -->
                <!-- Products Row Starts -->
                <div class="row">
					<c:forEach var="product" items="${products }">
			        	<div class="col-sm-6 col-md-3">
		                    <div class="thumbnail">
		                        <img src="${product.imageUrl }" alt="${product.name }">
		                        <div class="caption">
		                            <h3>${product.name }</h3>
		                            <p>$ ${product.discountPrice} &nbsp; &nbsp; &nbsp;  <strike>$ ${product.price }</strike></p>
		                            <p><a href="/cart/add?productId=${product.id}" class="btn btn-primary" role="button">Buy</a>
		                            </p>
		                        </div>
		                    </div>
		                </div>
		           </c:forEach>                 
                </div>
            </div>
        </section>



    </div>
    <!-- //Main -->
 <%@ include file="/views/footer.jsp" %>   
