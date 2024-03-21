int currentPage = 22 ;
int postsPerPage = 20 ;
int displayPageNum = 10 ;
int totalPosts = 255 ; // �̰� count�������� ��ȸ���� ��

int totalPage = totaleCount / postsPerPage ; // �Ϸ�

if (totalPosts % postsPerPage > 0) {
	totalPage++ ;
} // �Ϸ�

if (totalPage < currentPage) {
	currentPage = totalPage ;
}

int startPage = ((currentPage - 1) / displayPageNum) * displayPageNum + 1 ; // �Ϸ�
int endPage = startPage + displayPageNum - 1 ; // �Ϸ�

if (endPage > totalPage) {
	endPage = totalPage ;
}

if (startPage > 1) {
	System.out.print("<a href='?currentPage=1'>[ó�� ������]</a>") ;
}

if (currentPage > 1) {
	System.out.print("<a href='?currentPage=" + (currentPage - 1) + "'>[���� ������]</a>") ;
}

for (int i = startPage; i <= endPage; i++) {
	if (i == currentPage) {
		System.out.print(" <b>" + i + "</b> ") ;
	} else {
		System.out.print(" " + i + " ") ;
	}
}

if (currentPage < totalPage) {
	System.out.print("<a href='?currentPage=" + (currentPage + 1) + "'>[���� ������]</a>") ;
}

if (endPage < totalPage) {
	System.out.print("<a href='?currentPage=" + totalPage + "'>[������ ������]</a>") ;
}