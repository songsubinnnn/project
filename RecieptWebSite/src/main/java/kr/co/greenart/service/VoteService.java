package kr.co.greenart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.greenart.model.BoardVO;
import kr.co.greenart.model.Criteria;
import kr.co.greenart.repository.VoteRepository;
@Service
public class VoteService implements IVoteService {
	@Autowired
	private VoteRepository voteRepo;

	@Override
	public List<BoardVO> getAll(Criteria criteria) {
		return voteRepo.getAll(criteria);
	}

	@Override
	public int update(BoardVO board) {
		return voteRepo.update(board);
	}

	@Override
	public int delete(BoardVO board) {
		return voteRepo.delete(board);
	}

	@Override
	public int write(BoardVO board) {
		return voteRepo.write(board);
	}

	@Override
	public List<BoardVO> searchByUsr(String writer, Criteria criteria) {
		return voteRepo.searchByUsr(writer, criteria);
	}
	@Override
	public List<BoardVO> searchByTitle(String title, Criteria criteria) {
		return voteRepo.searchByTitle(title, criteria);
	}
	

	@Override
	public BoardVO getContent(int bno) {
		return voteRepo.getContent(bno);
	}

	@Override
	public int getTotal() {
		return voteRepo.getTotal();
	}

}
