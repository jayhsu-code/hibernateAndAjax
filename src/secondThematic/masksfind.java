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

@WebServlet("/masksfind")
public class masksfind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		SessionFactory sessionfactory = sessionConn.getSessionfactory();

		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();
		maskDao Dao = new maskDao(session);
		List<masks> list = Dao.queryAll();
		JSONArray jaray = new JSONArray();
		int i = ((request.getAttribute("count")==null)? 0:Integer.parseInt(request.getAttribute("count").toString()));
		int b=i+30;
		String txt = "<tr><th>醫院名稱<th>醫院位置<th><醫院剩餘口罩>";
		for (masks ls : list) {
			i++;
			JSONObject jobj = new JSONObject();
			jobj.append("HospitalName", ls.getHospitalName());
			jobj.append("HopsitalAddress", ls.getHopsitalAddress());
			jobj.append("MaskOfAdult", ls.getMaskOfAdult());
			jobj.append("id", ls.getId());
			jaray.put(jobj);

			txt += "<tr><td>" + ls.getHospitalName();
			txt += "<td>" + ls.getHopsitalAddress();
			txt += "<td>" + ls.getMaskOfAdult();

			if (i > b)
				break;
		}
		
		out.write(txt);
		session.getTransaction().commit();
		sessionConn.closeFactory();

	}
//		try
//		{
//			
//			JSONArray jaray=new JSONArray();
//			System.out.println("hi");
//			masks data = Dao.queryData(1005);
//			System.out.println("hi1");
//			out.write(data.getHospitalName()+" "+data.getHopsitalAddress()+" "+data.getMaskOfAdult());
//			
//				System.out.println(jobj.toString());
//			}
//			out.write(jaray.toString());
//		session.getTransaction().commit();
//		}catch (Exception e){
//			session.getTransaction().rollback();
//			e.getStackTrace();
//			
//			
//		}
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
