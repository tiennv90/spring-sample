<%@ include file="/views/header.jsp" %>

<div class="container">
    <div class="col-xs-6 col-xs-offset-3  sign_in">
        <h3>Sign In </h3>
        
		<script type="text/javascript">
			
			jQuery(document).ready(function() {
		 
				jQuery('#login').submit(function(e) {
					e.preventDefault();
					
					var str = jQuery("#login").serialize();
					
					jQuery.ajax({
					    type:"post",
					    data:str,
					    url:"/login",
					    success: function(response){
					    	var obj = JSON.parse(response);
					    	if (obj.success === true) {
					    		window.alert("Login Successfully !");
					    		document.location.href= obj.redirectUrl;
					    	} else {
					    		window.alert(obj.errorMessage);
					    	}
					    }
					});
				});
			});
		</script>        
        
        <form method="post" id="login" class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3">Email</label>

                <input type="email" name="userName" class="form-control" id="inputEmail3" placeholder="Email">

            </div>
            <div class="form-group">
                <label for="inputPassword3">Password</label>
                
                    <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
               
            </div>
            <div class="form-group">
                
                  
                        <label>
                            <input type="checkbox"> Remember me
                        </label>
                 
               
            </div>
            <div class="form-group">
                
                    <button type="submit" class="btn btn-default">Sign in</button>
                
                
                    <p>
                        <a href="#">Forgot Your Password? </a> <span> Don't have an account?</span> <a href="/user/create">Sign Up</a>
                    </p>
                </div>
        </form>
    </div>
</div>
<!--  -->
<!--  -->

<div id="main">
        <section class="products-list">
            <div class="container">
                <!-- Heading Starts -->
                <h2 class="product-head">SPECIALS PRODUCTS </h2>
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

<%@ include file="/views/footer.jsp" %>