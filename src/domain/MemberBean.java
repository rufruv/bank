package domain;

public class MemberBean {
protected String ssn, name, uid, password, profileImg, phone, email;
	
	public void setUid(String uid){
		this.uid = uid ;
	}
	public String getUid(){
		return uid ;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setSsn(String ssn){
		this.ssn = ssn ;
	}
	public String getSsn(){
		return ssn ; 
	}
	
	public void setName(String name){
		this.name = name ;
	}
	public String getName(){
		return name ;
	}
	
	public String calcGender(String ssn){
		char ch = ssn.charAt(7);
		String gender = "";
		if (ch == '1' || ch == '3') {
			gender = "남자";
		} else if (ch == '2' || ch == '4') {
			gender = "여자";
		} else {
			gender= "외국인";
		}
		return gender ; 
	}
	@Override
	public String toString() {
		return String.format("%s(%s)[ %s | **** | %s | %s | %s ]", name, ssn, uid, phone, email, profileImg);
	}
}