package dto;

public class Kadai {
	private String name;
	private int age;
	private String gender;
	private String tel;
	private String mail;
	private String salt;
	private String pw;
	private String hashedPw;
	public Kadai(String name, int age, String gender, String tel, String mail, String salt, String pw,
			String hashedPw) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.mail = mail;
		this.salt = salt;
		this.pw = pw;
		this.hashedPw = hashedPw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getHashedPw() {
		return hashedPw;
	}
	public void setHashedPw(String hashedPw) {
		this.hashedPw = hashedPw;
	}
	
}
