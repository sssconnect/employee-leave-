package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>Leave Managemnet</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            /* Remove the navbar's default margin-bottom and rounded borders */ \n");
      out.write("            .navbar {\n");
      out.write("                margin-bottom: 0;\n");
      out.write("                border-radius: 0;\n");
      out.write("                background: appworkspace;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */\n");
      out.write("            .row.content {height: 450px}\n");
      out.write("\n");
      out.write("            /* Set gray background color and 100% height */\n");
      out.write("            .sidenav {\n");
      out.write("                padding-top: 20px;\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("                height: 100%;\n");
      out.write("            }\n");
      out.write("            @media screen and (max-width: 767px) {\n");
      out.write("                .sidenav {\n");
      out.write("                    height: auto;\n");
      out.write("                    padding: 15px;\n");
      out.write("                }\n");
      out.write("                .row.content {height:auto;} \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        ");
if (session.getAttribute("Message") == "error") {
        
      out.write("\n");
      out.write("        <script>alert(\"User Name or password incorrect\");</script>\n");
      out.write("        ");

                session.removeAttribute("Message");
            }
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-left\">\n");
      out.write("                        <li class=\"dropdown\"><a class=\"mouse-change glyphicon glyphicon-log-in dropdown-toggle\" data-toggle=\"dropdown\" >Login<span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a id=\"ulog\" >User</a></li>\n");
      out.write("                                <li><a id=\"adlog\">Admin</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"modal fade\" id=\"uModal\" role=\"dialog\">\n");
      out.write("\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                \n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\" style=\"padding:35px 50px;\">\n");
      out.write("                        <div class=\"row\"><button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button></div>\n");
      out.write("                        <h4 >Login</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\" style=\"padding:40px 50px;\">\n");
      out.write("                        <form role=\"form\" method=\"post\" action=\"Log\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"usrname\"><span class=\"glyphicon glyphicon-user\"></span> Username</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"usrname\" placeholder=\"Enter email\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"psw\"><span class=\"glyphicon glyphicon-eye-open\"></span> Password</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"psw\" placeholder=\"Enter password\">\n");
      out.write("                                <input type=\"hidden\" name=\"chec\" value=\"user\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"checkbox\">\n");
      out.write("                                <label><input type=\"checkbox\" value=\"\" checked>Remember me</label>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary btn-block\"><span class=\"glyphicon glyphicon-off\"></span> Login</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal fade\" id=\"adModal\" role=\"dialog\">\n");
      out.write("\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                \n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\" style=\"padding:35px 50px;\">\n");
      out.write("                        <div class=\"row\"><button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button></div>\n");
      out.write("                        <h4 >Login</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\" style=\"padding:40px 50px;\">\n");
      out.write("                        <form role=\"form\" method=\"post\" action=\"Log\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"usrname\"><span class=\"glyphicon glyphicon-user\"></span> Admin</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"usrname\" placeholder=\"Enter email\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"psw\"><span class=\"glyphicon glyphicon-eye-open\"></span> Password</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"psw\" placeholder=\"Enter password\">\n");
      out.write("                                <input type=\"hidden\" name=\"chec\" value=\"admin\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"checkbox\">\n");
      out.write("                                <label><input type=\"checkbox\" value=\"\" checked>Remember me</label>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary btn-block\"><span class=\"glyphicon glyphicon-off\"></span> Login</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"Useraccount.jsp\"></a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#ulog\").click(function () {\n");
      out.write("                    $(\"#uModal\").modal();\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#adlog\").click(function () {\n");
      out.write("                    $(\"#adModal\").modal();\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
