package kr.co.greenart.model;


public class PageDTO {
	private int startPage; // 시작 페이지
	private int endPage; // 마지막 페이지
	private int total; // 전체 페이지 수
	private boolean prev, next; // 이전, 다음 유무
	private Criteria criteria; // 현재 페이지에 대한 정보
	private int displayPageNum = 5;// 디스플레이 페이지 개수 

//	public PageDTO(Criteria criteria, int total) {
//		this.criteria = criteria;
//		this.total = total;
//
//		this.endPage = (int) (Math.ceil(criteria.getCurrentPage() / 5.0)) * 5; // 현재 보이는 마지막 페이지
//		this.startPage = this.endPage - 4; // 마지막 페이지 구하고 시작 페이지 구함.
//		int realEndPage = (int) (Math.ceil(total * 1.0 / criteria.getPerPage()));
//
//		if (realEndPage < this.endPage) {
//			this.endPage = realEndPage;
//		}
//
//		this.prev = this.startPage > 1;
//		this.next = this.endPage < realEndPage;
//
//	}
	public PageDTO(Criteria criteria) {
		this.criteria = criteria;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		calData();
	}

	private void calData() {
		endPage = (int) (Math.ceil((double)criteria.getCurrentPage() / (double)displayPageNum) * displayPageNum) ; // 현재 보이는 마지막 페이지
		startPage = endPage - (displayPageNum - 1); // 마지막 페이지 구하고 시작 페이지 구함.
		int realEndPage = (int) (Math.ceil((double)total  / (double)criteria.getPerPage()));

		if (endPage > realEndPage) {
			endPage = realEndPage;
		}

		prev = startPage == 1 ? false : true;
//		next = endPage * displayPageNum >= total ? false : true;
		next = endPage < realEndPage ? true :false;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", total=" + total + ", prev=" + prev
				+ ", next=" + next + ", criteria=" + criteria + "]";
	}



}
