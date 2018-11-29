<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

Kaikki artistit:
<ul>

    <c:forEach items="${ artists }" var="artist">
        <li><c:out value="${ artist.getName() }" /></li>
    </c:forEach>

</ul>

</body>
</html>