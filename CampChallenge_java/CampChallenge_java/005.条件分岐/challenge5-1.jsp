<%-- 
    Document   : challenge5-1
    Created on : 2017/09/26, 15:54:26
    Author     : p-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
int hantei=2;

if(hantei==1)
{
out.print("1です！");
}else if(hantei==2){
    out.print("プログラミングキャンプ！");
}else{
    out.print("その他です");
}
%>