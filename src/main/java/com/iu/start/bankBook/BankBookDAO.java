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
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();

		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankBookDTO dto = new BankBookDTO();
			dto.setBookNum(rs.getLong(1));
			dto.setBookName(rs.getString(2)); 
			dto.setBookRate(rs.getDouble(3)); 
			dto.setBookSale(rs.getInt(4)); 
			ar.add(dto);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
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
