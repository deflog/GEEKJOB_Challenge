<%-- 
    Document   : challenge5-2
    Created on : 2017/09/26, 16:02:45
    Author     : p-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
int hantei=1;

switch(hantei){
    case 1:
        out.print("one");
        break;
    case 2:
        out.print("two");
        break;
    default:
        out.print("想定外");
        break;
}

%>