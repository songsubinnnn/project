package kr.co.greenart.repository;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.greenart.model.BoardVO;
import kr.co.greenart.model.Criteria;

@Repository
public class VoteRepository implements IVoteRepository {
	// DB와 연결하는 repository

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BoardVO> getAll(Criteria criteria) {
		return jdbcTemplate.query("select board_no, title, content, writer, regdate, viewcnt "
				+ "from voteboard order by board_no desc limit ?,?"
				,new RowMapper<BoardVO>() {

					@Override
					public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						int boardNo = rs.getInt("board_no");
						String title = rs.getString("title");
						String content = rs.getString("content");
						String writer = rs.getString("writer");
						Date date = rs.getDate("regdate");
						int viewcnt = rs.getInt("viewcnt");
						BoardVO boardVO = new BoardVO(boardNo, title, content, writer, date, viewcnt);
						return boardVO;
					}
				},criteria.getOffset(),criteria.getPerPage());
	}
	
	

	@Override
	public int update(BoardVO board) {
		return jdbcTemplate.update("update voteboard set title = ?, content = ?, writer = ? where board_no = ?",
				board.getTitle(),board.getContent(),board.getWriter(),board.getBoardNo());
	}

	@Override
	public int delete(BoardVO board) {
		return jdbcTemplate.update("delete from voteboard where board_no = ?", board.getBoardNo());
	}

// 글 작성 
	@Override
	public int write(BoardVO board) {
		return jdbcTemplate.update("insert into voteboard(title,content,writer) values (?,?,?)", board.getTitle(),
				board.getContent(), board.getWriter());
	}

	@Override
	public List<BoardVO> searchByUsr(String writer,Criteria criteria) {
		return jdbcTemplate.query("select * from voteboard where writer = ? order by board_no desc limit ?,?",
				new RowMapper<BoardVO>() {

					@Override
					public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						int boardNo = rs.getInt("board_no");
						String title = rs.getString("title");
						String content = rs.getString("content");
						String writer = rs.getString("writer");
						Date date = rs.getDate("regdate");
						int viewcnt = rs.getInt("viewcnt");
						BoardVO boardVO = new BoardVO(boardNo, title, content, writer, date, viewcnt);
						return boardVO;
					}
				},writer,criteria.getOffset(),criteria.getPerPage());
	}
	
	@Override
	public List<BoardVO> searchByTitle(String title, Criteria criteria) {
		return jdbcTemplate.query("select * from voteboard where title like concat('%',?,'%') order by board_no desc limit ?,?",
				new RowMapper<BoardVO>() {

					@Override
					public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						int boardNo = rs.getInt("board_no");
						String title = rs.getString("title");
						String content = rs.getString("content");
						String writer = rs.getString("writer");
						Date date = rs.getDate("regdate");
						int viewcnt = rs.getInt("viewcnt");
						BoardVO boardVO = new BoardVO(boardNo, title, content, writer, date, viewcnt);
						return boardVO;
					}
				},title,criteria.getOffset(),criteria.getPerPage());
	}

	@Override
	public BoardVO getContent(int bno) {
		String sql = "select board_no, title, content, writer, regdate, viewcnt from voteboard where board_no = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				int boardNo = rs.getInt("board_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date date = rs.getDate("regdate");
				int viewcnt = rs.getInt("viewcnt");
				BoardVO boardVO = new BoardVO(boardNo, title, content, writer, date, viewcnt);
				return boardVO;
			}
		}, bno);
				
	}

	@Override
	public int getTotal() {
		return jdbcTemplate.queryForObject("select count(board_no) from voteboard",int.class);
	}

}
