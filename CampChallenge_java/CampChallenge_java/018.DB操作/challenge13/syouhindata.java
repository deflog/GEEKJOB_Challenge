/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge13;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


/**
 *
 * @author p-user
 */
@WebServlet(name = "syouhindata", urlPatterns = {"/syouhindata"})
public class syouhindata extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Tools tools = new Tools();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String tool = request.getParameter("tool");
        String set = request.getParameter("set");
        String inName = request.getParameter("name");
        String number = request.getParameter("number");
        
        request.setCharacterEncoding("UTF-8");
        
       
        String name = "MAY";
        String pass = "urugamos";
       
        Connection db_con = null;
        //out.print("処理開始");
        try{
            //インスタンス生成
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //out.print("ドライバのロードに成功<br>");            
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db",name,pass);
            //out.print("データベースの接続に成功<br>");
            Statement stmt = db_con.createStatement();
            
            String sql = "";
  
            
           
            //処理別分岐
            if(tool.equals("add")){
              
                sql="select * from syouhin order by number desc limit 1";
                 ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                int lim = rs.getInt("number");
                lim=lim+1;
                sql = tools.Add(inName,lim);
                
                int num = stmt.executeUpdate(sql);
                
                out.print("商品名："+inName+"、追加しました。<br>");
               rs.close();
                
                 
            }else if(tool.equals("delete")){
                sql=tools.Delete(inName);
                int num= stmt.executeUpdate(sql);
                out.print("商品名："+inName+"、削除しました。<br>");
                
            }else if(tool.equals("update")){
                sql=tools.Update(inName,Integer.parseInt(number));
                int num = stmt.executeUpdate(sql);
                out.print("商品番号"+number+"を商品名："+inName+"に更新しました。<br>");
            }else{
                out.print("データベースに変更はありません。<br>");
            
            }
           
            ///一覧表示
            if("allview".equals(set)){
            out.print("一覧<br>");
            sql="select * from syouhin";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int num = rs.getInt("number");
            String Nam = rs.getString("name");
            out.print("商品番号："+num+"："+Nam+"<br>");
            
            }
            rs.close();
            }
            
          
                       
           
           stmt.close();
           
           db_con.close();
           out.print("<p><a href=\"./kanri\">入力画面に戻る</a></p><br>");
           out.print("<p><a href=\"./logout\">ログアウト</a></p>");
            //認証成功か失敗でページに飛ばすよ
          
            
              
                }catch(ClassNotFoundException e){
                out.print("ClassNotFoundException:"+e.getMessage());
                
                
                }catch(Exception e){
                out.print("Exception:"+e.getMessage());
                
                }finally{
            try{
                if(db_con !=null){
                    db_con.close();
                    out.print("データベース切断に成功");
                
                }else{
                    out.print("コネクションがありません");
                }
            }catch(SQLException e){
                out.print("SQLException:"+e.getMessage());
            }
            
        }
    
        
    }
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

class Tools{
    String Add(String st,int lim){
        
        
       return  "insert into syouhin values("+lim+",'"+st+"')";
        
       
    }
    String Delete(String st){
    
    
        return "delete from syouhin where name = '"+st+"'";
    }
    String Update(String st,int num){
        return "update syouhin set name = '"+st+"' where number = "+num;
    }
    
}
