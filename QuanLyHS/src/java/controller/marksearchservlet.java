/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.classDAO;
import DAL.markDAO;
import DAL.markavgDAO;
import DAL.subjectDAO;
import DAL.yearsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.classes;
import model.mark;
import model.subject;
import model.years;

/**
 *
 * @author anhha
 */
@WebServlet(name = "marksearchservlet", urlPatterns = {"/marksearch"})
public class marksearchservlet extends HttpServlet {

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
            out.println("<title>Servlet marksearchservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet marksearchservlet at " + request.getContextPath() + "</h1>");
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
        markDAO d = new markDAO();
        subjectDAO d3 = new subjectDAO();
        classDAO d4 = new classDAO();       
        yearsDAO d5 = new yearsDAO();
        String searchsid = request.getParameter("searchsid");
        String searchname = request.getParameter("searchsname");
        String searchsuid = request.getParameter("searchsuid");
        String searchyears = request.getParameter("searchyears");
        
        ArrayList<mark> list = d.getmark_by_sid_sname_suid_years(searchsid, searchname, searchsuid, searchyears);
        
        String ys = request.getParameter("y");
        int y;
        String cid = request.getParameter("cid");
        String cids;
        String suid = request.getParameter("suid");
        String suids;
        ArrayList<years> list2 = d5.getyear();
        if (ys == null) {
            y = 2019;
        } else {
            y = Integer.parseInt(ys);
        }
        ArrayList<classes> list3 = d4.getclassbyyear(y);
        if (cid == null) {
            cids = list3.get(0).getCid();
        } else {
            cids = cid;
        }       
        ArrayList<subject> list4 = d3.getsubjectbyyearandclass(y, cids);
        if (suid == null) {
            suids = list4.get(0).getSuid();
        } else {
            suids = suid;
        }
        

        request.setAttribute("year", y);
        request.setAttribute("cid", cids);
        request.setAttribute("suid", suids);
        
        request.setAttribute("list", list);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
        request.setAttribute("list4", list4);
        request.getRequestDispatcher("marklist.jsp").forward(request, response);
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
