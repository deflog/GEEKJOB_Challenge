/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge8;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author p-user
 */
@WebServlet(name = "profile3", urlPatterns = {"/profile3"})
public class profile3 extends HttpServlet {
    
    String[] profile(String id){
    
       String[] data1={"3434","田中","6月7日","北海道"};
       String[] data2={"4545","木村","2月3日",null};
       String[] data3={"5656","安藤","8月4日","大阪"};
       String[] data4={""};
      if(data1[0]==id){
      return data1;
      } else if(data2[0]==id){
      return data2;
      }else if(data3[0]==id){
      return data3;
      }else{
      return data4;
      }
    }

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
            
            Integer limit =2;
            /* TODO output your page here. You may use following sample code. */
            String[] ids={"3434","4545","5656"};
            
            for(int j=0;j<limit;j++){
            
            String datas[]=profile(ids[j]);
            
           
           for(int i=1;i<4;i++){
           if(datas[i]==null){
           continue;
           }
               out.print(datas[i]+"<br>");
            
           }
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
