package controller;

import javax.swing.JOptionPane;

import domain.MemberBean;
import service.AdminService2;
import serviceImpl.AdminServiceImpl2;

public class AdminController2 {
	
	public void start(){
		MemberBean member = null;  
		AdminService2 service = new AdminServiceImpl2(); // 다형성 (부모타입 참조변수로 자식타입의 인스턴스 생성)
		int i = 0;
		
		while(true){
			switch(JOptionPane.showInputDialog("0.종료 1.회원등록 2.ID검색 3.이름검색 "
											 + "4.목록조회  5.등급조정 6.삭제")){
			case "0": return;
			case "1": 
				member = new MemberBean(); 
				String[] strArr = JOptionPane.showInputDialog("이름,ID").split(",");
				member.setName(strArr[0]);
				member.setId(strArr[1]);
				service.regist(member);
				JOptionPane.showMessageDialog(null, "현재회원수는"+ service.count()+"입니다");
				// 현재회원수는 3명입니다. 
				break;
			case "2": 
				String keyword = JOptionPane.showInputDialog("ID?");
				if(service.exist(keyword)){
					JOptionPane.showMessageDialog(null, service.findById(keyword).toString());
				}else{
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다!!");
				}
				break;
			case "3":
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
				String temp2 = JOptionPane.showInputDialog("ID, RANK?");
				String[] tempArr = temp2.split(",");
				member.setId(tempArr[0]);
				member.setRank(tempArr[1]);
				service.changeRank(member);
				break;
			case "6": 
				String del = JOptionPane.showInputDialog("ID?");
				if(service.exist(del)){
					service.remove(del);
					JOptionPane.showMessageDialog(null, "탈퇴처리완료!.");
				}else{
					JOptionPane.showMessageDialog(null, "없는 아이디입니다.");
				}
				member.setId(JOptionPane.showInputDialog("ID"));
				service.remove(del);
				break;
			}
		}
	}
}
