/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAL.StudentDAO;
import DAL.classDAO;
import DAL.markDAO;
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
import model.years;

/**
 *
 * @author anhha
 */
@WebServlet(name="deletestudentservlet", urlPatterns={"/deletestudent"})
public class deletestudentservlet extends HttpServlet {
   
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
            out.println("<title>Servlet deletestudentservlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deletestudentservlet at " + request.getContextPath () + "</h1>");
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
        StudentDAO d = new  StudentDAO();
        markDAO d2 = new markDAO();
        markavgDAO d3 = new markavgDAO();
        classDAO d4 = new classDAO();
        yearsDAO d5 = new yearsDAO();
        String sid = request.getParameter("sid");
        String page = request.getParameter("page");
        d.deletelearn(sid);
        d.deletelearnhistorybysid(sid);       
        d2.deletemarkbysid(sid);
        d3.deletemarkavgbysid(sid);     
        d.deletestudent(sid);
        ArrayList<years> yearlist = d5.getyear();
        ArrayList<classes> classlist = d4.getallclass();
        for(years i: yearlist){
            for(classes j:classlist){
                d4.updatenumberofstudent(j.getCid(), i.getYear());
            }
        }
        request.getRequestDispatcher("studentlist?page="+page).forward(request, response);
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
