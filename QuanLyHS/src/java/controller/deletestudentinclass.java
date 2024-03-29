/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import DAL.accountDAO;
import DAL.classDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.teacher;

/**
 *
 * @author anhha
 */
@WebServlet(name = "deletestudentinclass", urlPatterns = {"/deletestudentinclass"})
public class deletestudentinclass extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet deletestudentinclass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deletestudentinclass at " + request.getContextPath() + "</h1>");
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
        StudentDAO d = new StudentDAO();
        classDAO d2 = new classDAO();
        classDAO d3 = new classDAO();
        accountDAO d4 = new accountDAO();
        String sid = request.getParameter("sid");
        String cid = request.getParameter("cid");
        String years = request.getParameter("y");
        int y = Integer.parseInt(years);
        
        HttpSession session = request.getSession();
        teacher t = (teacher) session.getAttribute("teacher");
        if (d3.getclassbytidyearandcid(cid, t.getTid(), years) != null||d4.checkadminaccount(t.getTid())==null) {
            d.deletelearnhistory(sid, y);
            d2.updatenumberofstudent(cid, y);
            request.getRequestDispatcher("classprofile").forward(request, response);
        } else {
            request.getRequestDispatcher("classprofile").forward(request, response);
        }
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
