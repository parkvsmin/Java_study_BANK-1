package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.bankMembers.BankMembersDAO;
import com.iu.start.bankMembers.BankMembersDTO;

public class BankMembersTest {

	public static void main(String[] args) {
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername("ID");
//		bankMembersDTO.setPassword("PW");
//		bankMembersDTO.setName("NAME");
//		bankMembersDTO.setEmail("EMAIL");
//		bankMembersDTO.setPhone("0101111111");
		try {
//			int result =bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result == 1);
			ArrayList<BankMembersDTO> ar =bankMembersDAO.getSearchByID("Z");
			System.out.println(ar.size()>0);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
