<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/header.jsp" %>

	<script type="text/javascript">
		
		jQuery(document).ready(function() {
	 
			jQuery('#user').submit(function(e) {
				e.preventDefault();
				
				var str = jQuery("#user").serialize();
				
				jQuery.ajax({
				    type:"post",
				    data:str,
				    url:"/user/create",
				    async: false,
				    success: function(response){
				       var result = JSON.parse(response);
				       if (result.success === true) {
				    	   window.alert('User created successfully !');
				    	   document.location.href="/";
				       } else {
				    	   window.alert(result.errorMessage);
				       }
				       
				    }
				});
			});
		});
	</script>

    <div class="container">
        <div class="col-xs-6 col-xs-offset-3  creat_account">
            <h3>Create an Account</h3>
            <form:form modelAttribute="user" method="post" id="user">
                <div class="form-group">
                    <label for="fname">First Name</label>
                    <form:input path="firstName" id="fname" placeholder="First Name" class="form-control"/>
                    <label for="lname">Last Name</label>
                    <form:input path="lastName" id="lname" placeholder="Last Name" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="email1">Email</label>
                    <form:input path="userName" id="userName" placeholder="Email" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="pass">Password</label>
                    <form:password path="password" id="pass" placeholder="Password" class="form-control"/>
                    <label for="passAgain">Re-Enter Password</label>
                    <form:password path="repassword" id="passAgain" placeholder="Re-Enter Password" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <form:input path="address" id="address" placeholder="Address" class="form-control"/>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-default">Create Account</button>
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
                <h2 class="product-head">SPECIALS PRODUCTS </h2>
                <!-- Heading Ends -->
                <!-- Products Row Starts -->
                <div class="row">
                    <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <img src="/images/product/clothing/05.jpg" alt="">
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
                            <img src="/images/product/health/05.jpg" alt="">
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
                            <img src="/images/product/bath/05.jpg" alt="">
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
                            <img src="/images/product/mobility/05.jpg" alt="">
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
    <!-- //Main -->

<%@ include file="/views/footer.jsp" %>