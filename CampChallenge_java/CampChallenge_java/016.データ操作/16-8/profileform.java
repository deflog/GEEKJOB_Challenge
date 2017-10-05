/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge7;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author p-user
 */
@WebServlet(name = "profileform", urlPatterns = {"/profileform"})
public class profileform extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String userName = "例：山田花子";
            String usersex = "male";
            String userhobby = "趣味を入力してね！";
            
            HttpSession session = request.getSession();
            if((String)session.getAttribute("syumi") != null){
            userhobby =(String)session.getAttribute("syumi");
            }
            if((String)session.getAttribute("name")!=null){
            userName =(String)session.getAttribute("name");
            }
            if((String)session.getAttribute("seibetu")!=null){
            usersex =(String)session.getAttribute("seibetu");
            }
            out.print("<html>");
            out.print("プロフィールを入力してね<br>");
            out.print("<form action = \"./getForm\" method = \"post\">");
            out.print("<label for=\"name_e\">名前は？<br></label>");
            out.print("<input type=\"text\" name=\"name\" id = \"name_e\" placeholder ="+ userName+">");
            out.print("<br>男の子？女の子？<br>");
            out.print("<label><input type = \"radio\" name=\"seibetu\" value = \"male\" ");
            if("male".equals(usersex)){
            out.print("checked = \"checked\"");
            }
            out.print( ">男の子</label>");
            out.print("<label><input type = \"radio\" name=\"seibetu\" value = \"female\""); 
            if("female".equals(usersex)){
            out.print("checked = \"checked\"");
            }
            out.print(">女の子</label>");
            out.print("<label for = \"syumi_s\"><br>趣味は何？<br></label>");
            out.print("<textarea name = \"syumi\" rows = \"4\" cole = \"40\" id=\"syumi_s\" placeholder =" +userhobby+"></textarea><br>");
            out.print("<p><input type=\"submit\"  value=\"送る\"><p>");
            out.print("</form>");
            out.print("</html>");
            
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
