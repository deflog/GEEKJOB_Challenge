<%-- 
    Document   : challenge8-4
    Created on : 2017/09/26, 17:25:39
    Author     : p-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int count = 1000;
while(count>100){

count=count/2;
out.print(count);
}
%>