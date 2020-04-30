package secondThematic.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import secondThematic.sessionConn;


@WebServlet("/login/accountConfirm")
public class accountConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		response.setContentType("text/html ; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("hi0");
		SessionFactory sesfactory = sessionConn.getSessionfactory();
		System.out.println("hi");
		Session session = sesfactory.getCurrentSession();
		System.out.println("hi1");
		session.beginTransaction();
		System.out.println("hi2");
		loginDao dao=new loginDao(session);
		out.print(dao.checkAccount(account));
		session.getTransaction().commit();
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
