<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/admin/header.jsp" %>

		<script type="text/javascript">
			
			jQuery(document).ready(function() {
		 
				jQuery('#product').submit(function(e) {
					e.preventDefault();
					
					var str = jQuery("#product").serialize();
					
					jQuery.ajax({
					    type:"post",
					    data:str,
					    url:"/user/create",
					    async: false,
					    success: function(response){
					       var result = JSON.parse(response);
					       if (result.success === true) {
					    	   window.alert('Product created successfully !');
					    	   document.location.href="/admin/product";
					       } else {
					    	   window.alert(result.errorMessage);
					       }
					       
					    }
					});
				});
			});
		</script>
	
		<div class="col-xs-6 col-xs-offset-3  feedback">
			<span style="margin-left: 5px; font-weight: bold; font-size:30px;">Add/Edit Product</span>
			<form:form modelAttribute="product" style="margin-top: 20px;">
				<label> Name</label>
				<form:input path="name" class="form-control" />
				<br/>
				<label> Price</label>
				<form:input class="form-control" path="price"/>
				<br/>
				<label> Category</label>
				<form:select path="category" class="form-control">
					<form:options items="${categories}" itemValue="id" itemLabel="name"/>
				</form:select>
				<br/>
				<label>Discount Price</label>
				<form:input path="discountPrice" class="form-control"/>
				<br/>
				<label>Image</label>
				<input class="form-control" name="fileData" class="form-control" type="file" />
				<br/>
				<label></label>
				<input class="btn btn-default" type="submit" value="Add" name="btn-submit" id="btn-submit"/>
			</form:form>
		</div>

    <!-- //Main -->	
<%@ include file="/views/footer.jsp" %>