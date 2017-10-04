<%-- 
    Document   : bunkai
    Created on : 2017/10/04, 18:58:01
    Author     : p-user
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<Integer> result = new ArrayList<Integer>();
int i[]={2,3,5,7};
int getn = Integer.parseInt(request.getParameter("suzi"));
out.print(request.getParameter("suzi"));
out.print("<br>");
for(int j=0;j<i.length;j++){
    if(j==i.length-1&&getn%i[j]!=0){
    out.print(getn);
    break;
    }
while(getn%i[j]==0){
    
    result.add(i[j]);
    out.print(i[j]+",");
    getn=getn/i[j];
    
}
}
   


%>