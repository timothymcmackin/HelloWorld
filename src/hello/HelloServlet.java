package hello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p>Hello!</p><p> The time is: " + dtf.format(now) + "</p>");
		out.println("<p><strong>"+getVersion()+"</strong></p>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		out.println("</body></html>");
	}

	private String getVersion() {

        try {
        	ClassLoader classLoader = getClass().getClassLoader();
        	InputStream input = classLoader.getResourceAsStream("/hello/HelloWorld.properties");
			Properties properties = new Properties();
			properties.load(input);
			input.close();
			return properties.getProperty("version");
		} catch (IOException e) {
			e.printStackTrace();
		}
        return "Failed to get version number.";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
