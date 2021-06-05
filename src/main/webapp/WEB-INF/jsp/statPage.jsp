<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Statistics</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/Product.css">
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	var pieChartString = <%=request.getAttribute("pieChartString")%>;
	var histogramChartString = <%=request.getAttribute("histogramChartString")%>;
</script>
</head>
<body>

	<%--  HEADER  --%>

	<section class="py-3">
		<div class="container px-4 px-lg-5 my-1">
			<jsp:include page="menu.jsp" />
		</div>
	</section>

	<%--  MAIN BODY  --%>

	<section class="py-3">
		<div class="container px-4 px-lg-5 my-3">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-12 row">
					<h1 class="display-5 fw-bolder">Page de statistique</h1>
					<hr>
					<div class="col-md-6">
						<div>
							<h2>Origine géographique des clients par département</h2>

							<div id="piechart"></div>

							<script type="text/javascript">
								// Load google charts
								google.charts.load('current', {
									'packages' : [ 'corechart' ]
								});
								google.charts.setOnLoadCallback(drawChart);

								// Draw the chart and set the chart values
								function drawChart() {
									var data = google.visualization
											.arrayToDataTable(pieChartString);

									// Optional; add a title and set the width and height of the chart
									var options = {
										'title' : 'Distribution départementale des clients',
										'width' : 440,
										'height' : 320
									};

									// Display the chart inside the <div> element with id="piechart"
									var chart = new google.visualization.PieChart(
											document.getElementById('piechart'));
									chart.draw(data, options);
								}
							</script>
						</div>
					</div>
					<div class="col-md-6">
						<script type="text/javascript">
							google.charts.load("current", {
								packages : [ "corechart" ]
							});
							google.charts.setOnLoadCallback(drawChart);
							function drawChart() {
								var data = google.visualization
										.arrayToDataTable(histogramChartString);

								var options = {
									title : 'Répartition en âge des clients',
									legend : {
										position : 'none'
									},
								};

								var chart = new google.visualization.Histogram(
										document.getElementById('chart_div'));
								chart.draw(data, options);
							}
						</script>
						<h2>Répartition par âge des clients</h2>
						<div id="chart_div" style="width: 500px; height: 250px;"></div>
						<h5>Une valeur de -1 indique que l'âge n'a pas été renseigné par le client.</h5>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>