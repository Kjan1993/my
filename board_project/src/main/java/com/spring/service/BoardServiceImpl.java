package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardVO;
import com.spring.dto.Criteria;

public class BoardServiceImpl implements BoardService{

	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO){
		this.boardDAO=boardDAO;
	}
	
	@Override
	public List<BoardVO> getBoardList() throws SQLException {
		List<BoardVO> boardList = boardDAO.selectBoardList();

		return boardList;
	}

	@Override
	public BoardVO getBoardByBNO(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByID(bno);
		return board;
	}

	@Override
	public void create(BoardVO board) throws SQLException {
		boardDAO.insertBoard(board);
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
	}

	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
	}

	@Override
	public BoardVO read(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByID(bno);
		boardDAO.increaseViewcnt(bno);
		return board;
	}

	@Override
	public List<BoardVO> getListCriteria(Criteria cri) throws SQLException {
		List<BoardVO> boardList = boardDAO.selectBoardCriteria(cri);
		return boardList;
	}

}
