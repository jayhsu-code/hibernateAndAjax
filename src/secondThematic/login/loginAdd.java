package secondThematic.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import secondThematic.sessionConn;


@WebServlet("/login/loginAdd")
public class loginAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter out = response.getWriter();
		SessionFactory sessionfactory = sessionConn.getSessionfactory();
		Session session = sessionfactory.getCurrentSession();
		loginDao dao=new loginDao(session);
		String useraccount=request.getParameter("account");
		String userBirthday=request.getParameter("birth");
		String userPassword=request.getParameter("pwd");
		String username=request.getParameter("name");
		String userAddress=request.getParameter("address");
		String useremail=request.getParameter("email");
		int gender=Integer.parseInt(request.getParameter("gender"));
		session.beginTransaction();
		dao.accountadd(useraccount, userPassword, userBirthday, userAddress, useremail, username, gender);
		session.getTransaction().commit();
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
