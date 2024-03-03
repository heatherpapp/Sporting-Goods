package org.apache.jsp.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Papier.ProductList;
import Papier.Customer;
import Papier.Product;

public final class products_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <title>Papier</title>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"jumbotron\">\n");
      out.write("    <div class=\"container text-center\">\n");
      out.write("        <a href=\"../index.html\"><img src=\"http://localhost:8080/Papier/pictures/logo.png\" alt=\"Papier Logo\" width=\"200\" height=\"200\"></a>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <header class=\"d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom\">\n");
      out.write("        <ul class=\"nav col-12 col-md-auto mb-2 justify-content-center mb-md-0\">\n");
      out.write("            <li><a href=\"../index.html\" class=\"nav-link px-2 link-dark\">Home</a></li>\n");
      out.write("            <li><a href=\"products.jsp\" class=\"nav-link px-2 link-secondary\">Products</a></li>\n");
      out.write("            <li><a href=\"http://localhost:8080/Papier/customer/customer_profile.jsp\" class=\"nav-link px-2 link-dark\">Profile</a></li>\n");
      out.write("            <li><a href=\"http://localhost:8080/Papier/customer/customer_orders.jsp\" class=\"nav-link px-2 link-dark\">Cart</a></li>\n");
      out.write("            <li><a href=\"#\" class=\"nav-link px-2 link-dark\">About</a></li>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("        <div class=\"col-md-3 text-end\">\n");
      out.write("            <a href=\"../customer/customer_login.html\"><button type=\"button\" class=\"btn btn-outline-primary me-2\">Login</button></a>\n");
      out.write("            <a href=\"../customer/customer_register.html\"><button type=\"button\" class=\"btn btn-primary\">Sign-up</button></a>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"container text-center\">\n");
      out.write("    <h3><u>All Products</u></h3>\n");
      out.write("</div><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    ");
      Papier.Customer c1 = null;
      synchronized (session) {
        c1 = (Papier.Customer) _jspx_page_context.getAttribute("c1", PageContext.SESSION_SCOPE);
        if (c1 == null){
          c1 = new Papier.Customer();
          _jspx_page_context.setAttribute("c1", c1, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("    ");
      Papier.ProductList cart = null;
      synchronized (session) {
        cart = (Papier.ProductList) _jspx_page_context.getAttribute("cart", PageContext.SESSION_SCOPE);
        if (cart == null){
          cart = new Papier.ProductList();
          _jspx_page_context.setAttribute("cart", cart, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("    ");
 
        if (c1.getUsername() == "")
        {
            c1.selectDB("guest@guest.com");
        } 
      out.write("\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("        <!-- Paper -->\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">Paper</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"http://localhost:8080/Papier/pictures/paper.jpeg\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("                    <form action=\"http://localhost:8080/Papier/AddToCartServlet\" method=\"post\">\n");
      out.write("                        <input type=\"text\" id=\"quantity\" name=\"quantity\" value=\"0\">\n");
      out.write("                        <input type=\"hidden\" id=\"itemNo\" name=\"itemNo\" value=\"1\">\n");
      out.write("                        <input type=\"hidden\" id=\"userName\" name=\"userName\" value=\"");
      out.print(c1.getUsername() );
      out.write("\">\n");
      out.write("                        <input type=\"submit\" value=\"Add to Cart\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Pencils -->\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">Pencils</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"http://localhost:8080/Papier/pictures/pencils.jpeg\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("                    <form action=\"http://localhost:8080/Papier/AddToCartServlet\" method=\"post\">\n");
      out.write("                        <input type=\"text\" id=\"quantity\" name=\"quantity\" value=\"0\">\n");
      out.write("                        <input type=\"hidden\" id=\"itemNo\" name=\"itemNo\" value=\"2\">\n");
      out.write("                        <input type=\"hidden\" id=\"userName\" name=\"userName\" value=\"");
      out.print(c1.getUsername() );
      out.write("\">\n");
      out.write("                        <input type=\"submit\" value=\"Add to Cart\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Pens -->\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">Pens</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"http://localhost:8080/Papier/pictures/pens.jpeg\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("                    <form action=\"http://localhost:8080/Papier/AddToCartServlet\" method=\"post\">\n");
      out.write("                        <input type=\"text\" id=\"quantity\" name=\"quantity\" value=\"0\">\n");
      out.write("                        <input type=\"hidden\" id=\"itemNo\" name=\"itemNo\" value=\"3\">\n");
      out.write("                        <input type=\"hidden\" id=\"userName\" name=\"userName\" value=\"");
      out.print(c1.getUsername() );
      out.write("\">\n");
      out.write("                        <input type=\"submit\" value=\"Add to Cart\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div><br>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("        <!-- Notebooks -->\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">Notebooks</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"http://localhost:8080/Papier/pictures/notebooks.jpeg\" class = \"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("                    <form action=\"http://localhost:8080/Papier/AddToCartServlet\" method=\"post\">\n");
      out.write("                        <input type=\"text\" id=\"quantity\" name=\"quantity\" value=\"0\">\n");
      out.write("                        <input type=\"hidden\" id=\"itemNo\" name=\"itemNo\" value=\"4\">\n");
      out.write("                        <input type=\"hidden\" id=\"userName\" name=\"userName\" value=\"");
      out.print(c1.getUsername() );
      out.write("\">\n");
      out.write("                        <input type=\"submit\" value=\"Add to Cart\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Printers -->\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">Printers</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"http://localhost:8080/Papier/pictures/printer.jpeg\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("                    <form action=\"http://localhost:8080/Papier/AddToCartServlet\" method=\"post\">\n");
      out.write("                        <input type=\"text\" id=\"quantity\" name=\"quantity\" value=\"0\">\n");
      out.write("                        <input type=\"hidden\" id=\"itemNo\" name=\"itemNo\" value=\"5\">\n");
      out.write("                        <input type=\"hidden\" id=\"userName\" name=\"userName\" value=\"");
      out.print(c1.getUsername() );
      out.write("\">\n");
      out.write("                        <input type=\"submit\" value=\"Add to Cart\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Computers -->\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">Computers</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"http://localhost:8080/Papier/pictures/computer.jpeg\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("                    <form action=\"http://localhost:8080/Papier/AddToCartServlet\" method=\"post\">\n");
      out.write("                        <input type=\"text\" id=\"quantity\" name=\"quantity\" value=\"0\">\n");
      out.write("                        <input type=\"hidden\" id=\"itemNo\" name=\"itemNo\" value=\"6\">\n");
      out.write("                        <input type=\"hidden\" id=\"userName\" name=\"userName\" value=\"");
      out.print(c1.getUsername() );
      out.write("\">\n");
      out.write("                        <input type=\"submit\" value=\"Add to Cart\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div><br><br>\n");
      out.write("<hr>\n");
      out.write("\n");
      out.write("<footer class=\"container-fluid text-center\">\n");
      out.write("    <p>Fulfiller login <a href=\"fulfiller/fulfiller_login.html\">here</a></p>\n");
      out.write("    <p>Copyright © 2021 Papier Inc. All rights reserved.</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
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
