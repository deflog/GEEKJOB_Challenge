<%-- 
    Document   : challenge8-1
    Created on : 2017/09/26, 16:52:24
    Author     : p-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    long i = 8;
    
    int a = 0;
    
    for(a=0;a<20;a++){
    i=i*8;
    
 out.print(i);
 out.print("<br>");   
    };
out.print(i);

%>
