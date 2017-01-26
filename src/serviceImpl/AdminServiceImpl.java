package serviceImpl;

import domain.MemberBean;
import service.AdminService;

public class AdminServiceImpl implements AdminService{
	private MemberBean member; //getter&setter 만들지 여부는 선택사항 
	private MemberBean[] arr;
	private int count;
	
	public AdminServiceImpl() {
		member = new MemberBean();
		arr = new MemberBean[count];
		count = 0;
	}
	@Override
	public void regist(MemberBean member) {
		// 회원정보를 입력한 후 배열에 저장하기
		if(count == arr.length){
			MemberBean[] temp = new MemberBean[count+10];
			System.arraycopy(arr, 0, temp, 0, count);
			/*for(int i=0; i<count; i++){
				temp[i] = arr[i];
			}*/
			arr = temp;
		}
		arr[count]=member;
		count++;
	}
	@Override
	public MemberBean findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean[] findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public MemberBean[] list() {
		// 전체목록 출력 
		/*if(arr.length==0){
			member.setName("회원이 존재하지 않습니다.");
			arr = new MemberBean[1];
			arr[0] = member;
		}*/
		return arr;
	}
	@Override
	public int count() {
		return count;
	}
	@Override
	public void changeRank(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
}
