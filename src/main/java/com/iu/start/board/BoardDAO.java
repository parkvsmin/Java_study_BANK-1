package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.board.BoardDTO;
import com.iu.start.util.DBConnector;

public class BoardDAO {

	public ArrayList<BoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "SELECT * FROM BOARD";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong("BD_NUM"));
			boardDTO.setTitle(rs.getString("BD_TITLE"));
			boardDTO.setContent(rs.getString("BD_CONTENTS"));
			boardDTO.setWriter(rs.getString("BD_WRITER"));
			boardDTO.setBoardDate((rs.getDate("BD_DATE")));
			boardDTO.setHit(rs.getLong("BD_HIT"));


			ar.add(boardDTO);
		}
		DBConnector.disConnection(rs, st, con);

		return ar;
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD WHERE BD_NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setLong(1, boardDTO.getNum());
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			boardDTO.setNum(rs.getLong("BD_NUM"));
			boardDTO.setTitle(rs.getString("BD_TITLE"));
			boardDTO.setContent(rs.getString("BD_CONTENTS"));
			boardDTO.setWriter(rs.getString("BD_WRITER"));
			boardDTO.setBoardDate((rs.getDate("BD_DATE")));
			boardDTO.setHit(rs.getLong("BD_HIT"));


		}
		DBConnector.disConnection(rs, st, con);

		return boardDTO;
	}

	public int add(BoardDTO boardDTO)throws Exception {
		Connection con = DBConnector.getConnection();
		String sql ="";
		PreparedStatement st = con.prepareStatement(sql);
		//st.setString(1,boardDTO);
		//st.setLong(3, boardDTO);
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);

		return result;

	}

	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContent());
		st.setLong(3, boardDTO.getNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);

		return result;
	}

	public int setDelete(BoardDTO boardDTO) throws Exception {	
		Connection con = DBConnector.getConnection();
		String sql ="DELETE BOARD WHERE NO = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, boardDTO.getNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);

		return result;

	}

}
