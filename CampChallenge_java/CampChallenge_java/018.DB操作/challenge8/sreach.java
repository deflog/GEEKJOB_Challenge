/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge8;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author p-user
 */
@WebServlet(name = "sreach", urlPatterns = {"/sreach"})
public class sreach extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String sreach = request.getParameter("name");
           String name = "MAY";
          String pass = "urugamos";
           Connection db_con = null;
        try{
            //インスタンス生成
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //out.print("ドライバのロードに成功<br>");            
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db",name,pass);
            //out.print("データベースの接続に成功<br>");
            Statement stmt = db_con.createStatement();
           
            ResultSet rs = null;
            String sql="select * from profiles where name like '%"+sreach+"%'";
            rs = stmt.executeQuery(sql);
            
                if(!(rs.next())){
                out.print("そんな人いないよ！");
             
                
                }
                //確認用
                while(rs.next()){
                int id=rs.getInt("profilesID");
                String username = rs.getString("name");
                String tel=rs.getString("tel");
                int age=rs.getInt("age");
                Date birthday = rs.getDate("birthday");
                
                out.print("ID:"+id+"名前:"+username+"電話番号:"+tel+"歳:"+age+"誕生日"+birthday+"<br>");
                }
                rs.close();
                stmt.close();
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
            out.print("最後の処理です");
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
