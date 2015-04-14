<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/header.jsp" %>

    <!--  -->
    <!--  -->
	<script type="text/javascript">
		
		jQuery(document).ready(function() {
	 
			jQuery('#feedback').submit(function(e) {
				e.preventDefault();
				
				var str = jQuery("#feedback").serialize();
				
				jQuery.ajax({
				    type:"post",
				    data:str,
				    url:"/feedback/save",
				    async: false,
				    success: function(response){
				       alert("Your feedback was sent " + response + "!");
				       document.location.href="/";
				    }
				});
			});
		});
	</script>
    
    <div class="container">
        <div class="col-xs-6 col-xs-offset-3  feedback">

            <form:form modelAttribute="feedback" method="post" id="feedback" >
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="name" class="form-control" placeholder="Name" />
                </div>
                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <form:input path="phoneNumber" class="form-control" placeholder="Phone Number" />
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <form:input path="email" class="form-control" placeholder="Enter your Email" />
                </div>
                <div class="form-group">
                    <label for="feedback">Feedback</label>
                    <form:textarea rows="3" path="feedback" class="form-control" placeholder="Feedback" />
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
             </form:form>   
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