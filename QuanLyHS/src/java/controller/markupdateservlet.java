/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.markDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.mark;

/**
 *
 * @author anhha
 */
@WebServlet(name = "markupdateservlet", urlPatterns = {"/markupdate"})
public class markupdateservlet extends HttpServlet {

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
            out.println("<title>Servlet markservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet markservlet at " + request.getContextPath() + "</h1>");
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
        String sid = request.getParameter("sid");
        String suid = request.getParameter("suid");
        int years = Integer.parseInt(request.getParameter("years"));
        markDAO d = new markDAO();
        mark m = d.get1mark(sid, suid, years);
        request.setAttribute("years", years);
        request.setAttribute("m", m);
        request.getRequestDispatcher("markupdate.jsp").forward(request, response);
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
        markDAO d = new markDAO();

        String sid = request.getParameter("sid");
        String m1s = request.getParameter("m1");
        String m2s = request.getParameter("m2");
        String pt1s = request.getParameter("pt1");
        String pt2s = request.getParameter("pt2");
        String mts = request.getParameter("mt");
        String fes = request.getParameter("fe");
        String suid = request.getParameter("suid");
        int years = Integer.parseInt(request.getParameter("years"));
        try {
            double m1 = Double.parseDouble(m1s);
            double m2 = Double.parseDouble(m2s);
            double pt1 = Double.parseDouble(pt1s);
            double pt2 = Double.parseDouble(pt2s);
            double mt = Double.parseDouble(mts);
            double fe = Double.parseDouble(fes);
            if (m1 < 0 || m1 > 10 || m2 < 0 || m2 > 10 || pt1 < 0 || pt1 > 10 || pt2 < 0 || pt2 > 10 || mt < 0 || mt > 10 || fe < 0 || fe > 10) {
                request.setAttribute("error", "**Các đầu điểm cung cấp không hợp lệ**");
                mark m = d.get1mark(sid, suid, years);
                request.setAttribute("years", years);
                request.setAttribute("m", m);
                request.getRequestDispatcher("markupdate.jsp").forward(request, response);
            } else {
                double avg = (double) Math.ceil(((m1 + m2 + pt1 + pt2 + mt * 2 + fe * 3) / 9)*10)/10;
                mark m = new mark(m1, m2, pt1, pt2, mt, fe, avg, suid, sid, years);
                d.updatemark(m);
                request.setAttribute("txt", "**Cập nhật điểm thành công**");
                request.setAttribute("years", years);
                request.setAttribute("m", m);
                request.getRequestDispatcher("markupdate.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "**Các đầu điểm cung cấp không hợp lệ**");
            mark m = d.get1mark(sid, suid, years);
            request.setAttribute("years", years);
            request.setAttribute("m", m);
            request.getRequestDispatcher("markupdate.jsp").forward(request, response);
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
