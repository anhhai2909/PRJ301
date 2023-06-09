/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.markavgDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.markavg;

/**
 *
 * @author anhha
 */
@WebServlet(name = "markavgupdateservlet", urlPatterns = {"/markavgupdate"})
public class markavgupdateservlet extends HttpServlet {

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
            out.println("<title>Servlet markavgupdateservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet markavgupdateservlet at " + request.getContextPath() + "</h1>");
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
        int years = Integer.parseInt(request.getParameter("years"));
        markavgDAO d = new markavgDAO();
        markavg m = d.get1avg(years, sid);
        request.setAttribute("m", m);
        request.getRequestDispatcher("markavgupdate.jsp").forward(request, response);
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
        markavgDAO d = new markavgDAO();
        String sid = request.getParameter("sid");
        String cid = request.getParameter("cid");
        String avgs = request.getParameter("avg");
        int years = Integer.parseInt(request.getParameter("y"));
        try {
            double avg = Double.parseDouble(avgs);
            if (avg < 0 || avg > 10) {
                markavg m = d.get1avg(years, sid);
                request.setAttribute("error", "**Thông tin cung cấp không hợp lệ**");
                request.setAttribute("m", m);
                request.getRequestDispatcher("markavgupdate.jsp").forward(request, response);
            } else {
                d.updatemarkavg(new markavg(sid, cid, avg, years));
                request.setAttribute("txt", "**Cập nhật thành công**");
                request.setAttribute("m", new markavg(sid, cid, avg, years));
                request.getRequestDispatcher("markavgupdate.jsp").forward(request, response);
            }
        } catch (ServletException | IOException | NumberFormatException e) {
            markavg m = d.get1avg(years, sid);
            request.setAttribute("error", "**Thông tin cung cấp không hợp lệ**");
            request.setAttribute("m", m);
            request.getRequestDispatcher("markavgupdate.jsp").forward(request, response);
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
