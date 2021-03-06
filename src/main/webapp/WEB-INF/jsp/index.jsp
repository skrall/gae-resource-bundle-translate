<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="apiKeys" class="org.krall.translate.model.ApiKeys" scope="request"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Translate your resource bundle</title>
    <script src="http://www.google.com/jsapi?key=<c:out value='${apiKeys.javascriptKey}'/>"
            type="text/javascript"></script>
    <link rel="stylesheet" type="text/css"
          href="<spring:theme code='css'/>">
    <script type="text/javascript">
        google.load("jquery", "1.5.1");
        google.load("jqueryui", "1.8.10");
        google.setOnLoadCallback(function() {

        });
    </script>
</head>
<body>

<div id="container" class="ui-widget ui-corner-all">
    <input type="file" id="resourceBundleUpload" name="resourceBundle">

</div>

<script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', '<c:out value="${apiKeys.analyticsKey}"/>']);
    _gaq.push(['_trackPageview']);

    (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();
</script>
</body>
</html>
