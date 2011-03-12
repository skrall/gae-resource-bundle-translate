<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:useBean id="translationResponse" scope="request" type="org.krall.translate.model.TranslationResponse"/>
<html>
<head>
    <title>Translate</title>
</head>
<body>
    <c:forEach var="translation" items="${translationResponse.data.translations}">
        <c:out value="${translation.translatedText}"/>
    </c:forEach>
    <form action="<c:url value="/app/translate.html"/>" method="post" enctype="multipart/form-data">
        <input type="file" name="translationFile">
        <input type="submit" value="Submit">
    </form>
</body>
</html>