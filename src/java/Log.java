/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shailendra_000
 */
@WebServlet(urlPatterns = {"/Log"})
public class Log extends HttpServlet {

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
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Log</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Log at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            String name = request.getParameter("usrname");
            String pass = request.getParameter("psw");
            String usr = request.getParameter("chec");
            if (validateUser(name, pass, usr)) {
                if(usr.equals("user"))          
                {
                    session.setAttribute("Message", "user");
                    session.setAttribute("Users", name);                    
                    response.sendRedirect("Useraccount.jsp");
                }
                else if(usr.equals("admin"))
                {
                    session.setAttribute("Message", "admin");
                    response.sendRedirect("AdminAccount");
                }
            } else {
                session.setAttribute("Message", "error");
                response.sendRedirect("index.jsp");
            }

        }

    }

    public boolean validateUser(String name, String pass, String user) {
        Connection con;
        Statement stmt;
        ResultSet rs;
        try {

            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emplev", "root", "root");
            stmt = con.createStatement();
            if (user.equals("user")) {
                rs = stmt.executeQuery("select * from userreg where name='" + name + "' and pass='" + pass + "'");
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
            if (user.equals("admin")) {
                rs = stmt.executeQuery("select * from adminreg where name='" + name + "' and pass='" + pass + "'");
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {

        }
        return false;
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
