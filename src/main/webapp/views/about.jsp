<%@ include file="/views/header.jsp" %>

    <div id="main">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">

                </div>

                <div class="col-sm-9">
                    <h3>About Us</h3>
                    <p>
                        We believe that aging should not be a burden for the individual and family. Rather, the Prime Time years are opportunities to meet new challenges, and we help you with merchandise and solutions - regardless of the physical effects of the aging process. We provide ways for seniors to live more independently, safely, and with more comfort and dignity.
                        <br> This website is exclusively designed for the elderly and catering only to their needs.

                    </p>
                </div>
            </div>
        </div>

        <section class="products-list">
            <div class="container">
                <!-- Heading Starts -->
                <h2 class="product-head">SPECIALS PRODUCTS</h2>
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