<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<body>
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->

				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">LIST ALL PAGE</h3>
					</div>
					<div class="box-body">
						<a href="createPage?page=${pageMaker.cri.page }"><button class="btn btn-primary">글쓰기</button></a>
						<table class="table table-bordered">
							<tr>
								<th style="width: 10px">BNO</th>
								<th>TITLE</th>
								<th>WRITER</th>
								<th>REGDATE</th>
								<th style="width: 40px">VIEWCNT</th>
							</tr>


							<c:forEach items="${boardList}" var="boardVO">

								<tr>
									<td>${boardVO.bno}</td>
									<td><a href='readPage?page=${pageMaker.cri.page }&?bno=${boardVO.bno}'>${boardVO.title}</a></td>
									<td>${boardVO.writer}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${boardVO.regdate}" /></td>
									<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
								</tr>

							</c:forEach>

						</table>

					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<div class="text-center">
							<ul class="pagination">
								<c:if test="${pageMaker.prev }">
									<li>
										<a href="listPage?page=${pageMaker.cri.page-1 }">&laquo;</a>
									</li>
								</c:if>
								<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
									<li <c:out value="${pageMaker.cri.page == idx ? 'class=active' : '' }" />>
										<a href="listPage?page=${idx }">${idx }</a>
									</li>
								</c:forEach>
								<c:if test="${pageMaker.next }">
									<li>
										<a href="listPage?page=${pageMaker.cri.page+1 }">&raquo;</a>
									</li>
								</c:if>
							</ul>
						</div>
					</div>
					<!-- /.box-footer-->
				</div>
			</div>
			<!--/.col (left) -->

		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

</body>











