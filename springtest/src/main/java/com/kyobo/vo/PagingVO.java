package com.kyobo.vo;

public class PagingVO {
	private int postsPerPage = 20;   // 한 페이지 당 표시할 글 개수
	private int displayPageNum = 10; // 한 번에 표시할 페이지 개수
	private int startPage ;      // 시작 페이지 번호
	private int currentPage;    // 현재 페이지 번호
	private int endPage;        // 끝 페이지 번호
	private int totalPosts;     // 총 글 개수(rownum) == boardCount
	private int totalPages;     // 모든 페이지 개수	
	
	private boolean next;       // 다음으로 가는 회살표 표시 여부
	private boolean prev;       // 이전으로 가는 화살표 표시 여부
	
	// startPage = ((currentPage - 1) / displayPageNum) * displayPageNum + 1
	// endPage = (((currentPage - 1) / displayPageNum) + 1) * displayPageNum
	// 			if(endPage > totalPages) {endPage = totalPages ;}
	// totalPages = ((totalPosts - 1) / postsPerPage) + 1
	// next = (endPage == totalPages) ? false:true
	// prev = (startPage == 1) ? false:true
	
	private String board_search;
	private String searchWord;
	
	public String getBoard_search() {
		return board_search;
	}
	public void setBoard_search(String board_search) {
		this.board_search = board_search;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	public int getPostsPerPage() {
		return postsPerPage;
	}
	public void setPostsPerPage(int postsPerPage) {
		this.postsPerPage = postsPerPage;
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
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPosts() {
		return totalPosts;
	}
	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
}

