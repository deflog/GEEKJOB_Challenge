<%-- 
    Document   : getMonster.jsp
    Created on : 2017/10/04, 16:03:47
    Author     : p-user
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
out.print(request.getParameter("タイプ"));
    

int hmy = Integer.parseInt(request.getParameter("匹"));
int goukei = Integer.parseInt(request.getParameter("金額"))*hmy;    
String poke="";

            
out.print(request.getParameter("タイプ")+"タイプの"+request.getParameter("金額")+"円"+hmy+"匹だな");
out.print("<br>");
out.print("合計"+goukei+"円だ");
out.print("<br>");
          int point= 0;
    
       if(goukei>=5000){
           point=(int)(goukei*0.05);
           
       }else if(goukei>=3000){
           point=(int)(goukei*0.04);
          
       }else{
          
       } 
out.print("今回は"+point+"ポイントだな");
out.print("<br>");
if("炎".equals(request.getParameter("タイプ"))){
                if("1000".equals(request.getParameter("金額"))){
                       poke="ヒトカゲ";
                }else if("2000".equals(request.getParameter("金額"))){
                        poke="リザード";
                }else{      
                        poke="リザードン";
                }
}else if("水".equals(request.getParameter("タイプ"))){
               if("1000".equals(request.getParameter("金額"))){
                       poke="ゼニガメ";
                }else if("2000".equals(request.getParameter("金額"))){
                        poke="カメール";
                }else{      
                        poke="カメックス";
                }
}else{
                if("1000".equals(request.getParameter("金額"))){
                       poke="フシギダネ";
                }else if("2000".equals(request.getParameter("金額"))){
                        poke="フシギソウ";
                }else{      
                        poke="フシギバナ";
                }
        }
        
        
 
out.print("お前には"+poke+"を"+hmy+"匹やろう");
out.print("<br>");
            if((6-hmy)!=0){
        out.print("統一パで"+(6-hmy)+"匹も空きを作るとか自信家だな");
    }else if(hmy==0){
       out.print("おまえさてはトレーナーじゃないな！");

    }else{
        out.print("よしまずはわしとバトルじゃ！");
}


            
            
            
        
//何ポイントか返すよ！
/*class Money{
    int poInt(int n){
        int point= 0;
    
       if(n>5000){
           point=(int)(n*0.05);
           return point;
       }else if(n>3000){
           point=(int)(n*0.04);
           return point;
       }else{
           return point;
       }
    }
}*/

/*class Order{
    
    //ここで3種類判定するよ！
    String Type(String ty,String kane,int hiki){
       
    
        switch(ty){
            case "炎":
                
                switch(kane){
                    case "1000":
                        return "ヒトカゲ";
                    case "2000":
                        return "リザード";
                    case "10000":
                        return "リザードン";
                }
            case "水":
                switch(kane){
                    case "1000":
                        return "ゼニガメ";
                    case "2000":
                        return "カメール";
                    case "10000":
                        return "カメックス";
                }
            case "草":
                switch(kane){
                    case "1000":
                        return "フシギダネ";
                    case "2000":
                        return "フシギソウ";
                    case "10000":
                        return "フシギバナ";
                }
        }
        return "異常な文字列です。";
        
    }
//空きに応じてコメントするよ！
String aki(int i){
    if((6-i)!=0){
        return ""+(6-i)+"匹も空いてるぞ、やる気あんのか！";
    }else if(i==0){
        return "おまえさてはトレーナーじゃないな！";

    }else{
        return "よしまずはわしとバトルじゃ！";
}

}
    
    
}*/
%>

