<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null || pageContext.request.session.getAttribute('id')=='' ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>
<c:set var="addAndModify" value="${loginId=='' ? '/register/add' : 'custModify'}"/>
<c:set var="register" value="${loginId=='' ? '회원가입' : '정보수정'}"/>
<c:set var="logo" value="${loginId=='' ? '/' : '/login/logoClick'}"/>
<footer>
    <div id="footer" class="xans-element- xans-layout xans-layout-footer ">
        <div class="ft_gnb">
            <div class="w_custom clearfix">
                <ul class="ft_gnb_menu">
                    <li><a href="">회사소개</a></li>
                    <li><a href="">이용약관</a></li>
                    <li><a href=""><strong>개인정보처리방침</strong></a></li>
                    <li><a href="/user/list">이용안내</a></li>
                </ul>
            </div>
        </div>
        <div class="ft_info w_custom clearfix">
            <div class="ft_txt">
                <p>
                    상호 : (주)드가닭<span class="bar"></span>주소 : <!--05398--> 서울특별시 종로2가9
                    <span class="bar"></span>대표 : 김유성<br>
                    사업자등록번호 : 123-12-12345 <a href="#none"
                                              >[사업자정보확인]</a><span
                        class="bar"></span>통신판매업신고번호 : 2023-서울종로-1234<span class="bar"></span>개인정보관리자 : 김현우<br>
                    대표번호 : 1234-1234<span class="bar"></span>팩스번호 : 02-1234-1234<span class="bar"></span>메일 : <a
                        href="mailto:moguchonmall@naver.com">github.com/Useodam</a>
                </p>
            </div>
        </div>
    </div>
</footer>