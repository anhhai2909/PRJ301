/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import DAL.learntimeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import model.Student;
import model.learntime;

/**
 *
 * @author anhha
 */
@MultipartConfig
@WebServlet(name = "stprofileupdateservlet", urlPatterns = {"/stprofileupdate"})
public class stprofileupdateservlet extends HttpServlet {

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
            out.println("<title>Servlet stprofileupdateservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet stprofileupdateservlet at " + request.getContextPath() + "</h1>");
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
        learntimeDAO d1 = new learntimeDAO();
        String id = request.getParameter("sid");
        Student s = d.get1student(id);
        learntime lt = d1.get1lt(id);
        request.setAttribute("student", s);
        request.setAttribute("learntime", lt);
        request.getRequestDispatcher("stprofileupdate.jsp").forward(request, response);
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
        String sid = request.getParameter("sid");
        String name = request.getParameter("name");
        String sdatein = request.getParameter("datein");
        String sdateout = request.getParameter("dateout");
        String sgender = request.getParameter("gender");
        String sdob = request.getParameter("dob");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String sphone = request.getParameter("phone");
        String prname = request.getParameter("prname");
        String sprphone = request.getParameter("prphone");
        String sidnum = request.getParameter("idnum");
        try {
            StudentDAO d1 = new StudentDAO();
            learntimeDAO d2 = new learntimeDAO();

            int phone = Integer.parseInt(sphone);
            int gender = Integer.parseInt(sgender);
            int prphone = Integer.parseInt(sprphone);
            int idnum = Integer.parseInt(sidnum);
            Date dob = Date.valueOf(sdob);
            Date datein = Date.valueOf(sdatein);
            Date dateout = Date.valueOf(sdateout);

            if (sphone.length() != 10 || sprphone.length() != 10 || d1.checkexiststudentstudentupdate(sid, email, sphone, sidnum, sprphone) != null || (gender != 1 && gender != 0) || !"st".equals(sid.charAt(0) + "" + sid.charAt(1))) {
                request.setAttribute("student", d1.get1student(sid));
                request.setAttribute("learntime", d2.get1lt(sid));
                request.setAttribute("error", "**Thông tin không hợp lệ**");
                request.getRequestDispatcher("stprofileupdate.jsp").forward(request, response);
            } else {
                Student s = new Student(sid, name, gender, dob, address, sidnum, email, sphone, prname, sprphone,d1.get1student(sid).getImgaddress(), "0");               
                d1.updatestudent(s);
                d2.updatelt(new learntime(sid, datein, dateout));
                learntime lt = d2.get1lt(sid);
                request.setAttribute("student", s);
                request.setAttribute("learntime", lt);
                request.setAttribute("txt", "**Thành công**");
                request.getRequestDispatcher("stprofileupdate.jsp").forward(request, response);
            }

        } catch (ServletException | IOException | NumberFormatException e) {
            StudentDAO d1 = new StudentDAO();
            learntimeDAO d2 = new learntimeDAO();
            request.setAttribute("student", d1.get1student(sid));
            request.setAttribute("learntime", d2.get1lt(sid));
            request.setAttribute("error", "**Thông tin không hợp lệ**");
            request.getRequestDispatcher("stprofileupdate.jsp").forward(request, response);
        }
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
