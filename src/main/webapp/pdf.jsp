<%@ page language='java' contentType="text/html"%>
<%@page import="java.util.List"%>
<%@page import="model.Empleado"%>
<%@page import="Servicios.EmpleadoServicio"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Telcel</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="telcel.jsp">Telcel</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home.jsp">Inicio</a></li>
					<li class="nav-item"><a class="nav-link" href="about.jsp">Conócenos
					</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Proyectos </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="pdf.jsp">Generar PDF</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Craer Imagen</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Crear Qr</a></li>
						</ul></li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container">
		<h1>
			Usuarios <span class="badge bg-secondary">New</span>
		</h1>

		<!--
		<form action="SvPdf" method="post">
			<input type="hidden" value="24" name="data">

			<button type="submit" class="btn btn-primary position-relative">
				GENERAR PDF <span
					class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					1+ <span class="visually-hidden">unread messages</span>
				</span>
			</button>
		</form>
	</div>-->
		<br> <br>
</div>

		<div class="container">
			<a class="btn btn-outline-primary " href="#"> Agregar Cliente </a> <br>
			<br> <br>

			<table border="1" class="table table-dark table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col">Edad</th>
						<th scope="col">QR</th>
						<th scope="col">Accion</th>
						<th scope="col">Accion</th>
						<th scope="col">Accion</th>
					</tr>
				</thead>
				<tbody>

					<%
					List<Empleado> lista = EmpleadoServicio.getEmpleado();
					for (Empleado e : lista) {
					%>
					<tr>
						<td><%=e.getId()%></td>
						<td><%=e.getNombre()%></td>
						<td><%=e.getApellido()%></td>
						<td><%=e.getEdad()%></td>
						<td><%=e.getQr()%></td>
						<td><a class="btn btn-outline-danger"
							data-bs-toggle="tooltip" data-bs-placement="top"
							title="Seguro que quieres borrar"
							href="pdf.jsp?id=<%=e.getId()%>">Borrar</a></td>
						<td><a class="btn btn-outline-success"
							href="pdf.jsp?id=<%=e.getId()%>">Editar</a></td>
						<td><a class="btn btn-outline-success"
							href="crearPDF?id=<%=e.getId()%>">GENERAR PDF</a></td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
			<br> <br>

			<form action="crearPDF" method="post">
				<input type="text" value="24" name="data">

				<button type="submit" class="btn btn-primary position-relative">
					GENERAR PDF <span
						class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
						1+ <span class="visually-hidden">unread messages</span>
					</span>
				</button>
			</form>



		</div>

		<!-- Optional JavaScript; choose one of the two! -->

		<!-- Option 1: Bootstrap Bundle with Popper -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous"></script>

		<!-- Option 2: Separate Popper and Bootstrap JS -->
		<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>