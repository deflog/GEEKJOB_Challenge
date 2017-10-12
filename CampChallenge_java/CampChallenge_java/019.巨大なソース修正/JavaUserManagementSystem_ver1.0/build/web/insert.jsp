<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.*;" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans data= (UserDataBeans)request.getAttribute("DATA");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <%if((UserDataBeans)request.getAttribute("DATA")==null){%><form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="">
        
        <br><br>
        
        生年月日:　
        <select name="year">
            
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
           
            <% } %>
           
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>
      
      
        

        種別:
        <br>
        <input type="radio" name="type" value="1"　checked>エンジニア<br>
        <input type="radio" name="type" value="2">営業<br>
        <input type="radio" name="type" value="3">その他<br>
      
        <br>

        電話番号:
        <input type="text" name="tell" value="">
        <br><br>
      
        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <%}else{%>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%=hs.getAttribute("name")%>">
        <br><%if(data.getName().equals("")){%>
        <br>未入力です<%}%>
        <br><br>
        
        生年月日:　
        <select name="year">
           <%if(!(data.getYear().equals(""))){%>
             <option value="<%=data.getYear()%>"><%=data.getYear()%></option><%}else{%>
            <option value="">--</option>
            <%}
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"><%=i%> </option>  
            
            
            <% } %>
        </select>年
        <select name="month">
            <%if(!(data.getMonth().equals(""))){%>
             <option value="<%=data.getMonth()%>"><%=data.getMonth()%></option><%}else{%>
            <option value="">--</option>
            <%}
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <%if(!(data.getDay().equals(""))){%>
             <option value="<%=data.getDay()%>"><%=data.getDay()%></option><%}else{%>
            <option value="">--</option>
            <%}
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><%if(data.getYear().equals("")||data.getMonth().equals("")||data.getDay().equals("")){%>
        <br>誕生日を入力してください。<br>
        <%}%>
        <br><br>
        
        

        種別:<br>
        <%if(!(data.getType().equals(""))){
                    if(data.getType().equals("1")){%>
                    
        <input type="radio" name="type" value="1"checked="checked">エンジニア<br>
        <input type="radio" name="type" value="2" >営業<br>
        <input type="radio" name="type" value="3" >その他<br>
            <%}else if(data.getType().equals("2")){%>
            <input type="radio" name="type" value="1">エンジニア<br>
        <input type="radio" name="type" value="2"checked="checked" >営業<br>
        <input type="radio" name="type" value="3" >その他<br>
            <%}else{%>
            <input type="radio" name="type" value="1">エンジニア<br>
        <input type="radio" name="type" value="2" >営業<br>
        <input type="radio" name="type" value="3"checked="checked" >その他<br>
        <%}}else{%>
        <input type="radio" name="type" value="1"　check>エンジニア<br>
        <input type="radio" name="type" value="2" >営業<br>
        <input type="radio" name="type" value="3" >その他<br>
        未入力です<br>
        <%}%>
        
        
        
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=hs.getAttribute("tell")%>">
        <br><br>
        <%if(data.getTell().equals("")){%>
        未入力です<br>
        <%}%>
        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=hs.getAttribute("comment")%></textarea><br><br>
        <%if(data.getComment().equals("")){%>
        未入力です<br>
        <%}%>
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <%}%>
    
    <br>
        <%=JumsHelper.getInstance().home()%>    
</html>
