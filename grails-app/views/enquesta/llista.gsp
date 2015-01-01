<html>
	<head>
		<title>Llista d'enquestes</title>
		<meta name="layout" content="main"/>
	</head>
	<body>
		<div id="barra">
			<div id="detalls-usuari">
				<ul id="horitzontal">
					<li class="tipus">Usuari:</li>
					<li class="valor">${usuari.userId}</li>
					<li class="tipus">Nom:</li>
					<li class="valor">${usuari.nomComplet}</li>				
				</ul>
			</div>
			<div id="dreta">
				<g:form action="nova" id="${params.id}">
					<g:submitButton name="crear" value="Crear Enquesta"/>
				</g:form>
			</div>
		</div>
		<div id="resultat">
			<g:each in="${usuari.enquestes}" var="enquesta">
				<div class="EntradaEnquesta">
					<div class="EntradaNomEnquesta">${enquesta.nomEnquesta}</div>
					<div class="EntradaPreguntaEnquesta">${enquesta.pregunta}</div>
				</div>
			</g:each>
		</div>
	</body>
</html>