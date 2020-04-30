package secondThematic.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import secondThematic.sessionConn;


@WebServlet("/login/loginedit")
public class loginedit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String account = request.getParameter("account");
		SessionFactory sessionfactory = sessionConn.getSessionfactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();
		loginDao lDao=new loginDao(session);
		List<loginBean> lbean = lDao.editAccount(account);
		JSONArray jary=new JSONArray();
		for(loginBean bean:lbean) {
			JSONObject jobj=new JSONObject();
			jobj.put("id",bean.getUserId());
			jobj.put("account",bean.getUserAccount());
			jobj.put("password", bean.getUserPassword());
			jobj.put("birth", bean.getUserBirthday());
			jobj.put("address", bean.getUserAddress());
			jobj.put("email", bean.getUseremail());
			jobj.put("gender", bean.getGender());
			jobj.put("name", bean.getUsername());
			jary.put(jobj);
		}
		out.print(jary);
		session.getTransaction().commit();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
