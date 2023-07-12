/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import DAL.learntimeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import model.Student;
import model.learntime;

/**
 *
 * @author anhha
 */
@MultipartConfig
@WebServlet(name = "addstudentservlet", urlPatterns = {"/addstudent"})
public class addstudentservlet extends HttpServlet {

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
            out.println("<title>Servlet addstudentservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addstudentservlet at " + request.getContextPath() + "</h1>");
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
        try {
            StudentDAO d1 = new StudentDAO();
            learntimeDAO d2 = new learntimeDAO();
            Part part = request.getPart("photo");
            String realpath = request.getServletContext().getRealPath("/img");
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

           // String sid = request.getParameter("sid");
            String name = request.getParameter("name");
            String sdatein = request.getParameter("datein");
            String sdateout = request.getParameter("dateout");
            String sgender = request.getParameter("gender");
            String sdob = request.getParameter("dob");
            String address = request.getParameter("address");
//            String email = request.getParameter("email");
            String sphone = request.getParameter("phone");
            String prname = request.getParameter("prname");
            String sprphone = request.getParameter("prphone");
            String sidnum = request.getParameter("idnum");
            
            int gender = Integer.parseInt(sgender);
            Date dob = Date.valueOf(sdob);
            Date datein = Date.valueOf(sdatein);
            Date dateout = Date.valueOf(sdateout);
            
            ArrayList<Student> list = d1.getStudent();
            int maxid =0;
            for(int i =0;i< list.size();i++){
                if(maxid < Integer.parseInt(list.get(i).getsID().substring(3, list.get(i).getsID().length()))){
                    maxid =  Integer.parseInt(list.get(i).getsID().substring(3, list.get(i).getsID().length()));
                }
            }      
            
            String sid = "st0"+(maxid+1);
            String email = sid + "@gmail.com";
            if (sphone.length() != 10 || sprphone.length() != 10 || d1.checkexiststudentstudent(sid, email, sphone, sidnum, sprphone)!=null  || (gender!=1 && gender !=0) || !"st".equals(sid.charAt(0)+""+sid.charAt(1))) {
                request.setAttribute("error", "**Thông tin không hợp lệ**");
                request.getRequestDispatcher("addstudent.jsp").forward(request, response);
            } else {
                Student s = new Student(sid, name, gender, dob, address, sidnum, email, sphone, prname, sprphone, ("img/" + filename), "0");
                d1.insertstudent(s);
                d2.insertlt(new learntime(sid, datein, dateout));
                request.setAttribute("txt", "**Thêm thành công**");
                request.getRequestDispatcher("addstudent.jsp").forward(request, response);
            }

        } catch (ServletException | IOException | NumberFormatException e) {
            request.setAttribute("error", "**Thông tin không hợp lệ**");
            request.getRequestDispatcher("addstudent.jsp").forward(request, response);
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
