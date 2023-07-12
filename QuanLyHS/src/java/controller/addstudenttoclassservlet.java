/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import DAL.classDAO;
import DAL.markDAO;
import DAL.markavgDAO;
import DAL.subjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Student;
import model.mark;
import model.markavg;
import model.subject;

/**
 *
 * @author anhha
 */
@WebServlet(name = "addstudenttoclassservlet", urlPatterns = {"/addstudenttoclass2"})
public class addstudenttoclassservlet extends HttpServlet {

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
            out.println("<title>Servlet addstudenttoclassservlet2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addstudenttoclassservlet2 at " + request.getContextPath() + "</h1>");
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
        classDAO d2 = new classDAO();
        subjectDAO d3 = new subjectDAO();
        markDAO d4 = new markDAO();
        markavgDAO d5 = new markavgDAO();

        String id = request.getParameter("id");
        String year = request.getParameter("year");
        String cid = request.getParameter("cid");
        int y = Integer.parseInt(year);

        ArrayList<Student> list = d.getStudent();
        ArrayList<Student> list1 = new ArrayList<>();
        ArrayList<Student> list2 = new ArrayList<>();
        ArrayList<Student> list3 = new ArrayList<>();
        
        String oldcid = d2.getcIDbysidandyear(id, y);
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
        if (d.checkexiststudentinclass(id, y, cid)) {
            request.setAttribute("error", "**Học sinh đã ở trong lớp học đã chọn**");
            request.getRequestDispatcher("addstudenttoclass.jsp").forward(request, response);
        } else {
            if (d.checkexistlh(id, y)) {      
                
                d.updatelearnhistory(id, cid, y);
                d2.updatenumberofstudent(oldcid, y);
                d2.updatenumberofstudent(cid, y);
                d5.updatemarkavgcid(cid, id, y);
                ArrayList<subject> list4 = d3.getsubjectbygrade(cid.substring(0, 2));
                for (subject i : list4) {
                    d4.updatecidbysidandyearsandsuid(cid, i.getSuid(), id, y);
                }
                request.setAttribute("txt", "**Thành công**");
                request.getRequestDispatcher("addstudenttoclass.jsp").forward(request, response);
            } else {
                d.insertintolearnhistory(id, cid, y);
                d2.updatenumberofstudent(cid, y);
                ArrayList<subject> list4 = d3.getsubjectbygrade(cid.substring(0, 2));
                d5.insertmarkavg(new markavg(id, cid, 0, y));
                for (subject i : list4) {
                    d4.insertmark(new mark(0, 0, 0, 0, 0, 0, 0, i.getSuid(), id, y), cid);
                }
                request.setAttribute("txt", "**Thành công**");
                request.getRequestDispatcher("addstudenttoclass.jsp").forward(request, response);
            }
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
