<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.*;" %>

<%
    HttpSession hs = request.getSession();
   UserDataBeans data = null;
   boolean rre = false;
    if(request.getParameter("ret")!=null && request.getParameter("ret").equals("RET")){
    data = (UserDataBeans)hs.getAttribute("DATA");
    rre = true;
    }
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%if(rre){out.print(data.getName());}%>">
        
        <br><br>
        
        生年月日:　
        <select name="year">
            
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"<%if(rre && data.getYear()==i){out.print("selected=\"selected\"");}%>> <%=i%> </option>
           
            <% } %>
           
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"<%if(rre && data.getMonth()==i){out.print("selected=\"selected\"");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"<%if(rre && data.getDay()==i){out.print("selected=\"selected\"");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>
      
      
        

        種別:
        <br>
        <input type="radio" name="type" value="1"<%if(!(rre)){out.print("checked");}else if(rre && data.getType()==1){out.print("checked");}%> >エンジニア<br>
        <input type="radio" name="type" value="2"<%if(rre && data.getType()==2){out.print("checked");}%>>営業<br>
        <input type="radio" name="type" value="3"<%if(rre && data.getType()==3){out.print("checked");}%>>その他<br>
      
        <br>

        電話番号:
        <input type="text" name="tell" value="<%if(rre){out.print(data.getTell());}%>">
        <br><br>
      
        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%if(rre){out.print(data.getComment());}%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
       
    <br>
        <%=JumsHelper.getInstance().home()%>    
</html>
