<%-- 
    Document   : bloglist
    Created on : Oct 14, 2013, 4:57:14 PM
    Author     : Adri
--%>

<%@page import="com.kdg.week2_blogpost.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BlogList</title>
    </head>
    <body>
        <h1><c:out value="${user.username}"/></h1>

        <table>
            <c:forEach var="post" items="${posts}">
                <c:if test="${post.id == postId}">
                    <tr bgcolor="#FFE473">
                        <td><c:out value="${post.user.username}"/></td>
                        <td><c:out value="${post.year}"/></td>
                        <td><c:out value="${post.specialization}"/></td>
                        <td><c:out value="${post.description}"/></td>
                        <td><c:out value="${post.url}"/></td>
                    </tr>
                </c:if>
                <c:if test="${post.id != postId}">
                    <tr bgcolor="#FFFFF">
                        <td><c:out value="${post.user.username}"/></td>
                        <td><c:out value="${post.year}"/></td>
                        <td><c:out value="${post.specialization}"/></td>
                        <td><c:out value="${post.description}"/></td>
                        <td><c:out value="${post.url}"/></td>
                    </tr> 
                </c:if>
            </c:forEach>
        </table>
        <a href='blogpost.jsp'>Add a new post</a>
        <a href='LogOutServlet'>Log Out</a>
    </body>
</html>
