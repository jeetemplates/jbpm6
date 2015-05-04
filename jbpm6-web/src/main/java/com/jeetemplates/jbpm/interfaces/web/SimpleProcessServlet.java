/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeetemplates.jbpm.interfaces.web;

import com.jeetemplates.jbpm.application.ProcessManagerBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that starts a simple process when called.
 *
 * @author paoesco
 */
@WebServlet(name = "SimpleProcessServlet", urlPatterns = {"/SimpleProcessServlet"})
public class SimpleProcessServlet extends HttpServlet {

    @Inject
    private ProcessManagerBean processManagerBean;

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
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html>");
        printWriter.write("<body>");
        try {
            processManagerBean.startProcess("simpleProcess");
            response.setStatus(200);
            printWriter.write("<div>Hooray ! Process started and finished !</div>");
        } catch (Exception exception) {
            response.setStatus(500);
            printWriter.write("<div>Oops ! Something went wrong...</div>");
            printWriter.write("<div>" + exception.getLocalizedMessage() + "</div>");
        }
        printWriter.write("<div><a href=\"" + request.getContextPath() + "\">Return to home</a></div>");
        printWriter.write("</body>");
        printWriter.write("</html>");

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
