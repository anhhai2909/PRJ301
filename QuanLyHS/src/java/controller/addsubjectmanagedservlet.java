/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.accountDAO;
import DAL.subjectDAO;
import DAL.teacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.account;
import model.teacher;

/**
 *
 * @author anhha
 */
@WebServlet(name = "addsubjectmanagedservlet", urlPatterns = {"/addsubjectmanaged"})
public class addsubjectmanagedservlet extends HttpServlet {

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
            out.println("<title>Servlet addsubjectmanagedservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addsubjectmanagedservlet at " + request.getContextPath() + "</h1>");
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
        String tid = request.getParameter("tid");
        String suid = request.getParameter("suid");
        
        teacherDAO d = new teacherDAO();
        accountDAO d1 = new accountDAO();
        subjectDAO d2 = new subjectDAO();

        if (!d2.getsubjectmanagedbytidandsuid(tid, suid).isEmpty()) {
            ArrayList<teacher> list = d.getteacher2();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setList(d2.getsubjectmanaged(list.get(i).getTid()));
            }
            ArrayList<account> list1 = d1.getaccount2();
            request.setAttribute("error", "**Giáo viên hiện đang phụ trách môn học này rồi**");
            request.setAttribute("teacherlist", list);
            request.setAttribute("accountlist", list1);
            request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
        } else if (d2.get1subject(suid) == null || d.get1teacher(tid) == null) {
            ArrayList<teacher> list = d.getteacher2();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setList(d2.getsubjectmanaged(list.get(i).getTid()));
            }
            ArrayList<account> list1 = d1.getaccount2();
            request.setAttribute("error", "**Mã môn học hoặc mã giáo viên không tồn tại**");
            request.setAttribute("teacherlist", list);
            request.setAttribute("accountlist", list1);
            request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
        } else {
            ArrayList<teacher> list = d.getteacher2();
            d2.insertsubjectmanage(tid, suid);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setList(d2.getsubjectmanaged(list.get(i).getTid()));
            }
            ArrayList<account> list1 = d1.getaccount2();
            request.setAttribute("txt", "**Thành công**");
            request.setAttribute("teacherlist", list);
            request.setAttribute("accountlist", list1);
            request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
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
