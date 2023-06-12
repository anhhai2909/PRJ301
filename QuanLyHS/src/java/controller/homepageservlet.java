/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import DAL.beststudentDAO;
import DAL.classDAO;
import DAL.markavgDAO;
import DAL.teacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Student;
import model.bestclasses;
import model.beststudent;
import model.classes;
import model.teacher;

/**
 *
 * @author anhha
 */
@WebServlet(name = "homepageservlet", urlPatterns = {"/home"})
public class homepageservlet extends HttpServlet {

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
            String tid = (String) request.getAttribute("teacherid");
            teacherDAO d = new teacherDAO();          
            StudentDAO d1 = new StudentDAO();
            teacherDAO d2 = new teacherDAO();
            classDAO d3 = new classDAO();
            beststudentDAO d4 = new beststudentDAO();
            markavgDAO d5 = new markavgDAO();
            
            request.setAttribute("teacherid", tid);
            
            teacher t = d.get1teacher(tid);
            ArrayList<Student> list1 = d1.getStudent();
            ArrayList<teacher> list2 = d2.getteacher();
            ArrayList<classes> list3 = d3.getclass();
            ArrayList<beststudent> list4 = d4.getbst();
            ArrayList<bestclasses> list5 = d5.getnum();
            
            request.setAttribute("tdata", t);
            request.setAttribute("stlistsize", list1.size());
            request.setAttribute("teacherlistsize", list2.size());
            request.setAttribute("classlistsize", list3.size());
            request.setAttribute("bestst", list4);
            request.setAttribute("bestclasses", list5);
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
