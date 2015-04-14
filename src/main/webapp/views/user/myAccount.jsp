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
            <div>
            
            <h3>Welcome, ${user.firstName} ${user.lastName}</h3>
                <P>
                <c:if test="${not empty user.imageUrl}">
                <img src="${user.imageUrl}" alt="${user.firstName} ${user.lastName}">
                </c:if>
                    Name: ${user.firstName} ${user.lastName} <br>
                    Email: ${user.userName} <br>
                    Address: ${user.address}<br>
                </P>
                
            </div>
        </div>

    </div>
    <!--  -->
    <!--  -->
    <div id="main">
    
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

        <!-- c -->
    </div>
    <!-- //Main -->

<%@ include file="/views/footer.jsp" %>