package kr.co.greenart.model;


public class Criteria {
	private int currentPage; // 현재 페이지
	private int perPage = 6; // 페이지당 출력 데이터 개수 (6)
	private int offset; // offset할 글 개수 p1=0 p2=6 p3=12
	private int rowStart;
	private int rowEnd;
	
	
	public int getOffset() {
		return offset = ((currentPage - 1) * perPage); //display post
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getRowStart() {
		rowStart = ((currentPage - 1) * perPage)+1;
		return rowStart;
	}

	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	public int getRowEnd() {
		rowEnd = rowStart + perPage - 1;
		return rowEnd;
	}

	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}

	public Criteria() {
		this.currentPage = 1;
		this.perPage = 6;
//		this.offset = 0;
	}

//	public Criteria(int currentPage, int perPage) {
//		this.currentPage = currentPage;
//		this.perPage = perPage;
//		this.offset = (currentPage - 1) * perPage;
//	}

//	public int getOffset() {
//		return offset;
//	}
//
//	public void setOffset(int offset) {
//		this.offset = offset;
//	}

	public int getCurrentPage() {

		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
//		this.offset = (currentPage - 1) * this.perPage;
		if ( currentPage <= 0) {
			this.currentPage = 1;
			return;
		}
		this.currentPage = currentPage;
		
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
//		this.offset = (this.currentPage - 1) * perPage;
		if(perPage <= 0) {
			this.perPage = 6;
		}
		this.perPage = perPage;
	}

	@Override
	public String toString() {
		return "Criteria [currentPage=" + currentPage + ", perPage=" + perPage + ", offset=" + offset + "]";
	}

}
