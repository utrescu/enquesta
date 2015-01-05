<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Resultats de l'enquesta "${enquesta.nomEnquesta}"</title>
</head>
<body>
  <div class="body">
    <h1>${enquesta.pregunta}</h1>
  	<g:each in="${enquesta.opcions}" var="opcio">
  	    	<p>${opcio.textOpcio} : ${opcio.vots}</p>  		    
  	</g:each>
  </div>
</body>
</html>