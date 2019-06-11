<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<table  style="font-family: arial; line-height: 2.0; ">
    <tr>
        <td style="vertical-align: top">
 <h2>Book</h2>

 <a href="/sp-cources/book/edit/">Insert new book</a><br>
	<c:forEach var="book" items="${booksVariable}">
    	<li>${book.id}. ${book.name} (${book.publishedIn})
    	    &nbsp; <a href="/sp-cources/book/edit/update/${book.id}">Update</a>   /
            &nbsp; <a href="/sp-cources/book/delete/${book.id}">Delete</a>
        </li>
    </c:forEach>

 </td>
 </tr></table>
</body>
</html>