<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="translationResult" scope="request" type="org.krall.translate.model.TranslationResponse"/>
<html>
<head>
    <title>Translate</title>
</head>
<body>
    <c:forEach var="translation" items="${translationResult.data.translations}">
        <c:out value="${translation.translatedText}"/>
    </c:forEach>
</body>
</html>