package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customer_005fprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Customer Orders</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/customer_profile.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("  <div class=\"row content\">\n");
      out.write("    <div class=\"col-sm-3 sidenav\">\n");
      out.write("      <h4>Account</h4>\n");
      out.write("      <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("        <li> <a href=\"../index.html\">Home Page</a></li>\n");
      out.write("        <li class=\"active\"> <a href=\"customer_profile.html\">Profile</a></li>\n");
      out.write("        <li> <a href=\"customer_orders.html\">Orders</a></li>\n");
      out.write("        <li> <a href=\"../index.html\">Log Out</a></li> \n");
      out.write("      </ul><br>\n");
      out.write("      <div class=\"input-group\">\n");
      out.write("        <input type=\"text\" class=\"form-control\" placeholder=\"Search...\"> <!-- Keep this? -->\n");
      out.write("        <span class=\"input-group-btn\">\n");
      out.write("          <button class=\"btn btn-default\" type=\"button\">\n");
      out.write("            <span class=\"glyphicon glyphicon-search\"></span>\n");
      out.write("          </button>\n");
      out.write("        </span>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"col-sm-9\">\n");
      out.write("      <h2><span class=\"glyphicon glyphicon-user\"></span> Profile</h2>\n");
      out.write("      <hr>\n");
      out.write("      ");
      Customer c1 = null;
      synchronized (session) {
        c1 = (Customer) _jspx_page_context.getAttribute("c1", PageContext.SESSION_SCOPE);
        if (c1 == null){
          c1 = new Customer();
          _jspx_page_context.setAttribute("c1", c1, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("      <h5>First Name: ");
      out.print(c1.getFname() );
      out.write(" </h5>\n");
      out.write("      <h5>Last Name: ");
      out.print(c1.getLname() );
      out.write("</h5>\n");
      out.write("      <h5>Username: ");
      out.print(c1.getUsername() );
      out.write("</h5>\n");
      out.write("      <h5>Email: </h5>\n");
      out.write("      <h5>Address: </h5>\n");
      out.write("      <h5>City: </h5>\n");
      out.write("      <h5>State: </h5>\n");
      out.write("      <h5>Zip Code: </h5>\n");
      out.write("      \n");
      out.write("      <br><hr>\n");
      out.write("\n");
      out.write("      <a href=\"#\">Reset Password</a>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<footer class=\"container-fluid\">\n");
      out.write("  <p>Footer Text</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
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
