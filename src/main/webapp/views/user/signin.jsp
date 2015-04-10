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
					    	document.location.href= obj.redirectUrl;
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
                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <img src="images/product/clothing/05.jpg" alt="">
                        <div class="caption">
                            <h3>Sleep Socks with Non-Skid Soles</h3>
                            <p>$7.95  &nbsp; &nbsp; &nbsp;  <strike>$16.95</strike></p>
                            <p><a href="#" class="btn btn-primary" role="button">Buy</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <img src="images/product/health/05.jpg" alt="">
                        <div class="caption">
                            <h3>Bed Buddy Hot and Cold Pack</h3>
                            <p>$8.95  &nbsp; &nbsp; &nbsp;  <strike>$16.95</strike></p>
                            <p><a href="#" class="btn btn-primary" role="button">Buy</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <img src="images/product/bath/05.jpg" alt="">
                        <div class="caption">
                             <h3>Extra Wide Tall-Ette Toilet Seat with Arms</h3>
                            <p>$50.95  &nbsp; &nbsp; &nbsp;  <strike>$100.95</strike></p>
                            <p><a href="#" class="btn btn-primary" role="button">Buy</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <img src="images/product/mobility/05.jpg" alt="">
                        <div class="caption">
                            <h3>Handirail Bedside Assistant Bed Safety Rail</h3>
                            <p>$40.95 &nbsp; &nbsp; &nbsp;  <strike>$80.95</strike></p>
                            <p><a href="#" class="btn btn-primary" role="button">Buy</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- c -->
</div>

<%@ include file="/views/footer.jsp" %>