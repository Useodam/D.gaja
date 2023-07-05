<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>
<c:set var="addAndModify" value="${loginId=='' ? '/register/add' : '/register/modify'}"/>
<c:set var="register" value="${loginId=='' ? '회원가입' : '정보수정'}"/>
<html>
<head>
    <title>마이페이지</title>
    <link rel="stylesheet" href="<c:url value='/css/myPage.css'/>">
</head>
<body>
<!-- 전체 div -->
<div id="" class="content">
    <!-- 그다음 div -->
    <div id="" class="left-content">
        <!-- 왼쪽에 붙일 div -->
        <div class="left-content2">
            <!-- 왼쪽 위에 고정할 div -->
            <h3>마이페이지 </h3>
            <ul id="item-list-1" class="item-list">
                <li class="item"><a href="">주문내역조회</a></li>
                <li class="item"><a href="">관심상품</a></li>
                <li class="item"><a href="">최근본상품</a></li>
                <li class="item"><a href="">좋아요 상품</a></li>
            </ul>
        </div>
        <!-- 왼쪽 아래에 고정할 div -->
        <div class="">
            <ul id="item-list-2" class="item-list">
                <li class="item"><a href="<c:url value='/modifyInfo'/>">회원정보수정</a></li>
                <li class="item"><a href="">쿠폰 조회 및 등록</a></li>
                <li class="item"><a href="">포인트 조회</a></li>
                <li class="item"><a href="">게시물 관리</a></li>
                <li class="item"><a href="">배송 주소록 관리</a></li>
            </ul>
        </div>
    </div>

    <div class="right-content">
        <div class="">

            <!-- 중간에 다른 박스에 담길 내용들 -->
            <div id="points-container">
                <ul id="points-info" class="item-list">
                    <li class="points-item">포인트 : <a href=""><span id="points" class="points-info">1,000원</span></a>
                    </li>
                    <li class="points-item">쿠폰 : <a href=""><span id="coupon" class="points-info">1개</span></a>
                    </li>
                </ul>
            </div>

        </div>
        <!-- 박스 아래에 붙일 포인트 -->
        <div class="point-list">
            <div class="point-item">
                <ul>
                    <li class="point">
                        <span class="point-value"><span id="total-point">1,000원</span>&nbsp;</span>
                        <strong class="point-type">보유 포인트</strong>
                    </li>
                    <li class="point">
                        <span class="point-value"><span id="normal-point">1,000원</span>&nbsp;</span>
                        <strong class="point-type">일반 포인트</strong>
                    </li>
                    <li class="point">
                        <span class="point-value"><span id="special-point">0원</span></span>
                        <strong class="point-type">특별 포인트</strong>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 그 아래에 붙일 div -->
        <div class="order-status">
            <div class="status-header">
                <h3>나의 주문처리 현황
                    <span class="time-frame">(최근 <em class="months">3개월</em> 기준)</span>
                </h3>
            </div>
            <!-- 이 div 는 box처리할거임 -->
            <div class="status-content">
                <ul class="status-list">
                    <li class="status-item">
                        <a href="" class="status-link"><span id="prepayment-count">0</span></a>
                        <strong class="status-name">입금전</strong>
                    </li>
                    <li class="status-item">
                        <a href="" class="status-link"><span id="preparing-count">0</span></a>
                        <strong class="status-name">배송준비중</strong>
                    </li>
                    <li class="status-item">
                        <a href="" class="status-link"><span id="shipping-count">0</span></a>
                        <strong class="status-name">배송중</strong>
                    </li>
                    <li class="status-item">
                        <a href="" class="status-link"><span id="delivered-count">0</span></a>
                        <strong class="status-name">배송완료</strong>
                    </li>
                </ul>
                <!-- 박스 안의 오른쪽에 붙일 내용 -->
                <ul class="status-list">
                    <li class="status-item">
                        <strong class="status-name">취소</strong>
                        <a href="" class="status-link"><span id="canceled-count">0</span></a>
                    </li>
                    <li class="status-item">
                        <strong class="status-name">교환</strong>
                        <a href="" class="status-link"><span id="exchanged-count">0</span></a>
                    </li>
                    <li class="status-item">
                        <strong class="status-name">반품</strong>
                        <a href="" class="status-link"><span id="returned-count">0</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 맨 아래에 배치시킬 div -->
        <div class="recently-viewed">
            <div class="recently-header">
                <h3>최근본상품</h3>
            </div>
            <div class="recently-content">
                <div class="recently-item">
                </div>
                <p class="no-item">최근본 상품 내역이 없습니다.</p>
            </div>
        </div>

    </div>
</div>
</body>

</html>