<html>
<head>
  <title>Resultats de la cerca</title>
  <meta name="layout" content="main"/>
</head>
<body>
  <h1>Results</h1>
  <p>
    Searched ${totalPreguntes} records
    for items matching <em>${term}</em>.
    Found <strong>${preguntes.size()}</strong> hits.
  </p>
  <ul>
    <g:each var="pregunta" in="${preguntes}">
    <li><g:link controller="enquesta" action="show" id="${pregunta.id}">${pregunta.pregunta}</g:link></li>
    </g:each>
  </ul>
  <g:link action='cerca'>Torna a cercar</g:link>
</body>
</html>