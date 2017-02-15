package serviceImpl;

import domain.MemberBean;
import service.AdminService2;

public class AdminServiceImpl2 implements AdminService2{
	private int count;
	private MemberBean[] arr;
	
	public AdminServiceImpl2() {
		count = 0;
		arr = new MemberBean[count]; // 주소값만 있는 상태&객체를 담을수는 없는 상태(null)
		}
	@Override
	public void regist(MemberBean member) {
		// 회원정보를 입력한 후 배열에 저장하기
		if(count == arr.length){
			MemberBean[] temp = new MemberBean[count+10];
			/*System.arraycopy(arr, 0, temp, 0, count);*/
			for(int i=0; i<count; i++){
				temp[i] = arr[i];
			}
			arr = temp;
		}
		arr[count]=member;
		count++;
		/*arr[count++]=member;*/
	}
	@Override
	public MemberBean findById(String keyword) {
		MemberBean member = new MemberBean();
		for(int i=0; i<count; i++){
			if(keyword.equals(arr[i].getId())){
				member = arr[i];
				break;
			}
		}
		return member;
	}
	@Override
	public MemberBean[] findByName(String name) {
		MemberBean[] list = new MemberBean[countByName(name)];
		for(int i=0; i<count; i++){
			if(name.equals(arr[i].getName())){
				list[i] = arr[i];
			}
		}
		return list;
	}
	@Override
	public int countByName(String name) {
		int nameCount = 0;
		for(int i=0; i<count; i++){
			if(name.equals(arr[i].getName())){
				nameCount++;
			}
		}
		return nameCount;
	}
	
	@Override
	public MemberBean[] list() {
		return arr;
	}
	@Override
	public int count() {
		return count;
	}
	@Override
	public void changeRank(MemberBean member) {
		for(int i=0;i<count;i++){
			if(member.getId().equals(arr[i].getId())){
				arr[i].setRank(member.getRank());
				break;
			}
		}
		
	}
	@Override
	public void remove(String id) {
		for(int i=0;i<count;i++){
			if(id.equals(arr[i].getId())){
				arr[i] = arr[count-1];
				arr[count-1] = null;
				count--;
				break;
			}
		}
	}
	@Override
	public boolean exist(String keyword) { //boolean을 줬다는건 어디의 컨디션에 들어가라는 얘기
		boolean check = false;
		for(int i=0; i<count; i++){
			if(keyword.equals(arr[i].getId())){
				check = true;
				
			}
		}
		return check;
	}
}
