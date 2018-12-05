<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<form method=get action=artist>
	<input type=text name=id value="">
	<input type=submit>
</form>

Kaikki artistit:
<ul>

    <c:forEach items="${ artists }" var="artist">
        <li><c:out value="${ artist.getName() }" /></li>
    </c:forEach>

</ul>

</body>
</html>