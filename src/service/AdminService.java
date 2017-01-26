package service;

import domain.MemberBean;

public interface AdminService {
	/**
	 * CREATE: INSERT 
	 */
	public void regist(MemberBean member);
	/**
	 * READ: SELECT
	 */
	public MemberBean findById(String id);
	public MemberBean[] findByName(String name);
	public int countByName(String name);
	public MemberBean[] list();
	public int count();
	/**
	 * UPDATE: UPDATE
	 */
	public void changeRank(MemberBean member);
	/**
	 * DELETE: DELETE
	 */
	public void remove(MemberBean member);
}

