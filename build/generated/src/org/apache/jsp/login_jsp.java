package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"fr\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\" />\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("  <title>Connexion - Feed4U</title>\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap\" rel=\"stylesheet\" />\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css\" />\n");
      out.write("  <style>\n");
      out.write("    body {\n");
      out.write("      margin: 0;\n");
      out.write("      font-family: 'Poppins', sans-serif;\n");
      out.write("      background-color: #fdf8f5;\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: center;\n");
      out.write("      align-items: center;\n");
      out.write("      height: 100vh;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .container {\n");
      out.write("      display: flex;\n");
      out.write("      max-width: 1000px;\n");
      out.write("      width: 90%;\n");
      out.write("      background-color: #fff;\n");
      out.write("      box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);\n");
      out.write("      border-radius: 20px;\n");
      out.write("      overflow: hidden;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .left, .right {\n");
      out.write("      padding: 40px;\n");
      out.write("      flex: 1;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .left {\n");
      out.write("      display: flex;\n");
      out.write("      flex-direction: column;\n");
      out.write("      align-items: center;\n");
      out.write("      justify-content: center;\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .left img.logo {\n");
      out.write("      width: 200px;\n");
      out.write("      margin-bottom: 0px;\n");
      out.write("      margin-top: 30px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .left h2 {\n");
      out.write("      color: #e08c68;\n");
      out.write("      font-weight: 700;\n");
      out.write("      margin-bottom: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .left form {\n");
      out.write("      width: 100%;\n");
      out.write("      max-width: 300px;\n");
      out.write("      margin-top: 0px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .left input {\n");
      out.write("      width: 100%;\n");
      out.write("      padding: 12px;\n");
      out.write("      border: 1px solid #ddd;\n");
      out.write("      border-radius: 8px;\n");
      out.write("      margin-bottom: 12px;\n");
      out.write("      font-size: 1em;\n");
      out.write("      background-color: #f0f4ff;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("   .left button {\n");
      out.write("  display: block;\n");
      out.write("  background-color: #e08c68;\n");
      out.write("  color: white;\n");
      out.write("  padding: 10px 30px;\n");
      out.write("  font-size: 0.95em;\n");
      out.write("  border: none;\n");
      out.write("  border-radius: 6px;\n");
      out.write("  font-weight: 500;\n");
      out.write("  cursor: pointer;\n");
      out.write("  transition: background-color 0.3s;\n");
      out.write("  margin: 10px auto 0; /* CENTRAGE */\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("    .left button:hover {\n");
      out.write("      background-color: #d07550;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .left .register-link {\n");
      out.write("      margin-top: 12px;\n");
      out.write("      font-size: 0.95em;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .left .register-link a {\n");
      out.write("      color: #e08c68;\n");
      out.write("      text-decoration: none;\n");
      out.write("      font-weight: 500;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .right {\n");
      out.write("      background-color: #fff1e9;\n");
      out.write("      display: flex;\n");
      out.write("      flex-direction: column;\n");
      out.write("      justify-content: center;\n");
      out.write("      align-items: center;\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .right h1 {\n");
      out.write("      color: #333;\n");
      out.write("      font-size: 2em;\n");
      out.write("      margin-bottom: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .right p {\n");
      out.write("      color: #555;\n");
      out.write("      font-size: 1em;\n");
      out.write("      max-width: 300px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .right img {\n");
      out.write("      max-width: 180px;\n");
      out.write("      margin-top: 25px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    @media (max-width: 768px) {\n");
      out.write("      .container {\n");
      out.write("        flex-direction: column;\n");
      out.write("        border-radius: 0;\n");
      out.write("        height: 100vh;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      .right {\n");
      out.write("        order: -1;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"left\">\n");
      out.write("      <img src=\"images/logo.png\" alt=\"Feed4U Logo\" class=\"logo\"/>\n");
      out.write("      <h2>Connexion</h2>\n");
      out.write("      <form method=\"post\" action=\"LoginController\">\n");
      out.write("        <input type=\"text\" name=\"email\" placeholder=\"Email\" required/>\n");
      out.write("        <input type=\"password\" name=\"mdp\" placeholder=\"Mot de passe\" required/>\n");
      out.write("        <button type=\"submit\">Se connecter</button>\n");
      out.write("      </form>\n");
      out.write("      <div class=\"register-link\">\n");
      out.write("        Pas encore inscrit ? <a href=\"register.jsp\">Créer un compte</a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"right\">\n");
      out.write("      <h1>Bienvenue sur Feed4U</h1>\n");
      out.write("      <p>La plateforme intuitive pour gérer et consulter les feedbacks clients. Connectez-vous pour explorer !</p>\n");
      out.write("      <img src=\"images/feedback.png\" alt=\"Illustration\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</body>\n");
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
