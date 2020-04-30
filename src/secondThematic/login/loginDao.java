package secondThematic.login;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class loginDao {
	private Session session;

	public loginDao(Session session) {
		this.session = session;
	}
	public loginDao() {
		
	}

	public boolean checkLogin(String name, String pwd) {
		System.out.println("hi");
		Query<loginBean> query = session.createQuery("from loginBean where userAccount='" +name+"' and userpassword='"+pwd+"'", loginBean.class);
		System.out.println("hi1");
		List<loginBean> list = query.list();
		System.out.println(list.size());
		if (list.size()!=1) {
			return false;
		}
		return true;
	}
	public boolean checkAccount(String name) {
		System.out.println("hi");
		Query<loginBean> query = session.createQuery("from loginBean where userAccount='" +name+"'", loginBean.class);
		System.out.println("hi1");
		List<loginBean> list = query.list();
		System.out.println(list.size());
		if (list.size()!=1) {
			return false;
		}
		return true;
	}
	public void accountadd(String useraccount,String userPassword,String userBirthday,String userAddress,String useremail,String username,int gender) {
		loginBean lbean=new loginBean( useraccount, userPassword, userBirthday, userAddress, useremail, username, gender);
		session.save(lbean);
		
	}
	@SuppressWarnings("rawtypes")
	public void accountedit(int id,String useraccount,String userPassword,String userBirthday,String userAddress,String useremail,String username,int gender) {
		loginBean lbean=new loginBean();
		lbean.setUserId(id);
		Query query = session.createQuery("update from loginBean set userpassword=:password, userAddress=:address where userId=:id");
		query.setParameter("password", userPassword);
		query.setParameter("address", userAddress);
		query.setParameter("id", id);
		query.executeUpdate();
		
		
	}
	public List<loginBean> editAccount(String name) {
		System.out.println("hi");
		Query<loginBean> query = session.createQuery("from loginBean where userAccount='" +name+"'", loginBean.class);
		System.out.println("hi1");
		List<loginBean> list = query.list();
		System.out.println(list.size());
		return list;
	}
}
