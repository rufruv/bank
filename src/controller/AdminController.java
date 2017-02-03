package controller;

import javax.swing.JOptionPane;
import enums.Butt;
import domain.MemberBean;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	
	public void start(){
		MemberBean member = null;  
		AdminService service = new AdminServiceImpl(); // 다형성 (부모타입 참조변수로 자식타입의 인스턴스 생성)
		int i = 0;
		Butt[] buttons = {Butt.CLOSE,Butt.MEM_ADD,Butt.FIND_BY_ID,
						  Butt.FIND_BY_NAME,Butt.LIST,Butt.RANK,Butt.DELETE};
		while(true){
		Butt select = (Butt)JOptionPane.showInputDialog(
				null, // frame
				"PATIENT PAGE",  // frame title
				"SELECT PATIENT MENU",  // order
				JOptionPane.QUESTION_MESSAGE,  // type
				null,  // icon
				buttons, // Array of choice
				buttons[1] // default
				);
				
			switch(select){
			case CLOSE: return;
			case MEM_ADD: 
				member = new MemberBean(); 
				String[] strArr = JOptionPane.showInputDialog("이름,ID").split(",");
				member.setName(strArr[0]);
				member.setUid(strArr[1]);
				service.regist(member);
				JOptionPane.showMessageDialog(null, "현재회원수는"+ service.count()+"입니다");
				// 현재회원수는 3명입니다. 
				break;
			case FIND_BY_ID: 
				String keyword = JOptionPane.showInputDialog("ID?");
				if(service.exist(keyword)){
					JOptionPane.showMessageDialog(null, service.findById(keyword).toString());
				}else{
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다!!");
				}
				break;
			case FIND_BY_NAME:
				String temp = JOptionPane.showInputDialog("이름?");
				if(service.countByName(temp)!=0){
					MemberBean[] list = service.findByName(temp);
					String tempArr="";
					for(i=0;i<list.length ; i++ ){
						tempArr+=list[i].toString()+"\n";
					}
					JOptionPane.showMessageDialog(null, tempArr);
				}else{
					JOptionPane.showMessageDialog(null, "해당하는 정보가 없습니다.");
				}
				break;
			case LIST: 
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
			case RANK: 
				String temp2 = JOptionPane.showInputDialog("ID, RANK?");
				String[] tempArr = temp2.split(",");
				member.setUid(tempArr[0]);
				member.setRank(tempArr[1]);
				service.changeRank(member);
				break;
			case DELETE: 
				String del = JOptionPane.showInputDialog("ID?");
				if(service.exist(del)){
					service.remove(del);
					JOptionPane.showMessageDialog(null, "탈퇴처리완료!.");
				}else{
					JOptionPane.showMessageDialog(null, "없는 아이디입니다.");
				}
				/*member.setUid(JOptionPane.showInputDialog("ID"));
				service.remove(id);*/
				break;
			}
		}
	}
}