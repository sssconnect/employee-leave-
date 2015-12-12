/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shailendra_000
 */
@WebServlet(urlPatterns = {"/AdminAccount"})
public class AdminAccount extends HttpServlet {

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
        Connection con;
        Statement stmt;
        ResultSet rs;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emplev", "root", "root");
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from leaveinfo");

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
                out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
                out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>");
                out.println("<style>\n"
                        + "            /* Remove the navbar's default margin-bottom and rounded borders */ \n"
                        + "            .navbar {\n"
                        + "                margin-bottom: 0;\n"
                        + "                border-radius: 0;\n"
                        + "            }\n"
                        + "\n"
                        + "            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */\n"
                        + "            .row.content {height: 450px}\n"
                        + "\n"
                        + "            /* Set gray background color and 100% height */\n"
                        + "            .sidenav {\n"
                        + "                padding-top: 20px;\n"
                        + "                background-color: #f1f1f1;\n"
                        + "                height: 100%;\n"
                        + "            }\n"
                        + "\n"
                        + "            /* Set black background color, white text and some padding */\n"
                        + "            footer {\n"
                        + "                background-color: #555;\n"
                        + "                color: white;\n"
                        + "                padding: 15px;\n"
                        + "            }\n"
                        + "\n"
                        + "            /* On small screens, set height to 'auto' for sidenav and grid */\n"
                        + "            @media screen and (max-width: 767px) {\n"
                        + "                .sidenav {\n"
                        + "                    height: auto;\n"
                        + "                    padding: 15px;\n"
                        + "                }\n"
                        + "                .row.content {height:auto;} \n"
                        + "            }\n"
                        + "        </style>");
                out.println("<title>Leave Application</title>");
                out.println("</head>");

                out.println("<body>\n"
                        + "        <nav class=\"navbar navbar-inverse\">\n"
                        + "            <div class=\"container-fluid\">\n"
                        + "                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n"
                        + "                    <ul class=\"nav navbar-nav navbar-right\">\n"
                        + "                        <li><a onclick=\"logout()\" href=\"index.jsp\"><span class=\"mouse-change glyphicon glyphicon-log-in\"></span> Logout </a></li>\n"
                        + "                    </ul>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </nav>\n"
                        + "\n"
                        + "        <hr>\n"
                        + "        <h2 class=\"intro-text text-center\">\n"
                        + "            <strong>Employees Leaves detail</strong>\n"
                        + "        </h2>\n"
                        + "        <hr>\n"
                        + "        \n"
                        + "                \n"
                        + "                    <center>\n"
                        + "                        <div class=\"box\">\n"
                        + "                        <div class=\"col-sm-2 \">\n"
                        + "                        </div>"
                        + "                         <div class=\"col-sm-8\">\n"
                        + "                            <table border=\"1\" width=\"100%\">\n"
                        + "                                <tr>\n"
                        + "                                    <th width=\"10%\">Employee ID</th>\n"
                        + "                                    <th width=\"20%\">Name</th>\n"
                        + "                                    <th width=\"20%\">Email</th>\n"
                        + "                                    <th width=\"10%\">Start Date</th>\n"
                        + "                                    <th width=\"10%\">End Date</th>\n"
                        + "                                    <th width=\"30%\">Reason</th>\n"
                        + "                                    <th width=\"10%\">Days</th>\n"
                        + "                                </tr>\n");
                while (rs.next()) {
                    out.println("                              <tr>\n"
                            + "                                        <td>" + rs.getInt(1) + "</td>\n"
                            + "                                        <td>" + rs.getString(2) + "</td>\n"
                            + "                                        <td>" + rs.getString(3) + "</td>\n"
                            + "                                        <td>" + rs.getString(4) + "</td>\n"
                            + "                                        <td>" + rs.getString(5) + "</td>\n"
                            + "                                        <td>" + rs.getString(6) + "</td>\n"
                            + "                                        <td>" + rs.getString(7) + "</td>\n"
                            + "                                        </tr>\n");
                }
                out.println("</table>\n");
                out.println("\n"
                        + "                            <button class=\"btn btn-primary\" style=\"width: 100px;margin-top: 2%\" onclick=\"goBack()\">Go Back</button>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"col-sm-2 \">\n"
                        + "                        </div>"
                        + "                        </div>\n"
                        + "\n"
                        + "                    </center>\n"
                        + "                   \n"
                        + "          \n"
                        + "\n"
                        + "\n"
                        + "        <script>\n"
                        + "            function logout() {\n"
                        + "                alert(\"You have Successfully Logout!\");\n"
                        + "            }\n"
                        + "        </script>\n"
                        + "    </body>");

                out.println("</html>");
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {

            }
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
