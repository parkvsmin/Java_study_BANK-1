package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.start.util.DBConnector;

public class BankAccountDAO {
	
	public int add(BankAccountDTO bankAccountDTO)throws Exception {
		//1. db 연결
		Connection con = DBConnector.getConnection();
		//2. sql문 작성
		String sql ="INSERT INTO BANKACCOUNT"+" VALUES(ACCOUNT_SEQ.NEXTVAL,?, ?, SYSDATE)";
		//3. 미리보내기
		PreparedStatement st = con.prepareStatement(sql);
		//4. ?세팅
		st.setString(1,bankAccountDTO.getUserName());
		st.setLong(2, bankAccountDTO.getBookNum());
		//5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		//6. 연결해제
		DBConnector.disConnection(st, con);
		
		return result;
		
	}

}
