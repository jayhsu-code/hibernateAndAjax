package secondThematic.login;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/login/imagephoto")
public class imagephoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Collection<Part> parts = request.getParts();
			if(parts!=null) {
			for (Part part:parts) {
				
				System.out.println(part.getName());
				System.out.println(request.getParameter(part.getName()));
			}
			}
		}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
