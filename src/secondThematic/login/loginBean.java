package secondThematic.login;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class loginBean {

	private int userId;
	private String useraccount;
	private String userPassword;
	private String userBirthday;
	private String userAddress;
	private String useremail;
	private String username;
	private Blob userphoto;
	private int gender;
	public loginBean() {}
	public loginBean(String useraccount,String userPassword,String userBirthday,String userAddress,String useremail,String username,int gender) 
	{
		this.useraccount = useraccount;
		this.useremail = useremail;
		this.username = username;
		this.userPassword = userPassword;
		this.userBirthday = userBirthday;
		this.userAddress = userAddress;
		this.gender = gender;
		
	}
	
	@Id
	@Column(name="userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserId() {	
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="UserAccount")
	public String getUserAccount() {
		return useraccount;
	}
	public void setUserAccount(String useraccount) {
		this.useraccount = useraccount;
	}
	@Column(name="userpassword")
	public String getUserPassword() {
		return userPassword;
	}
	@Column(name="userEmail")
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	@Column(name="userName")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Column(name="userBirthday")
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	@Column(name="userAddress")
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Column(name="userGender")
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	@Column(name="userPhoto")
	public Blob getUserphoto() {
		return userphoto;
	}
	public void setUserphoto(Blob userphoto) {
		this.userphoto = userphoto;
	}
	

}
