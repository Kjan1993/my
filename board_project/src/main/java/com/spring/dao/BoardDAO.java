package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.BoardVO;
import com.spring.dto.Criteria;

public interface BoardDAO {

	public List<BoardVO> selectBoardList() throws SQLException;
	public BoardVO selectBoardByID(int bno) throws SQLException;
	public void insertBoard(BoardVO board) throws SQLException;
	public void updateBoard(BoardVO board) throws SQLException;
	public void deleteBoard(int bno) throws SQLException;
	
	public void increaseViewcnt(int bno) throws SQLException;
	
	//paging method
	List<BoardVO> selectBoardCriteria(Criteria cri) throws SQLException;
	
	int totalCountBoard() throws SQLException; 
	
}
