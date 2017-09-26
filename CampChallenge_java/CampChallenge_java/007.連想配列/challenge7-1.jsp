<%-- 
    Document   : challenge7-1
    Created on : 2017/09/26, 16:43:09
    Author     : p-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%
HashMap<String,String> datas= new HashMap<String,String>();

datas.put("1","AAA");
datas.put("hello","world");
datas.put("soeda","33");
datas.put("20","20");
    out.print(datas);
    %>