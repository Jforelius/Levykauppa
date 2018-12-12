<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<a href="/Levykauppa/artists">index</a>
<br>
<br>

<form method=get>
	<input type=text name=id value="">
	<input type=submit>
</form>

<h1><c:out value="${ artist.getName() }" /></h1>
<br>
<ul>

    <c:forEach items="${ albums }" var="albums">
        <li><c:out value="${ albums.getTitle() }" /></li>
    </c:forEach>

</ul>
<!-- if id>listed artists error + return to index -->