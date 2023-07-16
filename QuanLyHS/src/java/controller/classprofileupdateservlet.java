/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import DAL.accountDAO;
import DAL.classDAO;
import DAL.teacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Student;
import model.classes;
import model.teacher;

/**
 *
 * @author anhha
 */
@WebServlet(name = "classprofileupdateservlet", urlPatterns = {"/classprofileupdate"})
public class classprofileupdateservlet extends HttpServlet {

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
            out.println("<title>Servlet classprofileupdateservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet classprofileupdateservlet at " + request.getContextPath() + "</h1>");
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
        try {
            classDAO d = new classDAO();
            accountDAO d1 = new accountDAO();
            StudentDAO d2 = new StudentDAO();
            teacherDAO d3 = new teacherDAO();
            String cid = request.getParameter("cid");
            String updatename = request.getParameter("updatename");
            String updatetid = request.getParameter("updatetid");

            int y = Integer.parseInt(request.getParameter("y"));
            HttpSession session = request.getSession();
            teacher t = (teacher) session.getAttribute("teacher");
            classes c = d.get1classbycidandyear(cid, y);
            ArrayList<Student> list = d2.getstudentbyclassandyear(cid, y);
            
            request.setAttribute("y", y);
            request.setAttribute("classes", c);
            request.setAttribute("list", list);
            
            if (d.getclassbytidyearandcid(cid, t.getTid(), request.getParameter("y")) != null || d1.checkadminaccount(t.getTid()) == null) {
                d.updateclass(updatename, updatetid, cid, y);
                request.setAttribute("txt", "**Thành công**");
                ArrayList<String> list2 = d3.getfreeteacher(y);
                request.setAttribute("list2", list2);
                request.getRequestDispatcher("classprofile.jsp").forward(request, response);
            } else {
                ArrayList<String> list2 = d3.getfreeteacher(y);
                request.setAttribute("list2", list2);
                request.setAttribute("error", "**Hiện tại bạn không được phân công phụ trách lớp học này**");
                request.getRequestDispatcher("classprofile.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {

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
