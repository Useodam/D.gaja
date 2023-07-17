package org.example.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class custAdminCondition {
    private Integer page=1;
    private Integer pageSize=10;
    //private Integer offset=0; //굳이 iv로 있을 필요가 없다.
    private String keyword= "";
    private String option="";

    public custAdminCondition(){}
    public custAdminCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
    }
    public String getQueryString(Integer page){ //페이지 지정해주면
        //?page=1&pageSize=10&option=T&keyword="title"
        return UriComponentsBuilder.newInstance() //UriComponentsBuilder 사용해서 객체생성
                .queryParam("page",page) //파라미터 추가
                .queryParam("pageSize",pageSize)
                .queryParam("option",option)
                .queryParam("keyword",keyword)
                .build().toString(); // 완성된 쿼리스트링을 문자열 형태로 반환
        //쿼리스트링 만들어줌
    }
    // 입력받은 페이지 번호와 미리 정의된 변수들을 이용하여 쿼리스트링을 생성하고,
    // 생성된 쿼리스트링을 문자열로 반환.
    // 생성된 쿼리스트링은 여러 정보를 URL에 전달할 수 있게 한다.
    public String getQueryString(){ //페이지 지정해주지 않으면
        return getQueryString(page);
    }

    @Override
    public String toString() {
        return "custAdminCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
