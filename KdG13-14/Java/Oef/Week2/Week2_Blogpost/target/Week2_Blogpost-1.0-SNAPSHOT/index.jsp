<%-- 
    Document   : index
    Created on : Oct 18, 2013, 2:30:25 PM
    Author     : Adri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logon</title>
    </head>
     <body>
        <form action="LogonServlet" method="post">
            <table align="center" width="100%" cellspacing="2" cellpadding="2">
                <tr>
                    <td width="22%" align="left">Gepost door</td>
                    <td width="78%"><input type="text" name="name" align="left" size="15"/></td>
                </tr>
                <tr>
                    <td align="left">Jaar</td>
                    <td>
                        <select name="jaar" size="1">
                            <option value="TI1">TI1</option>
                            <option value="TI2">TI2</option>
                            <option value="TI3">TI3</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="left">Specialiteit</td>
                    <td>
                        <p>
                            <input type="radio" name="specialiteit" value="Applicatieontwikkeling"/>
                            Applicatieontwikkeling<br/>
                            <input type="radio" name="specialiteit" value="Multimedia"/>
                            Multimedia<br/>
                            <input type="radio" name="specialiteit" value="Datacommunicatie"/>
                            Datacommunicatie<br/>
                            <input type="radio" name="specialiteit" value="SoftwareEngeneering"/>
                            SoftwareEngeneering<br/>
                        </p>
                    </td>
                </tr>
            </table>
            <input type="submit" name="submit" value="Logon"/>
        </form>
    </body>
</html>
