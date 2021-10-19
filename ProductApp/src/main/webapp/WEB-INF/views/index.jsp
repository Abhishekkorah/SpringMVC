<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to the product app</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">S.No</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Product Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${products}" var="product">
							<tr>
								<th scope="row">${product.productId}</th>
								<td>${product.productName}</td>
								<td>${product.productDescription}</td>
								<td class="font-weight-bold">&#x20B9; ${product.productPrice}</td>
								<td>
									<a href="delete/${product.productId}"><i class="fas fa-minus-circle text-danger" style="font-size:20px"></i></a>
									<a href="editproduct/${product.productId}"><i class="far fa-edit style="font-size:20px"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
					<a href="addproduct" class="btn btn-outline-success">Add
						Product</a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
