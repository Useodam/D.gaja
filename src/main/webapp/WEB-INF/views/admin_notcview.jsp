<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Notc</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/adminnotc.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/loginlist.css'/>">
<%--    <link rel="stylesheet" href="<c:url value='/css/adminHeader.css'/>">--%>
    <link rel="stylesheet" href="<c:url value='/css/admin.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/css/sb-admin-2.min.css'/>" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href=<c:url value='/vendor/datatables/dataTables.bootstrap4.min.css'/>"" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="adminSideBar.jsp"/>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <jsp:include page="adminHeader.jsp"/>
            <!-- End of Topbar -->

            <script>
                let msg="${msg}";
                if(msg=="WRT_ERR") alert("공지사항 등록에 실패했습니다");
                if(msg=="MOD_READY") alert("수정하실 수 있습니다.")
            </script>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <h1 class="h3 mb-2 text-gray-800">게시판 관리</h1>

                <div class="col-lg-6">

                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항${mode=="new" ? "쓰기" : ""}</h6>
                        </div>
                        <div class="card-body">
                                <form action="" id="form">
                                    <input type="hidden" name="bbsoNo" value="${NotcDto.bbsoNo}" readonly="readonly">
                                    <input type="text" name="cate" value="${NotcDto.cate}" ${mode=="new" ? '' : 'readonly="readonly"'}>
                                    <h3>제목</h3>
                                    <input type="text" name="ttl" value="${NotcDto.ttl}" placeholder="제목을 입력하세요."${mode=="new" ? '' : 'readonly="readonly"'}>
                                    <h3>내용</h3>
                                    <textarea name="cn" cols="30" rows="10" placeholder="내용을 입력하세요." ${mode=="new" ? '' : 'readonly="readonly"'} >${NotcDto.cn}</textarea>

                                    <br>
                                    <div class="btnlist">
                                        <button type="button" id="modifyBtn" class="CSBtn">수정</button>
                                        <button type="button" id="removeBtn" class="CSBtn">삭제</button>
                                        <button type="button" id="listBtn" class="CSBtn">목록</button>
                                    </div>
                                </form> <%--    <form action="" id="form">--%>
                        </div>
                    </div>

                </div>

            </div>
        </div>
        <!-- /.container-fluid -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Main Content -->

</div>
<!-- End of Content Wrapper -->

<!-- End of Page Wrapper -->
<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">현재 세션을 종료하고 싶으시면 "로그아웃"을 눌러주세요.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                <a class="btn btn-primary" href="<c:url value='${loginOutLink}'/>">로그아웃</a>
            </div>
        </div>
    </div>
</div>

<%--자스 파일 분리함--%>
<script type="text/javascript" src="<c:url value='/js/prodRegister.js'/>"></script>
<!-- Bootstrap core JavaScript-->
<script src="<c:url value="vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="js/sb-admin-2.min.js"/>"></script>

<!-- Page level plugins -->
<script src="<c:url value="vendor/datatables/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url value="js/demo/datatables-demo.js"/>"></script>
<script>
    $(document).ready(function (){
        $('#listBtn').on("click",function (){
            location.href="<c:url value='/notc/adminlist${notcSearchCondition.queryString}'/>";
        });


        $('#removeBtn').on("click",function (){
            if(!confirm("삭제하시겠습니까?")) return;
            let form = $('#form');
            form.attr("action","<c:url value='/notc/adminremove${notcSearchCondition.queryString}'/>");
            form.attr("method","post");
            form.submit();
        });

        $('#writeBtn').on("click",function (){
            let form = $('#form');
            form.attr("action","<c:url value='/notc/adminwrite'/>");
            form.attr("method","post");
            form.submit();
        });

        $('#modifyBtn').on("click",function (){
            //  1. 읽기 상태이면 수정 상태로 변경
            let form = $('#form');
            let isReadonly = form.find("input[name='ttl']").attr("readonly");

            if (isReadonly=='readonly'){
                $("input[name=ttl]").attr("readonly",false);
                $("textarea").attr("readonly",false);
                $("modifyBtn").html("등록");
                $(".viewtitle").html("공지사항 수정");
                return;
            }
            //  2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action","<c:url value="/notc/adminmodify"/>");
            form.attr("method","post");
            form.submit();

        });
    });

</script>
</body>