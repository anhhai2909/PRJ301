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
@WebServlet(name = "teacheraccountupdateservlet", urlPatterns = {"/teacheraccountupdate"})
public class teacheraccountupdateservlet extends HttpServlet {

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
            out.println("<title>Servlet teacheraccountupdateservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet teacheraccountupdateservlet at " + request.getContextPath() + "</h1>");
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
        subjectDAO d2 = new subjectDAO();

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");

        if (d1.getaccountbyuser(user).isEmpty()) {
            ArrayList<teacher> list = d.getteacher2();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setList(d2.getsubjectmanaged(list.get(i).getTid()));
            }
            ArrayList<account> list1 = d1.getaccount2();
            request.setAttribute("error", "**Tài khoản không tồn tại**");
            request.setAttribute("teacherlist", list);
            request.setAttribute("accountlist", list1);
            request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
        } else if (!pass.equals(repass)) {
            ArrayList<teacher> list = d.getteacher2();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setList(d2.getsubjectmanaged(list.get(i).getTid()));
            }
            ArrayList<account> list1 = d1.getaccount2();
            request.setAttribute("error", "**Mật khẩu nhập lại không hợp lệ**");
            request.setAttribute("teacherlist", list);
            request.setAttribute("accountlist", list1);
            request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
        } else {
            ArrayList<teacher> list = d.getteacher2();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setList(d2.getsubjectmanaged(list.get(i).getTid()));
            }
            d1.editacc2(pass, user);
            ArrayList<account> list1 = d1.getaccount2();
            request.setAttribute("txt", "**Thành công**");
            request.setAttribute("teacherlist", list);
            request.setAttribute("accountlist", list1);
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
