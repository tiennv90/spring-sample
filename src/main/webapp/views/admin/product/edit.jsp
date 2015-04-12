<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/admin/header.jsp" %>

		<div style="width: 99%; margin-left: 40px;" class="admin-page">
			<span style="margin-left: 5px; font-weight: bold; font-size:30px;">Add Products</span>
			<form style="margin-top: 20px;" action="#" method="POST" id="add-product" name="add-product">
				<label> Name</label>
				<input style="margin-left: 95px;" name="name" id="name" type="text" value=""/>
				<br/>
				<label> Price</label>
				<input style="margin-left: 102px;" name="price" id="price" type="text" value=""/>
				<br/>
				<label> Category</label>
				<select style="margin-left: 73px;">
					<option value="1">Clothing</option>
					<option value="2">bbb</option>
					<option value="3">ccc</option>
				</select>
				<br/>
				<label> Dissount Price</label>
				<input style="margin-left: 38px;" name="discount-price" id="discount-price" type="text" value=""/>
				<br/>
				<label>Image</label>
				<input style="margin-left: 140px; margin-top:-30px;" type="file" value="Upload Image" id="image-product" name="image-product"/>
				<br/>
				<label></label>
				<input style="margin-left: 136px;" type="submit" value="Add" name="btn-submit" id="btn-submit"/>
			</form>
		</div>

    <!-- //Main -->	
<%@ include file="/views/footer.jsp" %>