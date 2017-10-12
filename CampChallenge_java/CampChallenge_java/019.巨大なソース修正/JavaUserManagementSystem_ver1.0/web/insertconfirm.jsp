<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.*" %>


<%
    
    UserDataBeans data = (UserDataBeans)session.getAttribute("DATA");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <%if(!(data.getName().equals(""))&&data.getYear() != 0&&data.getMonth()!=0&&data.getDay()!=0&&data.getType()!=0&&!(data.getTell().equals(""))&&!(data.getComment().equals(""))){%>
        <h1>登録確認</h1>
        名前:<%=data.getName()%> <br>
        生年月日:<%=data.getYear()+"年"+data.getMonth()+"月"+data.getDay()+"日"%><br>
        種別:<%=data.getType()%><br>
        電話番号:<%=data.getTell()%><br>
        自己紹介:<%=data.getComment()%><br>
        
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
     <h1>入力が不完全です</h1>
     <%if(data.getName().equals("")){%>
     <%="名前を入力してください。"%><br>
     <%}%>
     <%if(data.getYear()==0||data.getMonth()==0||data.getDay()==0){%>
     <%="生年月日を入力してください。"%><br>
     <%}%>
     <%if(data.getType()==0){%>
     <%="種別を入力してください。"%><br>
     <%}%>
     <%if(data.getTell().equals("")){%>
     <%="電話番号を入力してください。"%><br>

     <%}%>
     <%if(data.getComment().equals("")){%>
     <%="自己紹介を入力してください。"%><br>
     <%}%>
    <% } %>
    
        <form action="insert" method="POST">
            <input type="hidden" name="ret" value="RET">
            <input type="submit" name="no" value="登録画面に戻る">
            
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
