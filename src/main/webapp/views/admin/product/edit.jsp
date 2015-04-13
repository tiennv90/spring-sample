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
					    url:"/admin/product/addOrEdit",
					    async: false,
					    success: function(response){
					       var result = JSON.parse(response);
					       if (result.success === true) {
					    	   window.alert('Product was updated successfully !');
					    	   document.location.href="/admin/product";
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
	
		<div class="col-sm-6 col-md-6 mainarea">
			<span style="margin-left: 5px; font-weight: bold; font-size:30px;">Add/Edit Product</span>
			<form:form modelAttribute="product" class="form-horizontal">
				<form:hidden path="id" />
				<label> Name</label>
				<form:input path="name" class="form-control" />
				<label> Price</label>
				<form:input class="form-control" path="price"/>
				<label> Category</label>
				<select name="categoryId" class="form-control">
					<c:forEach var="category" items="${categories}">
						<c:choose>					
							<c:when test="${category.id eq product.category.id}">
								<c:set var="selected" value="selected='selected'"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="selected" value=""></c:set>
							</c:otherwise>
						</c:choose>
						<option ${selected}  value='${category.id}'>${category.name }</option>
					</c:forEach>
				</select>
				<label>Deal Of The Day</label>
				<select name="dealOfTheDay" class="form-control">
					<c:choose>					
						<c:when test="${product.dealOfTheDay eq true}">
								<c:set var="selectedtrue" value="selected='selected'"></c:set>
								<c:set var="selectedfalse" value=""></c:set>
						</c:when>
						<c:otherwise>
								<c:set var="selectedtrue" value=""></c:set>
								<c:set var="selectedfalse" value="selected='selected'"></c:set>
						</c:otherwise>
					</c:choose>
					<option ${selectedtrue}  value='true'>true</option>
					<option ${selectedfalse}  value='false'>false</option>
				</select>				
				<label>Discount Price</label>
				<form:input path="discountPrice" class="form-control"/>
				<div class="form-group">
					<form:hidden path="imageUrl" class="form-control"/>
				</div>
				<input class="btn btn-default" type="submit" value="Add" name="btn-submit" id="btn-submit"/>
			</form:form>
		</div>
		<div class="col-sm-3 col-md-4 mainarea">
			<h3>&nbsp</h3>
			<form  method="POST" id="upload"  class="form-horizontal" enctype="multipart/form-data">
				<div class="form-group">
					<label>Image</label>
					<input name="filedata" class="form-control" type="file" />
				</div>
				<input class="btn btn-default" type="submit" value="Upload File" name="btn-submit" id="btn-submit"/>
			</form>
		</div>
    <!-- //Main -->	
<%@ include file="/views/footer.jsp" %>