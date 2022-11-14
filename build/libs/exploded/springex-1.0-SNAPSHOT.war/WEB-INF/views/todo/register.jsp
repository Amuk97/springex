<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register view</title>
</head>
<body>
  <form action="/todo/register" method="post">
    <div>
        title : <input type="text" name="text">
    </div>
    <div>
        DueDate : <input type="date" name="dueDate" value="2022-11-14">
    </div>
    <div>
        Writer : <input type="text" name="writer">
    </div>
    <div>
        Finished : <input type="checkbox" name="finished">
    </div>
    <div>
        <button type="submit">Register</button>
    </div>




  </form>

</body>
</html>
