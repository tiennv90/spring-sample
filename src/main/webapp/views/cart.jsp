<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/views/header.jsp" %>

	<script type="text/javascript">
		function validateFormProcess() {
			var cvvnumber = document.forms["process"]["cvvnumber"].value;
				cardnumber = document.forms["process"]["cardnumber"].value;
				
			var	leng_cvv = cvvnumber.length;
				leng_cardnumber = cardnumber.length;
				
			if (cvvnumber == "") {
				alert("CVV Number must be filled out");
				document.forms["process"]["cvvnumber"].focus();
				return false;
			}
			if (!isNaN(cvvnumber)) {
				alert("CVV Number must be a Character");
				document.forms["process"]["cvvnumber"].focus();
				return false;
			}
			if (leng_cvv != 3) {
				alert("CVV Number must be 3 character");
				document.forms["process"]["cvvnumber"].focus();
				return false;
			}
			if (cardnumber == "") {
				alert("Card Number must be filled out");
				document.forms["process"]["cardnumber"].focus();
				return false;
			}
			if (isNaN(cardnumber)) {
				alert("Card Number must be a Number");
				document.forms["process"]["cardnumber"].focus();
				return false;
			}
			if (leng_cardnumber != 16){
				alert("Card Number must be 16 characters");
				document.forms["process"]["cardnumber"].focus();
				return false;
			}
		
			var str = jQuery("#checkout").serialize();
			
			jQuery.ajax({
			    type:"post",
			    data:str,
			    url:"/cart/checkoutprocess",
			    async: false,
			    success: function(response){
			    	document.location.href="/";
			    	window.alert("Thanks for your interested in our products");
			    }
			});	
		}
		

	</script>

    <div id="main">

        <section class="products-list">
            <div class="container">
                <!-- Heading Starts -->
                <h2 class="product-head">Shopping Cart </h2>
                <!-- Heading Ends -->
                <!-- Products Row Starts -->
                <c:choose>
                	<c:when test="${empty emptyCartMessage}">
		                <c:set var="products" value="${orders.products}"/>
		                
		                <c:forEach var="product" items="${products}">
			                <div class="row">
			                    <div class="col-md-8">
			                        <div style="border:none;" class="thumbnail">
			                            <img style="float:left; width: 150px;" src="${product.imageUrl }" alt="${product.name }">
			                            <div class="caption">
			                                <h3>${product.name }</h3>
			                                <p>$ ${product.price }</p>
			                                <p><a href="/cart/remove?productId=${product.id }" class="btn btn-primary" role="button">Cancel</a>
			                                </p>
			                            </div>
			                        </div>
			                    </div>
								<div class="col-md-4">
								
								</div>                  
			                </div>                	
		                </c:forEach>      
		                
						<hr style="background-color: #A52222; height: 2px; border: 0;">
						<div class="row">
		                    <div class="col-md-4">
		                        <div class="total">
									<span style="float: left; font-size: 25px; font-weight:bold;">Total: <b style="color: #A52222;">$ ${total}</b></span>
								</div>
		                    </div>
							<div class="col-md-8">
								<div style="float:right;" class="process">
									<form id="checkout" method="POST"   name="process" onsubmit="return validateFormProcess()" >
										<div class="form-group">
											<label for="cardnumber">Card Number</label>
											<input id="cardnumber" class="form-control" placeholder="card number" name="cardnumber" type="text" value=""/><br/>
											<label for="cvvnumber">CVV</label>
											<input id="cvvnumber" class="form-control" placeholder="cvv" name="cvvnumber" style="width: 50px;" type="text" value=""/>
										</div>	
										<input id="process" name="process" style="margin-top: 5px;" type="submit" value="Checkout Proccess"/>
											
									</form>
								</div>						
							</div>                  
		                </div>		                
		                          		
                	</c:when>
                	<c:otherwise>
                		<h3>${emptyCartMessage}</h3>
                	</c:otherwise>
                </c:choose>

            </div>
        </section>
    </div>
    <!-- //Main -->

<%@ include file="/views/footer.jsp" %>