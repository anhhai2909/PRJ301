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
@WebServlet(name = "loaddatatoaddstudenttoclass", urlPatterns = {"/loaddata"})
public class loaddatatoaddstudenttoclass extends HttpServlet {

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
            out.println("<title>Servlet addstudenttoclassservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addstudenttoclassservlet at " + request.getContextPath() + "</h1>");
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
        classDAO d1 = new classDAO();
        accountDAO d2 = new accountDAO();
        teacherDAO d3 = new teacherDAO();
        String year = request.getParameter("year");
        int y = Integer.parseInt(year);
        String cid = request.getParameter("cid");
        HttpSession session = request.getSession();
        teacher t = (teacher) session.getAttribute("teacher");
        
        if (d1.getclassbytidyearandcid(cid, t.getTid(), year) != null||d2.checkadminaccount(t.getTid())==null) {
            ArrayList<Student> list = d.getStudent();
            ArrayList<Student> list1 = new ArrayList<>();
            ArrayList<Student> list2 = new ArrayList<>();
            ArrayList<Student> list3 = new ArrayList<>();
            for (int i = 0; i < list.size() / 3; i++) {
                list1.add(list.get(i));
            }
            for (int i = list.size() / 3; i < list.size() / 3 * 2; i++) {
                list2.add(list.get(i));
            }
            for (int i = list.size() / 3 * 2; i < list.size(); i++) {
                list3.add(list.get(i));
            }
            request.setAttribute("year", year);
            request.setAttribute("cid", cid);
            request.setAttribute("list1", list1);
            request.setAttribute("list2", list2);
            request.setAttribute("list3", list3);
            request.getRequestDispatcher("addstudenttoclass.jsp").forward(request, response);
        } else {
        classes c = d1.get1classbycidandyear(cid, y);
        ArrayList<Student> list  = d.getstudentbyclassandyear(cid, y);
        ArrayList<String> list2 = d3.getfreeteacher(y);
        request.setAttribute("y",y);
        
        request.setAttribute("classes", c);
        request.setAttribute("list",list);
        request.setAttribute("list2",list2);
        request.setAttribute("error", "**Bạn không được phân công phụ trách lớp học này**");
        request.getRequestDispatcher("classprofile.jsp").forward(request, response);
        //    request.getRequestDispatcher("classprofile?cid=" + cid + "&y=" + year).forward(request, response);
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
