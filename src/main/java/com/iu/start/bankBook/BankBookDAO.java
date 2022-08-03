package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO {

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		BankBookDTO banBookDTO2=null;
		
		Connection con = DBConnector.getConnection();
		
		String sql ="SELECT * FROM BANKBOOK WHERE BOOKNUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDTO.getBookNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			banBookDTO2 = new BankBookDTO();
			banBookDTO2.setBookNum(rs.getLong("BOOKNUM"));
			banBookDTO2.setBookName(rs.getString("BOOKNAME"));
			banBookDTO2.setBookRate(rs.getDouble("BOOKRATE"));
			banBookDTO2.setBookSale(rs.getInt("BOOKSALE"));
		}
		
		
		DBConnector.disConnect(rs, st, con);
		
		
		return banBookDTO2;
	}

}
