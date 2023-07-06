/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAL.classDAO;
import DAL.markavgDAO;
import DAL.yearsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.classes;
import model.markavg;
import model.years;

/**
 *
 * @author anhha
 */
@WebServlet(name="markavgsearchservlet", urlPatterns={"/markavgsearch"})
public class markavgsearchservlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet markavgsearchservlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet markavgsearchservlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        markavgDAO d = new markavgDAO();
        yearsDAO d2 = new yearsDAO();
        String searchsid = request.getParameter("searchsid");
        String searchsname = request.getParameter("searchsname");
        String searchyears = request.getParameter("searchyears");
        ArrayList<markavg> list = d.getavgbysidsnameandyear(searchsid, searchsname, searchyears);
        classDAO d1 = new classDAO();
        String ys = request.getParameter("y");
        int y;
        String cid = request.getParameter("cid");
        String cids;
        if (ys == null) {
            y = 2019;
        } else {
            y = Integer.parseInt(ys);
        }
        if (cid == null) {
            cids = "10a1";
        } else {
            cids = cid;
        }
        ArrayList<years> list3 = d2.getyear();
        ArrayList<classes> list2 = d1.getclassbyyear(y);

        request.setAttribute("c", cids);
        request.setAttribute("year", y);

        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);

        request.setAttribute("list", list);
        request.getRequestDispatcher("markavg.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
