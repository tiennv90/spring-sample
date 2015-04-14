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
				    url:"/user/edit",
				    async: false,
				    success: function(response){
				       var result = JSON.parse(response);
				       if (result.success === true) {
				    	   window.alert('User updated successfully !');
				    	   document.location.href=result.redirectUrl;
				       } else {
				    	   window.alert(result.errorMessage);
				       }
				       
				    }
				});
			});
			
			jQuery('#upload').submit(function(e) {
				e.preventDefault();
				
				var formData = new FormData($(this)[0]);
				
				jQuery.ajax({
				    type:"POST",
				    data:formData,
				    url:"/upload",
				    async: false,
				    enctype: 'multipart/form-data',
				    success: function(response){
				    	window.alert("image was uploaded successfully!");
				    	jQuery("#imageUrl").val("/images/" + response);
				    },
			        cache: false,
			        contentType: false,
			        processData: false				    
				});
			});
		});
	</script>	
    
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
		<div class="col-sm-6 col-md-6 mainarea">
			<h3>Edit Profile</h3>
		 
			<form:form modelAttribute="user" class="form-horizontal" enctype="multipart/form-data">
				<form:hidden path="id" id="id"/>
				<form:hidden path="userName" id="userName"/>
				<div class="form-group">
					<label> First Name</label>
					<form:input path="firstName" id="fname" placeholder="First Name" class="form-control"/>
				</div>
				<div class="form-group">
					<label> Last Name</label>
					<form:input path="lastName" id="lname" placeholder="Last Name" class="form-control"/>
				</div>
                <div class="form-group">
                    <label for="pass">Password</label>
                    <form:password path="password" id="pass" placeholder="Password" class="form-control"/>
                </div>
				 <div class="form-group">
				    <label for="passAgain">Re-Enter Password</label>
                     <form:password path="repassword" id="passAgain" placeholder="Re-Enter Password" class="form-control"/>
				</div>	
                <div class="form-group">
                    <label for="address">Address</label>
                    <form:input path="address" id="address" placeholder="Address" class="form-control"/>
                </div>
				<div class="form-group">
					<label for="address">Image</label>
					<form:input path="imageUrl" class="form-control"/>
				</div>
				<div class="form-group">
					<label></label>
					<input class="btn btn-default" type="submit" value="Save" name="btn-submit" id="btn-submit"/>
				</div>
            </form:form>
            
		</div>
		<!--  
		<div class="col-sm-3 col-md-4 mainarea">
			<h3>&nbsp</h3>
			<form  method="POST" id="upload"  class="form-horizontal" enctype="multipart/form-data">
				<div class="form-group">
					<label>Image</label>
					<input name="filedata" class="form-control" type="file" />
				</div>
				<input class="btn btn-default" type="submit" value="Upload File" name="btn-submit" id="btn-submit"/>
			</form>
		</div> -->
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
                                <h3>Product Name</h3>
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