/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.accountDAO;
import DAL.teacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Paths;
import java.util.ArrayList;
import model.account;
import model.teacher;

/**
 *
 * @author anhha
 */
@MultipartConfig
@WebServlet(name = "teacherandaccountmanageservlet", urlPatterns = {"/teacherandaccountmanage"})
public class teacherandaccountmanageservlet extends HttpServlet {

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
            out.println("<title>Servlet teacherandaccountmanageservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet teacherandaccountmanageservlet at " + request.getContextPath() + "</h1>");
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
        teacherDAO d = new teacherDAO();
        accountDAO d1 = new accountDAO();
        ArrayList<teacher> list = d.getteacher2();
        ArrayList<account> list1 = d1.getaccount2();
        request.setAttribute("teacherlist", list);
        request.setAttribute("accountlist", list1);
        request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
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
        teacherDAO d = new teacherDAO();
        accountDAO d1 = new accountDAO();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        Part part = request.getPart("photo");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        ArrayList<teacher> list = d.getteacher();
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < Integer.parseInt(list.get(i).getTid().substring(3, list.get(i).getTid().length()))) {
                max = Integer.parseInt(list.get(i).getTid().substring(3, list.get(i).getTid().length()));
            }
        }
        String tid = "GV0" + (max + 1);
        
        ArrayList<account> list1 = d1.getaccount();
        for (int i = 0; i < list1.size(); i++) {
            if (max < Integer.parseInt(list1.get(i).getUser().substring(5, list1.get(i).getUser().length()))) {
                max = Integer.parseInt(list1.get(i).getUser().substring(5, list1.get(i).getUser().length()));
            }
        }
        String username = "admin" + (max + 1);
        
        if (d.getteacherbyemail(email) != null) {
            request.setAttribute("error", "**Thông tin cung cấp không hợp lệ**");
            ArrayList<teacher> list2 = d.getteacher2();
            ArrayList<account> list3 = d1.getaccount2();
            request.setAttribute("teacherlist", list2);
            request.setAttribute("accountlist", list3);
            request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
        } else {
            d.insertteacher(tid, name, email, ("img/" + filename));
            d1.insertacc(username, username, tid, role);
            request.setAttribute("txt", "**Thành công**");
            ArrayList<teacher> list2 = d.getteacher2();
            ArrayList<account> list3 = d1.getaccount2();
            request.setAttribute("teacherlist", list2);
            request.setAttribute("accountlist", list3);
            request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
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
