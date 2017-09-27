<%-- 
    Document   : FortuneTellingResalt
    Created on : 2017/09/27, 17:54:46
    Author     : p-user
--%>

<%@page import ="org.camp.servlet.ResaltData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <%
           ResaltData data = (ResaltData)request.getAttribute("DATA");
           
           
       %> 
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        </head>
        <body>
            <%
                if(data != null){
                out.print("<h1>あなたの"+data.getD()+"運勢は、”"+data.getLuck()+"です！<h1>");
                }
                %>
        </body>
</html>
    
