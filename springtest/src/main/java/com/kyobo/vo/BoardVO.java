package com.kyobo.vo;

public class BoardVO {
	private int boardId;
	private String userNickname;
	private String postDate;
	private String postTitle;
	private String postContent;
	private String id;
	
	private String board_search;
	private String searchWord;
	private int cnt;
	
	////////////////////////////////////////////
	private int postsPerPage = 20;   // countList, �� ������ �� ǥ���� �� ����
	private int displayPageNum = 10; // countpage, �� ���� ǥ���� ������ ����
	private int startPage ;      // ���� ������ ��ȣ
	private int currentPage;    // page, ���� ������ ��ȣ
	private int endPage;        // �� ������ ��ȣ
	private int totalPosts;     // �� �� ����(rownum) == totalPosts
	private int totalPages;     // ��� ������ ����	
	
	private boolean next;       // �������� ���� ȸ��ǥ ǥ�� ����
	private boolean prev;       // �������� ���� ȭ��ǥ ǥ�� ����
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
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
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
