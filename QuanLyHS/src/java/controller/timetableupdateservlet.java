/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.subjectDAO;
import DAL.timetableDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.timetable;

/**
 *
 * @author anhha
 */
@WebServlet(name = "timetableupdateservlet", urlPatterns = {"/timetableupdate"})
public class timetableupdateservlet extends HttpServlet {

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
            out.println("<title>Servlet timetableupdateservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet timetableupdateservlet at " + request.getContextPath() + "</h1>");
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
        timetableDAO d = new timetableDAO();
        String cids = request.getParameter("cid");
        String cid;
        if (cids == null) {
            cid = "10a1";
        } else {
            cid = cids;
        }

        String[] listt2 = d.gettimetalbe(cid, "T2");
        String[] listt3 = d.gettimetalbe(cid, "T3");
        String[] listt4 = d.gettimetalbe(cid, "T4");
        String[] listt5 = d.gettimetalbe(cid, "T5");
        String[] listt6 = d.gettimetalbe(cid, "T6");

        request.setAttribute("cid", cid);
        request.setAttribute("listt2", listt2);
        request.setAttribute("listt3", listt3);
        request.setAttribute("listt4", listt4);
        request.setAttribute("listt5", listt5);
        request.setAttribute("listt6", listt6);
        request.getRequestDispatcher("timetableupdate.jsp").forward(request, response);

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
        timetableDAO d = new timetableDAO();
        subjectDAO d2 = new subjectDAO();
        String[] listt2 = new String[6];
        String[] listt3 = new String[6];
        String[] listt4 = new String[6];
        String[] listt5 = new String[6];
        String[] listt6 = new String[6];
        String cid = request.getParameter("cid");
        for (int i = 0; i < 5; i++) {
            if (!"".equals(request.getParameter("t2slot" + (i + 1)))) {
                if (d2.get1subjectbygrade(request.getParameter("t2slot" + (i + 1)),cid.substring(0, 2)) != null) {
                    listt2[i] = request.getParameter("t2slot" + (i + 1));
                    if (d.checkexisttimetalbe(cid, "T2", i + 1)) {
                        d.updatetimetable(new timetable("T2", i + 1, listt2[i], cid));
                    } else {
                        d.inserttimetable(new timetable("T2", i + 1, listt2[i], cid));
                    }
                } else {
                    request.setAttribute("cid", cid);
                    request.setAttribute("error", "**Mã môn học không chính xác**");
                    request.getRequestDispatcher("timetableupdate.jsp").forward(request, response);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!"".equals(request.getParameter("t3slot" + (i + 1)))) {
                if (d2.get1subjectbygrade(request.getParameter("t3slot" + (i + 1)),cid.substring(0, 2)) != null) {
                    listt3[i] = request.getParameter("t3slot" + (i + 1));
                    if (d.checkexisttimetalbe(cid, "T3", i + 1)) {
                        d.updatetimetable(new timetable("T3", i + 1, listt3[i], cid));
                    } else {
                        d.inserttimetable(new timetable("T3", i + 1, listt3[i], cid));
                    }
                } else {
                    request.setAttribute("cid", cid);
                    request.setAttribute("error", "**Mã môn học không chính xác**");
                    request.getRequestDispatcher("timetableupdate.jsp").forward(request, response);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!"".equals(request.getParameter("t4slot" + (i + 1)))) {
                if (d2.get1subjectbygrade(request.getParameter("t4slot" + (i + 1)),cid.substring(0,2)) != null) {
                    listt4[i] = request.getParameter("t4slot" + (i + 1));
                    if (d.checkexisttimetalbe(cid, "T4", i + 1)) {
                        d.updatetimetable(new timetable("T4", i + 1, listt4[i], cid));
                    } else {
                        d.inserttimetable(new timetable("T4", i + 1, listt4[i], cid));
                    }
                } else {
                    request.setAttribute("cid", cid);
                    request.setAttribute("error", "**Mã môn học không chính xác**");
                    request.getRequestDispatcher("timetableupdate.jsp").forward(request, response);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!"".equals(request.getParameter("t5slot" + (i + 1)))) {
                if (d2.get1subjectbygrade(request.getParameter("t5slot" + (i + 1)),cid.substring(0, 2)) != null) {
                    listt5[i] = request.getParameter("t5slot" + (i + 1));
                    if (d.checkexisttimetalbe(cid, "T5", i + 1)) {
                        d.updatetimetable(new timetable("T5", i + 1, listt5[i], cid));
                    } else {
                        d.inserttimetable(new timetable("T5", i + 1, listt5[i], cid));
                    }
                } else {
                    request.setAttribute("cid", cid);
                    request.setAttribute("error", "**Mã môn học không chính xác**");
                    request.getRequestDispatcher("timetableupdate.jsp").forward(request, response);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!"".equals(request.getParameter("t6slot" + (i + 1)))) {
                if (d2.get1subjectbygrade(request.getParameter("t6slot" + (i + 1)),cid.substring(0, 2)) != null) {
                    listt6[i] = request.getParameter("t6slot" + (i + 1));
                    if (d.checkexisttimetalbe(cid, "T6", i + 1)) {
                        d.updatetimetable(new timetable("T6", i + 1, listt6[i], cid));
                    } else {
                        d.inserttimetable(new timetable("T6", i + 1, listt6[i], cid));
                    }
                } else {
                    request.setAttribute("cid", cid);
                    request.setAttribute("error", "**Mã môn học không chính xác**");
                    request.getRequestDispatcher("timetableupdate.jsp").forward(request, response);
                }
            }
        }
        request.setAttribute("cid", cid);
        request.setAttribute("listt2", listt2);
        request.setAttribute("listt3", listt3);
        request.setAttribute("listt4", listt4);
        request.setAttribute("listt5", listt5);
        request.setAttribute("listt6", listt6);
        request.setAttribute("txt", "**Cập nhật thành công**");
        request.getRequestDispatcher("timetableupdate.jsp").forward(request, response);
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
