/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge4;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author p-user
 */
@WebServlet(name = "sampleB", urlPatterns = {"/sampleB"})
public class sampleB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Time tiMe=new Time();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //yyyy/MM/dd HH:mm:ss
            //時刻作って数字にするよ(to,from)、toは-されるよ
        long result= tiMe.diffTime((tiMe.Timer("2015/12/31 23:59:59")),(tiMe.Timer("2015/1/1 0:0:0")));
            //結果表示
           out.print(result);
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
class Time{
    Date Timer(String s){
        
        Date day=new Date();
        try {
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            
            
            day = sdf.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
        return day;
        
    }
 String nowTime(Date d){
  
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日 HH時:mm分:ss秒");
    
    return sdf.format(d);
    
    
    }
 //日付受け取ってミリ秒返すよ！
 long diffTime(Date to,Date from){
     long datefrom = from.getTime();
     long dateto   = to.getTime();
     long def = dateto-datefrom;
     return def;
 }
}

