<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
	<head>
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
		<script type="text/javascript" src="">
			
		</script>
	</head>
	<body>
		<p>Lol!</p>
		<c:forEach items="${msg}" var="item">
    		${item.name}<br>
		</c:forEach>
		<c:url value="resources/js/test.js" />
		<a href="resources/js/test.js">Test</a>	
	</body>
</html>