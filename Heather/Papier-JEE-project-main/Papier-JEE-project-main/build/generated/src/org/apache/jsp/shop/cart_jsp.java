package org.apache.jsp.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Papier.Product;
import Papier.ProductList;
import Papier.Product;
import Papier.Customer;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      Papier.ProductList cart = null;
      synchronized (session) {
        cart = (Papier.ProductList) _jspx_page_context.getAttribute("cart", PageContext.SESSION_SCOPE);
        if (cart == null){
          cart = new Papier.ProductList();
          _jspx_page_context.setAttribute("cart", cart, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      Papier.Customer c1 = null;
      synchronized (session) {
        c1 = (Papier.Customer) _jspx_page_context.getAttribute("c1", PageContext.SESSION_SCOPE);
        if (c1 == null){
          c1 = new Papier.Customer();
          _jspx_page_context.setAttribute("c1", c1, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <h1>Your Cart</h1><br>\n");
      out.write("        <table border=\"2\" class=\"center\">\n");
      out.write("            <tr><th>Item Name</th><th>Item Description</th><th>Quantity</th><th>Price per unit</th></tr>\n");
      out.write("            ");
  
                ProductList cart = c1.getCurrentOrder();
            for(int i=0; i<cart.count; i++)
            {
                Product p1 = cart.getProduct(i);
                String name = p1.getName();
                String desc = p1.getDesc();
                String quantity = p1.getQuantity();
                Double price = p1.getPrice();
            
               
      out.write("\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(name );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(desc );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(quantity );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(price );
      out.write("</td>\n");
      out.write("            \n");
      out.write("            </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            </table><br>\n");
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
