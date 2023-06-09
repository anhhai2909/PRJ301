/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author anhha
 */
@WebServlet(name = "studentlistservlet", urlPatterns = {"/studentlist"})
public class stlistservlet extends HttpServlet {

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
        ArrayList<Student> list = d.getStudent();       
        int page, numperpage = 8;
        int size = list.size();
        int num = (size%numperpage==0?(size/numperpage):((size/numperpage)+1));
        int[] pagelist = new int[3];
        String pages = request.getParameter("page");
        if (pages == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pages);
        }
        if(page<=2){
            for(int i =0;i<3;i++){
                pagelist[i] = i+1;
            }
        }else if(page >=num-1){
            int count =0;
            for(int i =num-2;i<=num;i++){
                pagelist[count] = i;
                count++;
            }
        }else{
            int count =0;
            for(int i =page-1;i<=page+1;i++){
                pagelist[count] = i;
                count++;
            }
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        ArrayList<Student> listperpage =  d.getlistbypage(list, start, end);
        request.setAttribute("first", 1);
        request.setAttribute("last", num);
        request.setAttribute("list", listperpage);
        request.setAttribute("pagelist", pagelist);
        request.setAttribute("page", page);
        request.getRequestDispatcher("studentlist.jsp").forward(request, response);
     
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
