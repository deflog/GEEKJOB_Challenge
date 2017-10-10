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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author p-user
 */
@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

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
        String userID = request.getParameter("ID");
        String userPASS = request.getParameter("PASS");
       
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
            
            String sql = "select * from userprofiles where userid='"+userID+"'";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            String passkey = rs.getString("password");
            String idkey = rs.getString("userid");
                rs.close();
                stmt.close();
            //認証成功か失敗でページに飛ばすよ
            if(userID.equals(idkey)&&userPASS.equals(passkey)){
            HttpSession session=request.getSession();
            session.setAttribute("login",true);
            
            RequestDispatcher dispatch = request.getRequestDispatcher("/kanri");
            dispatch.forward(request, response);
            
            
            }else{
            RequestDispatcher dispatch = request.getRequestDispatcher("/login");
            dispatch.forward(request, response);
            }
            
              
                }catch(ClassNotFoundException e){
                out.print("ClassNotFoundException:"+e.getMessage());
                
                
                }catch(Exception e){
                out.print("Exception:"+e.getMessage());
                
                }finally{
            try{
                if(db_con !=null){
                    db_con.close();
                    out.print("データベース切断に成功");
                RequestDispatcher dispatch = request.getRequestDispatcher("/login");
                dispatch.forward(request, response);
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
