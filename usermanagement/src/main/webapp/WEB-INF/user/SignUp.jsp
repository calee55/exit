<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign Up</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>

<!-- Custom styles for this template -->
<link href="../css/signup.css" rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container">
		<main>
			<div>
				<h4 class="mb-3">Sign Up</h4>
				<form class="needs-validation" novalidate="">
					<div class="row g-3">
						<div class="col-12">
							<label for="userid" class="form-label">UseID</label> <span
								class="input-group-text">@</span> <input type="text"
								class="form-control" id="username" placeholder="Userid"
								required="">
							<div class="invalid-feedback">Your ID is required.</div>
						</div>
					</div>
					<div class="col-12">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							placeholder="Password" required="">
						<div class="invalid-feedback">Your Password is required.</div>
					</div>
					<div class="col-12">
						<label for="email" class="form-label">Email <span
							class="text-muted">(Optional)</span></label> <input type="email"
							class="form-control" id="email" placeholder="you@example.com">
						<div class="invalid-feedback">Please enter a valid email
							address for shipping updates.</div>
					</div>
					<div class="col-12">
						<label for="address" class="form-label">Address</label> <input
							type="text" class="form-control" id="address"
							placeholder="1234 Main St" required="">
						<div class="invalid-feedback">Please enter your shipping
							address.</div>
					</div>
					<div class="col-12">
						<label for="address2" class="form-label">Address 2 <span
							class="text-muted">(Optional)</span></label> <input type="text"
							class="form-control" id="address2"
							placeholder="Apartment or suite">
					</div>
			</div>
			<hr class="my-4">
			<button class="w-100 btn btn-primary btn-lg submit" type="submit">Continue
				to checkout</button>
			</form>
	</div>
	</main>
	</div>

	<script src="../js/bootstrap.bundle.min.js"></script>
	<script src="../js/signup.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>


	<script type="text/javascript">
		

</script>

</body>
</html>