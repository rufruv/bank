package controller;

import javax.swing.JOptionPane;

/*import domain.AccountBean;*/
import domain.MemberBean;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	
	public void start(){
		MemberBean member = null;  
		AdminService service = new AdminServiceImpl(); // 다형성 (부모타입 참조변수로 자식타입의 인스턴스 생성)
		int i = 0;
		
		while(true){
			switch(JOptionPane.showInputDialog("0.종료 1.회원등록 2.ID검색 3.이름검색 "
											 + "4.목록조회  5.등급조정 6.삭제")){
			case "0": return;
			case "1": 
				member = new MemberBean(); 
				String[] strArr = JOptionPane.showInputDialog("이름,ID").split(",");
				member.setName(strArr[0]);
				member.setUid(strArr[1]);
				service.regist(member);
				JOptionPane.showMessageDialog(null, "현재회원수는"+ service.count()+"입니다");
				// 현재회원수는 3명입니다. 
				break;
			case "2": 
				
				break;
			case "3":
				
				break;
			case "4": 
				if(service.count()==0){
					JOptionPane.showMessageDialog(null, "회원이 존재하지 않습니다");
				}else{
					MemberBean[] arr = service.list();
					String result = "";
					for(;i<service.count(); i++){
						result+=arr[i].toString()+"\n";
					}
					JOptionPane.showMessageDialog(null, result);
				}
				break;
			case "5": 
				
				break;
			case "6": 
				
				break;
			}
		}
	}
}
