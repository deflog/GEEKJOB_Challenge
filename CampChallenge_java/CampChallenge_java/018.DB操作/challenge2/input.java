/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge2;

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
@WebServlet(name = "input", urlPatterns = {"/input"})
public class input extends HttpServlet {

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
            String ins = "insert into profiles values(6,'田村 茂','034-0323-5464',25,'1992-03-23');";
            int num = stmt.executeUpdate(ins);
            String sql="select * from profiles";
            ResultSet rs = stmt.executeQuery(sql);
                //確認用
                while(rs.next()){
                int id=rs.getInt("profilesID");
                String username = rs.getString("name");
                out.print("ID:"+id+"名前:"+username);
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
