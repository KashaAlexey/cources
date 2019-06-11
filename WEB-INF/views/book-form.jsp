<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h2>${errorMessage}</h2>
        <h3>Welcome, Enter The Book Details</h3>
        <form:form method="POST" action="/sp-cources/book/edit" modelAttribute="book">
             <table>
                <tr>
                    <td><form:label path="name">name</form:label></td>
                    <td><form:input path="name"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td><form:label path="publishedIn">publishedIn</form:label></td>
                    <td><form:input path="publishedIn"/></td>
                    <td><form:errors path="publishedIn" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><form:label path="author.firstName">author.firstName</form:label></td>
                    <td><form:input path="author.firstName"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td><form:label path="author.lastName">author.lastName</form:label></td>
                    <td><form:input path="author.lastName"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td><form:label path="author.dateOfBirth">author.dateOfBirth</form:label></td>
                    <td><form:input path="author.dateOfBirth" type="date"/></td>
                    <td><form:errors path="author.dateOfBirth" cssClass="error" /></td>
                </tr>
                <tr>
                <td></td>
                <td></td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>