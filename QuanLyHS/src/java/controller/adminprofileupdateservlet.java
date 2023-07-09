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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.account;
import model.teacher;

/**
 *
 * @author anhha
 */
@WebServlet(name = "adminprofileupdateservlet", urlPatterns = {"/adminprofileupdate"})
public class adminprofileupdateservlet extends HttpServlet {

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
            out.println("<title>Servlet adminprofileupdateservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminprofileupdateservlet at " + request.getContextPath() + "</h1>");
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
        accountDAO d2 = new accountDAO();
        HttpSession session = request.getSession();
        teacher t = (teacher) session.getAttribute("teacher");
        ArrayList<teacher> list = d.getteacher();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int flag = 0;
        for (teacher i : list) {
            if (!i.getTid().equals(t.getTid()) && email.equals(i.getEmail())) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            account a = d2.getaccountbytid(t.getTid());
            request.setAttribute("error", "**Thông tin cung cấp không hợp lệ**");
            request.setAttribute("taccount", a);
            request.setAttribute("tdata", t);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            d.updateteacher(t.getTid(), name, email);
            account a = d2.getaccountbytid(t.getTid());
            request.setAttribute("txt", "**Cập nhật thành công,Thông tin sẽ được cập nhật vào lần đăng nhập sau**");
            request.setAttribute("taccount", a);
            request.setAttribute("tdata", t);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
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
        accountDAO d = new accountDAO();
        HttpSession session = request.getSession();
        teacher t = (teacher) session.getAttribute("teacher");
        ArrayList<account> list = d.getaccount();
        String pass = request.getParameter("pass");
        String pass2 = request.getParameter("pass2");
        int flag = 0;
        for (account i : list) {
            if (!i.getTid().equals(t.getTid()) && pass.equals(i.getPass())) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            account a = d.getaccountbytid(t.getTid());
            request.setAttribute("error", "**Mật khẩu không hợp lệ**");
            request.setAttribute("taccount", a);
            request.setAttribute("tdata", t);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            if (!pass2.equals(pass)) {
                account a = d.getaccountbytid(t.getTid());
                request.setAttribute("error", "**Mật khẩu nhập lại không đúng**");
                request.setAttribute("taccount", a);
                request.setAttribute("tdata", t);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            } else {
                d.editacc(pass, t.getTid());
                account a = d.getaccountbytid(t.getTid());
                request.setAttribute("txt", "**Cập nhật thành công,Thông tin sẽ được cập nhật vào lần đăng nhập sau**");
                request.setAttribute("taccount", a);
                request.setAttribute("tdata", t);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            }
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
