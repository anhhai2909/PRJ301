/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.classDAO;
import DAL.teacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.classes;
import model.teacher;

/**
 *
 * @author anhha
 */
@WebServlet(name = "addclassservlet", urlPatterns = {"/addclass"})
public class addclassservlet extends HttpServlet {

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
            out.println("<title>Servlet addclassservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addclassservlet at " + request.getContextPath() + "</h1>");
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
        ArrayList<teacher> list = d.getteacher();
        request.setAttribute("list", list);
        request.getRequestDispatcher("addclass.jsp").forward(request, response);
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
        try {
            classDAO d = new classDAO();
            teacherDAO d1 = new teacherDAO();
            ArrayList<teacher> list = d1.getteacher();
            String cid = request.getParameter("cid");
            String cname = request.getParameter("name");
            String years = request.getParameter("year");
            String tid = request.getParameter("tid");
            int y = Integer.parseInt(years);
            teacher t = d1.get1teacherbyyearandid(tid, y);
            if (t == null) {
                classes c = d.get1classbycidandyear(cid, y);
                if (c == null) {
                    String n = cid.charAt(0) + "" + cid.charAt(1);
                    if (n.equals("10") || n.equals("11") || n.equals("12")) {
                        classes newclass = new classes(cid, cname, 0, tid);
                        d.insertclasstoclasshistory(newclass, y);
                        request.setAttribute("list", list);
                        request.setAttribute("txt", "**Thêm thành công**");
                        request.getRequestDispatcher("addclass.jsp").forward(request, response);
                    } else {
                        request.setAttribute("list", list);
                        request.setAttribute("Error", "Mã lớp không hợp lệ");
                        request.getRequestDispatcher("addclass.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("list", list);
                    request.setAttribute("Error", "**Tên lớp hoặc mã lớp đã tồn tại**");
                    request.getRequestDispatcher("addclass.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("list", list);
                request.setAttribute("Error", "**Giáo viên được chọn đang phụ trách lớp khác**");
                request.getRequestDispatcher("addclass.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            teacherDAO d1 = new teacherDAO();
            ArrayList<teacher> list = d1.getteacher();
            request.setAttribute("list", list);
            request.setAttribute("Error", "**Thông tin cung cấp không hợp lệ**");
            request.getRequestDispatcher("addclass.jsp").forward(request, response);
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
