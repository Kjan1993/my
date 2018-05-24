package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.dto.BoardVO;
import com.spring.dto.Criteria;

public class BoardDAOImpl implements BoardDAO {

	private SqlSession session; // Mapper를 조종

	public void setSession(SqlSession session) {
		this.session = session;
	}

	// private List<BoardVO> boardList = new ArrayList<BoardVO>();
	// private static final String NAMESPACE = "BoardMapper";

	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		List<BoardVO> boardList = session.selectList("BoardMapper.selectBoardList", null);
		return boardList;
	}

	@Override
	public BoardVO selectBoardByID(int bno) throws SQLException {
		BoardVO board = (BoardVO) session.selectOne("BoardMapper.selectBoardByID", bno);
		return board;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		session.update("BoardMapper.insertBoard", board);
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		session.update("BoardMapper.updateBoard", board);
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		session.update("BoardMapper.deleteBoard", bno);
	}

	@Override
	public void increaseViewcnt(int bno) throws SQLException {
		session.update("BoardMapper.increaseViewcnt",bno);
		
	}

	@Override
	public List<BoardVO> selectBoardCriteria(Criteria cri) throws SQLException {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new  RowBounds(offset,limit);
		
		
		List<BoardVO> boardList = session.selectList("BoardMapper.selectBoardList",null,rowBounds);
		return boardList;
	}

	@Override
	public int totalCountBoard() throws SQLException {
		int totalCount = (Integer) session.selectOne("BoardMapper.totalCountBoard", null);
		
		return totalCount;
	}

}
