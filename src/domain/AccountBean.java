package domain;

public class AccountBean {
	
	protected String uid, accountType, createDate, money, accountNo ;
	
	public void setUid(String uid) {
		this.uid = uid;
	}	
	public String getUid(){
		return uid;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountNo(){
		return accountNo;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountType(){
		return accountType;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMoney(){
		return money;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateDate(){
		return createDate;
	}
		
	@Override
	public String toString() {
		return String.format("%d [%s] %s %s %s", 
				accountNo, accountType, uid, createDate, money);
	}
	
}


