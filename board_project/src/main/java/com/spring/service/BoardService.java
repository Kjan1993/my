package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.BoardVO;
import com.spring.dto.Criteria;

public interface BoardService {
	List<BoardVO> getBoardList() throws SQLException;
	BoardVO getBoardByBNO(int bno) throws SQLException;
	
	BoardVO read(int bno) throws SQLException;
	
	void create(BoardVO board)throws SQLException;
	void modify(BoardVO board)throws SQLException;
	void remove(int bno)throws SQLException;
	
	//paging
	List<BoardVO> getListCriteria(Criteria cri) throws SQLException;
	
	
}
