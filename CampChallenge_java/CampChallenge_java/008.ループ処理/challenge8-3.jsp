<%-- 
    Document   : challenge8-3
    Created on : 2017/09/26, 17:21:26
    Author     : p-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
int i = 0;
int count = 0;
for(i=0;i<101;i++){
count+=i;
out.print(count);
out.print("<br>");
}
    %>
