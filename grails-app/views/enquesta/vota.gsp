<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  <h1>${enquesta.pregunta}</h1>
  <div>
    <g:form action="gracies">
  	    <g:each in="${enquesta.opcions}" var="opcio">
  	    	<g:radio name="vots" value="${opcio.id}"/> ${opcio.textOpcio}<br/>  		    
  	    </g:each>
  	    <g:actionSubmit value="Vota!" action="gracies" />
    </g:form>
  </div>
  </div>
</body>
</html>