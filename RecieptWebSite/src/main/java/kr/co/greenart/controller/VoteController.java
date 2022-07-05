package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.greenart.model.BoardVO;
import kr.co.greenart.model.Criteria;
import kr.co.greenart.model.PageDTO;
import kr.co.greenart.service.VoteService;

@Controller
@RequestMapping("/main/vote")
public class VoteController {
	private static Logger logger = LoggerFactory.getLogger(VoteController.class);

	@Autowired
	private VoteService vService;

	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	public String getList(Model model, Criteria criteria) {
		criteria.setCurrentPage(1);

		int total = vService.getTotal();

		PageDTO page = new PageDTO(criteria);
		page.setTotal(total);

		List<BoardVO> list = vService.getAll(criteria);
		model.addAttribute("list", list);

		model.addAttribute("paging", page);
		model.addAttribute("cri", criteria);
		return "board/voteList";
	}

	// 페이징
	@RequestMapping(value = "/list/{boardNo}", method = RequestMethod.GET)
	public String getListPage(Model model, Criteria criteria, @PathVariable("boardNo") int num) {
		criteria.setCurrentPage(num);

		int total = vService.getTotal();

		PageDTO page = new PageDTO(criteria);
		page.setTotal(total);

		List<BoardVO> list = vService.getAll(criteria);
		model.addAttribute("list", list);

		model.addAttribute("paging", page);
		model.addAttribute("cri", criteria);
		return "board/voteList";
	}

	// 유저로 검색
	@PostMapping("/search") // utf-8 
	public String search(@RequestParam("keyword") String keyword, @RequestParam("selectType") String type, Model model,
			Criteria criteria) {

		return "board/listByUsr";
	}

	@GetMapping("/write")
	public String writeView() {
		logger.info("writeView");
		return "board/writeView";

	}

	// 글 작성
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		logger.info("write");

		vService.write(boardVO);

		return "redirect:/main/vote/list/1";
	}

	// 글 내용 조회
	@GetMapping("/contentView/{boardNo}")
	public String contentView(@PathVariable("boardNo") int bno, Model model) {
		BoardVO board = vService.getContent(bno);

		model.addAttribute("board", board);
		return "board/contentView";
	}

	// 글 수정
	@GetMapping("/modify/{boardNo}")
	public String modifyContent(@PathVariable("boardNo") int bno, Model model) {
		BoardVO board = vService.getContent(bno);

		model.addAttribute("board", board);
		return "board/modifyView";
	}

	@PostMapping("/modify/{boardNo}")
	public String modifyContent(BoardVO boardVO) {
		vService.update(boardVO);
		return "redirect:/main/vote/contentView/" + boardVO.getBoardNo();
	}

	// 글 삭제
	@GetMapping("/delete/{boardNo}")
	public String delete(BoardVO boardVO, RedirectAttributes reatt) {
		vService.delete(boardVO);
		reatt.addFlashAttribute("result", "delete success");
		return "redirect:/main/vote/list/all";
	}
}
