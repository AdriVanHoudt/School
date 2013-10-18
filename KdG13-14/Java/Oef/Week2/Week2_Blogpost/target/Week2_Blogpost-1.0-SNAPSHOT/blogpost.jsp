<%-- 
    Document   : blogpost
    Created on : Oct 18, 2013, 2:53:55 PM
    Author     : Adri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Toevoegen entry</h2>
        <hr/>
        <form action="BlogPostServlet" method="post">
            <table align="center" width="100%" cellspacing="2" cellpadding="2">
                <tr>
                    <td align="left">Omschrijving</td>
                    <td><textarea name="omschrijving" cols="70" rows="4"></textarea></td>
                </tr>
                <tr>
                    <td width="22%" align="left">URL</td>
                    <td width="78%"><input type="text" name="url" align="left" size="70"/></td>
                </tr>
            </table>
            <hr/><br/>
            <input type="submit" name="submit" value="Toevoegen"/>
        </form>
    </body>
</html>
