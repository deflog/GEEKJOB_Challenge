<%-- 
    Document   : challenge6-2
    Created on : 2017/09/26, 16:25:13
    Author     : p-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<String> datas = new ArrayList<String>();
datas.add("10");
datas.add("100");
datas.add("soeda");
datas.add("hayashi");
datas.add("-20");
datas.add("118");
datas.add("END");
datas.set(2,"33");
int i;
    for(i=0;i<7;i++){
    out.print(datas.get(i));
    }

%>
