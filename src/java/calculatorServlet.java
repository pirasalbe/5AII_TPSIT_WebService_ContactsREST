/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pirasalbe
 */
public class calculatorServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculatorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet calculatorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        String error = "";
        int status = 0;
        
        
        String url = request.getRequestURI();
        int uri=0;
        if(url.endsWith("add")) uri=1;
        else if(url.endsWith("sub")) uri=2;
        else if(url.endsWith("mul")) uri=3;
        else if(url.endsWith("div")) uri=4;
        
        String a = request.getParameter("x"), b = request.getParameter("y");
        int x=0,y=0,z=0;
        boolean converted = false; 
        
        //can't convert
        try{
            x = Integer.parseInt(a);
            y = Integer.parseInt(b);
            converted = true;
        } catch(Exception e){
            error = "Wrong numbers";
            status = 500;
        }
        
        if(converted){
            status=200;
            error="successful";
            
            switch(uri){
                case 1:
                    z=x+y;
                    break;
                case 2:
                    z=x-y;
                    break;
                case 3:
                    z=x*y;
                    break;
                case 4:
                    if(y==0){
                        status=500;
                        error="Can't divide per 0";
                    } else
                        z=x/y;
                    break;
            }
        }
        
        if(status!=500)
            try (PrintWriter out = response.getWriter()) {
                out.println(z);
            }
        
        response.setStatus(status);
        response.sendError(status, error);
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
