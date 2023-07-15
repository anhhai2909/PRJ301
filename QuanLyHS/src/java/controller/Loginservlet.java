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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.teacher;

/**
 *
 * @author anhha
 */
@WebServlet(name = "Loginservlet", urlPatterns = {"/login"})
public class Loginservlet extends HttpServlet {

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
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String check = request.getParameter("remember");

            teacherDAO d1 = new teacherDAO();
            accountDAO d = new accountDAO();
            String tid = d.get1account(user, pass);
            if (tid != null) {               
                teacher t = d1.get1teacher(tid);
                HttpSession session = request.getSession();
                session.setAttribute("teacher", t);
                if(d.checkadminaccount(tid)==null){
                    session.setAttribute("role", 1);
                }else{
                    session.setAttribute("role", 2);
                }            
                if (check != null) {
                    Cookie username = new Cookie("user", user);
                    username.setMaxAge(60*60*24*30);
                    Cookie password = new Cookie("pass", pass);
                    password.setMaxAge(60*60*24*30);
                    response.addCookie(username);
                    response.addCookie(password);
                }
                response.sendRedirect("home");
            } else {
                request.setAttribute("error", "*Mật khẩu hoặc tài khoản không hợp lệ!*");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
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
