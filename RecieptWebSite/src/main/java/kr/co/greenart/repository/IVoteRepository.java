package kr.co.greenart.repository;

import java.util.List;

import kr.co.greenart.model.BoardVO;
import kr.co.greenart.model.Criteria;

public interface IVoteRepository {
	// 목록보기
	List<BoardVO> getAll(Criteria criteria);
	// 글 수정
	int update(BoardVO board);
	// 글 삭제
	int delete(BoardVO board);
	// 글 작성(추가)
	int write(BoardVO board);
	// 글 조회(작성자)
	List<BoardVO> searchByUsr(String writer, Criteria criteria);
	// 글 조회(내용)
	List<BoardVO> searchByTitle(String title, Criteria criteria);
	// 글 내용 조회
	BoardVO getContent(int bno);
	// 총 개수 
	int getTotal();
	
	

	
}
