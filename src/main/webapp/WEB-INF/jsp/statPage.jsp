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
<script type="text/javascript">
	var pieChartString = <%=request.getAttribute("pieChartString")%>;
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
				<div class="col-md-12">
					<h1 class="display-5 fw-bolder">Page de statistique</h1>
					<div class="row">
						<div class="col-md-6">
							<h2>Origine géographique des clients par département</h2>

							<div id="piechart"></div>

							<script type="text/javascript"
								src="https://www.gstatic.com/charts/loader.js"></script>

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
										'width' : 550,
										'height' : 400
									};

									// Display the chart inside the <div> element with id="piechart"
									var chart = new google.visualization.PieChart(
											document.getElementById('piechart'));
									chart.draw(data, options);
								}
							</script>
						</div>
					</div>
<%-- 				<div class="col-md-6">
						<script type="text/javascript"
							src="https://www.gstatic.com/charts/loader.js"></script>
						<script type="text/javascript">
							google.charts.load("current", {
								packages : [ "corechart" ]
							});
							google.charts.setOnLoadCallback(drawChart);
							function drawChart() {
								var data = google.visualization
										.arrayToDataTable([
												[ 'Dinosaur', 'Length' ],
												[
														'Acrocanthosaurus (top-spined lizard)',
														12.2 ],
												[
														'Albertosaurus (Alberta lizard)',
														9.1 ],
												[ 'Allosaurus (other lizard)',
														12.2 ],
												[
														'Apatosaurus (deceptive lizard)',
														22.9 ],
												[
														'Archaeopteryx (ancient wing)',
														0.9 ],
												[
														'Argentinosaurus (Argentina lizard)',
														36.6 ],
												[ 'Baryonyx (heavy claws)', 9.1 ],
												[ 'Brachiosaurus (arm lizard)',
														30.5 ],
												[
														'Ceratosaurus (horned lizard)',
														6.1 ],
												[ 'Coelophysis (hollow form)',
														2.7 ],
												[
														'Compsognathus (elegant jaw)',
														0.9 ],
												[
														'Deinonychus (terrible claw)',
														2.7 ],
												[ 'Diplodocus (double beam)',
														27.1 ],
												[ 'Dromicelomimus (emu mimic)',
														3.4 ],
												[ 'Gallimimus (fowl mimic)',
														5.5 ],
												[
														'Mamenchisaurus (Mamenchi lizard)',
														21.0 ],
												[ 'Megalosaurus (big lizard)',
														7.9 ],
												[
														'Microvenator (small hunter)',
														1.2 ],
												[ 'Ornithomimus (bird mimic)',
														4.6 ],
												[ 'Oviraptor (egg robber)', 1.5 ],
												[ 'Plateosaurus (flat lizard)',
														7.9 ],
												[
														'Sauronithoides (narrow-clawed lizard)',
														2.0 ],
												[
														'Seismosaurus (tremor lizard)',
														45.7 ],
												[ 'Spinosaurus (spiny lizard)',
														12.2 ],
												[ 'Supersaurus (super lizard)',
														30.5 ],
												[
														'Tyrannosaurus (tyrant lizard)',
														15.2 ],
												[ 'Ultrasaurus (ultra lizard)',
														30.5 ],
												[
														'Velociraptor (swift robber)',
														1.8 ] ]);

								var options = {
									title : 'Lengths of dinosaurs, in meters',
									legend : {
										position : 'none'
									},
								};

								var chart = new google.visualization.Histogram(
										document.getElementById('chart_div'));
								chart.draw(data, options);
							}
						</script>
						<div id="chart_div" style="width: 900px; height: 500px;"></div>
					</div>--%>	
				</div>
			</div>
		</div>
	</section>
</body>
</html>