package secondThematic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@WebServlet("/MasksOrder")
public class MasksOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html ;charset=UTF-8");
	PrintWriter out = response.getWriter();
	int id = Integer.parseInt(request.getParameter("id"));
	SessionFactory sessionfactory = sessionConn.createfactory();
	Session session = sessionfactory.getCurrentSession();
	
	
	session.beginTransaction();
	maskDao dao=new maskDao(session);
	dao.orderMasks(id);
	
	session.getTransaction().commit();
	out.print(true);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
