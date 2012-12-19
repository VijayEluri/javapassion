
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This is a simple example of an HTTP Servlet.  It responds to the GET
 * method of the HTTP protocol.
 */
public class ResponseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext servletContext = request.getServletContext();
        servletContext.log("-----> ResponseServlet entered");
        
        PrintWriter out = response.getWriter();

        // then write the data of the response
        String username = request.getParameter("username");

        if ((username != null) && (username.length() > 0)) {
            out.println("<h2>Hello," + username + "!</h2>");
            out.println("<h2>You live in " + servletContext.getAttribute("city") + "!</h2>");
            out.println("<h2>Your age is  " + servletContext.getAttribute("age") + "!</h2>");
        }
    }

    public String getServletInfo() {
        return "The Response servlet says hello.";
    }
}
