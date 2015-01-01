<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Creació d'una nova enquesta</title>
</head>
<body>
  <div class="body">
    <formset> 
		<legend>Crear una enquesta</legend>
  			<g:form action="afegirEnquesta" id="${params.id}">
  			<label for="nomEnquesta">Nom enquesta:</label>
			<g:textField name="nomEnquesta" />
			<label for="pregunta">Pregunta:</label>
			<g:textField name="pregunta"/>
			<g:submitButton name="enquesta" value="Crear enquesta" />
  		</g:form>
  	</formset>
  </div>
</body>
</html>