package com.iu.start.bankMembers;

import java.util.ArrayList;

public interface MembersDAO {
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception;
	
	//검색어를 입력해서 ID를 찾기 abc 순으로
	public ArrayList<BankMembersDTO> getSearchByID(String search)throws Exception;
	

}
