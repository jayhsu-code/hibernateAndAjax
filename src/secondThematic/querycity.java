package secondThematic;

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

@WebServlet("/querycity")
public class querycity extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF8");
		String city = request.getParameter("city");
		SessionFactory factory = sessionConn.createfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		maskDao Dao=new maskDao(session);
		List<masks> list = Dao.querycity(city);
		System.out.println(list.size());
		JSONArray jary=new JSONArray();
		for(masks lis:list) {
			JSONObject jobj=new JSONObject();
			jobj.put("hospitalName", lis.getHospitalName());
			jobj.put("hospitalAddress", lis.getHopsitalAddress());
			jobj.put("MaskOfAdult", lis.getMaskOfAdult());
			jobj.put("hospitalID", lis.getHospitalId());
			jobj.put("id", lis.getId());
			jary.put(jobj);
		}
		
		
		
		session.getTransaction().commit();
		out.print(jary);
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
