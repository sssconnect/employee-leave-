/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khare_000
 */
@WebServlet(urlPatterns = {"/Leaves"})
public class Leaves extends HttpServlet {

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
        HttpSession session=request.getSession();
        try
        {
            String unm,uid,reason;
            boolean status;
            unm=request.getParameter("uname");
            uid=request.getParameter("email");
            String sdt,edt;
            sdt = request.getParameter("sdate");
            edt= request.getParameter("edate");
            reason= request.getParameter("resn");
            
            status = addEntery(unm,uid,sdt,edt,reason);
            if(status)
            {
                session.setAttribute("Message", "Successfully Saved");
                response.sendRedirect("Useraccount.jsp");
            }
            else
            {
                session.setAttribute("Message", "error");
                response.sendRedirect("Useraccount.jsp");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public boolean addEntery(String funame, String femail,String fsdt,String fedt,String rsn) {
        Connection con;
        Statement stmt;
        
        ResultSet rs;
        try {

            String driver = "java.sql.Driver";
            String url = "jdbc:mysql://localhost:3306/emplev";
            String userName = "root";
            String password = "root";
            int day,empid=0;
            Class.forName(driver);
            con = DriverManager.getConnection(url, userName, password);
            stmt = con.createStatement();
            
            rs = stmt.executeQuery("SELECT DATEDIFF('"+fsdt+"','"+fedt+"')");
            if(rs.next())
            {
               day=rs.getInt(1);
               if(day<0) day*=-1;
            }
            else
                day=0;
             
            rs = stmt.executeQuery("select id from userreg where name='"+funame+"'");
            if(rs.next())
            {
                empid=rs.getInt(1);
            }
            
            stmt.executeUpdate("insert into leaveinfo values("+empid+",'"+funame+"','"+femail+"','"+fsdt+"','"+fedt+"','"+rsn+"',"+day+")");
            rs.close();            
            con.close();            
            return true;
        } catch (Exception e) {
            System.out.println(e);
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
