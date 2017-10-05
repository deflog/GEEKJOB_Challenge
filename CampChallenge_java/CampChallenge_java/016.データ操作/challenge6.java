/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author p-user
 */
@WebServlet(urlPatterns = {"/challenge6"})
public class challenge6 extends HttpServlet {

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
             
            /*Cookie ct = new Cookie("Date","いちご");
            response.addCookie(ct);*/
            Date now= new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy年-MM月-dd日 HH時mm分ss秒");
            String time = sdf.format(now);
            Cookie cookie = new Cookie("Date", URLEncoder.encode(time, "UTF-8"));
            response.addCookie(cookie);
           
            
            Cookie cs[] = request.getCookies();
            
            if (cs != null) {
                //out.print("1");
                for (int i = 0; i < cs.length; i++) {
                    //out.print("2");
                    if (cs[i].getName().equals("Date")) {
                        //out.print("3");s
                        String val=URLDecoder.decode(cs[i].getValue(),"UTF-8");
                        out.print("前回アクセスしたのは" + val);
                        break;
                         }
                }
                }else{
                        out.print("値がありません");
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
