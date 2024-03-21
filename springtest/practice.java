int currentPage = 22 ;
int postsPerPage = 20 ;
int displayPageNum = 10 ;
int totalPosts = 255 ; // 이건 count쿼리에서 조회해줄 것

int totalPage = totaleCount / postsPerPage ; // 완료

if (totalPosts % postsPerPage > 0) {
	totalPage++ ;
} // 완료

if (totalPage < currentPage) {
	currentPage = totalPage ;
}

int startPage = ((currentPage - 1) / displayPageNum) * displayPageNum + 1 ; // 완료
int endPage = startPage + displayPageNum - 1 ; // 완료

if (endPage > totalPage) {
	endPage = totalPage ;
}

if (startPage > 1) {
	System.out.print("<a href='?currentPage=1'>[처음 페이지]</a>") ;
}

if (currentPage > 1) {
	System.out.print("<a href='?currentPage=" + (currentPage - 1) + "'>[이전 페이지]</a>") ;
}

for (int i = startPage; i <= endPage; i++) {
	if (i == currentPage) {
		System.out.print(" <b>" + i + "</b> ") ;
	} else {
		System.out.print(" " + i + " ") ;
	}
}

if (currentPage < totalPage) {
	System.out.print("<a href='?currentPage=" + (currentPage + 1) + "'>[다음 페이지]</a>") ;
}

if (endPage < totalPage) {
	System.out.print("<a href='?currentPage=" + totalPage + "'>[마지막 페이지]</a>") ;
}