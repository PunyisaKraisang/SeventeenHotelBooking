<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
alert("Your reservation has been created successfully!")
var url = window.location.href;
var index = url.indexOf("bookRoom")
var mainUrl = url.substring(0, index);
window.location.href = mainUrl;
</script>
</body>
</html>
