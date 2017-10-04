<%-- 
    Document   : getForm
    Created on : 2017/10/04, 13:39:02
    Author     : p-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    
    
    out.print(request.getParameter("txtName"));
    out.print("<br>");
    if("male".equals(request.getParameter("seibetsu"))){
    
    out.print("男の子なんだぁ");
    }else{
    out.print("女の子なんだぁ");
    }
    out.print("<br>");
    out.print(request.getParameter("seibetsu"));
    out.print("<br>");
    out.print(request.getParameter("syumi"));
    out.print("<br>");
%>

