package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO {

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		Calendar ca = Calendar.getInstance();	
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKBOOK VALUES (?, ?, ?, 1)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, ca.getTimeInMillis());
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		
		return result;
	}

	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			
			ar.add(bankBookDTO);
		}
		DBConnector.disConnection(rs, st, con);
		
		return ar;
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		int sale=0;
		Connection con = DBConnector.getConnection();
		String sql2 = "SELECT BOOKSALE FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st2 = con.prepareStatement(sql2);
		st2.setLong(1, bankBookDTO.getBookNum());
		ResultSet rs = st2.executeQuery();
		if(rs.next()) {
			sale = rs.getInt("BOOKSALE");
		}
		rs.close();
		st2.close();
		
		if(sale == 1) {
			sale = 0;
		} else sale=1;
		
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, sale);
		st.setLong(2, bankBookDTO.getBookNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setLong(1, bankBookDTO.getBookNum());
		ResultSet rs = st.executeQuery();
		
		//BankBookDTO bankBookDTO = new BankBookDTO();
		if(rs.next()) {
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
		}
		return bankBookDTO;
	}

}