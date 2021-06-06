<div class="row contain-nav">
	<div class="col-2 contain-img-bufalo">
		<img class="img-bufalo" src="<%=request.getContextPath()%>/img/Logo_BuFaLo.png" />
	</div>
	<div class="col-8">
		<nav>
			<div class="row">
				<div class="col-3 contain-form-menu">
					<form class="form-menu" method="get" action="statPage">
						<button class="btn btn-primary" type="submit">Statistiques</button>
					</form>
				</div>
				<div class="col-3 contain-form-menu">
					<form class="form-menu" method="get" action="manageCustomers">
						<button class="btn btn-primary" type="submit">Clientèle</button>
					</form>
				</div>
				<div class="col-3 contain-form-menu">
					<form class="form-menu" method="get" action="manageProducts">
						<button class="btn btn-primary" type="submit">Produits</button>
					</form>
				</div>
				<div class="col-3 contain-form-menu">
					<form class="form-menu" method="get" action="manageOrders">
						<button class="btn btn-primary" type="submit">Commandes</button>
					</form>
				</div>
			</div>
		</nav>
	</div>
	<div class="col-2">
		<div class="icon-exit">
			<a href="login">
				<i class="fa fa-sign-out fa-2x" aria-hidden="true"></i>
			</a>
		</div>
	</div>
</div>



<link href="<%=request.getContextPath()%>/css/menu.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>