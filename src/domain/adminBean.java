package domain;

public class adminBean extends MemberBean{
	private String permission;
	
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getPermission() {
		return permission;
	}
	@Override
	public String toString() {
		return String.format("%s(%s)[ %s | **** | %s | %s | 관리자 ]", 
				             name, ssn, uid, phone, email);
	}
}
