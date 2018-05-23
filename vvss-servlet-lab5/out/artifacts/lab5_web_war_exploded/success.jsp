<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <%

        String message = (String) session.getAttribute("result");
        out.println("<div id=\"res\">"+message+"</div>");
    %>
</body>
</html>
