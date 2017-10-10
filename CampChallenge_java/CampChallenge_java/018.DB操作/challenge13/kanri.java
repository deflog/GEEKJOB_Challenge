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
@WebServlet(name = "kanri", urlPatterns = {"/kanri"})
public class kanri extends HttpServlet {

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
        HttpSession session = request.getSession();
 
        if((boolean)session.getAttribute("login")){
            
            
        
           out.print("<html>");
           //URL
           out.print("<form action = \"./syouhindata\" method = \"get\">");
          
           out.print("商品管理<br>");
           out.print("<input type=\"radio\" name = \"tool\" value = \"add\" checked = \"checked\">追加");
           out.print("<input type=\"radio\" name = \"tool\" value = \"delete\">削除");
           out.print("<input type=\"radio\" name = \"tool\" value = \"update\">更新");
            out.print("<input type=\"radio\" name = \"tool\" value = \"not\">表示のみ<br>");
           
           out.print("更新する場合は商品番号<br>");
           out.print("<input type=\"number\" name =\"number\"><br>");
           out.print("<input type=\"checkbox\" name = \"set\" value = \"allview\">一覧を表示<br>");

           out.print("商品名<br>");
           out.print("<input type=\"text\" name=\"name\">");
           
           //追加情報
           out.print("");
          
         
           out.print("<input type=\"submit\" value = \"決定\">");
           out.print("</form>");
           out.print("</html>");
        
    }else{
            //trueない場合はログインへ
           RequestDispatcher dispatch = request.getRequestDispatcher("/login");
            dispatch.forward(request, response);
            
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
