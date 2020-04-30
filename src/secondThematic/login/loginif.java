package secondThematic.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import secondThematic.sessionConn;

@WebServlet("/login/loginif")
public class loginif extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		System.out.println(name);
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		
		SessionFactory sessionFactory = sessionConn.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		loginDao Dao = new loginDao(session);
		out.print(Dao.checkLogin(name, pwd));
		session.getTransaction().commit();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
