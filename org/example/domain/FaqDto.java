package org.example.domain;
import java.sql.Date;
import java.util.Objects;

public class FaqDto {
    private String bbsoNo;
    private String ttl;
    private String cn;
    private String kwrd;
    private String cate;
    private Integer faqCnt;
    private Date fstReg;
    private String fstRegr;
    private Date lastUpd;
    private String lastUpdr;
    boolean useYn;

    public FaqDto(){}
    public FaqDto(String bbsoNo, String ttl, String cn, String kwrd, String cate, Integer faqCnt, Date fstReg, String fstRegr, Date lastUpd, String lastUpdr, boolean useYn) {
        this.bbsoNo = bbsoNo;
        this.ttl = ttl;
        this.cn = cn;
        this.kwrd = kwrd;
        this.cate = cate;
        this.faqCnt = faqCnt;
        this.fstReg = fstReg;
        this.fstRegr = fstRegr;
        this.lastUpd = lastUpd;
        this.lastUpdr = lastUpdr;
        this.useYn = useYn;
    }

    public String getBbsoNo() {
        return bbsoNo;
    }

    public void setBbsoNo(String bbsoNo) {
        this.bbsoNo = bbsoNo;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getKwrd() {
        return kwrd;
    }

    public void setKwrd(String kwrd) {
        this.kwrd = kwrd;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public Integer getFaqCnt() {
        return faqCnt;
    }

    public void setFaqCnt(Integer faqCnt) {
        this.faqCnt = faqCnt;
    }

    public Date getFstReg() {
        return fstReg;
    }

    public void setFstReg(Date fstReg) {
        this.fstReg = fstReg;
    }

    public String getFstRegr() {
        return fstRegr;
    }

    public void setFstRegr(String fstRegr) {
        this.fstRegr = fstRegr;
    }

    public Date getLastUpd() {
        return lastUpd;
    }

    public void setLastUpd(Date lastUpd) {
        this.lastUpd = lastUpd;
    }

    public String getLastUpdr() {
        return lastUpdr;
    }

    public void setLastUpdr(String lastUpdr) {
        this.lastUpdr = lastUpdr;
    }

    public boolean isUseYn() {
        return useYn;
    }

    public void setUseYn(boolean useYn) {
        this.useYn = useYn;
    }

    @Override
    public String toString() {
        return "FaqDto{" +
                "bbsoNo='" + bbsoNo + '\'' +
                ", ttl='" + ttl + '\'' +
                ", cn='" + cn + '\'' +
                ", kwrd='" + kwrd + '\'' +
                ", cate='" + cate + '\'' +
                ", faqCnt=" + faqCnt +
                ", fstReg=" + fstReg +
                ", fstRegr='" + fstRegr + '\'' +
                ", lastUpd=" + lastUpd +
                ", lastUpdr='" + lastUpdr + '\'' +
                ", useYn='" + useYn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaqDto FaqDto = (FaqDto) o;
        return Objects.equals(bbsoNo, FaqDto.bbsoNo) && Objects.equals(ttl, FaqDto.ttl) && Objects.equals(cn, FaqDto.cn) && Objects.equals(kwrd, FaqDto.kwrd) && Objects.equals(cate, FaqDto.cate) && Objects.equals(faqCnt, FaqDto.faqCnt)  && Objects.equals(fstRegr, FaqDto.fstRegr) && Objects.equals(lastUpdr, FaqDto.lastUpdr) && Objects.equals(useYn, FaqDto.useYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bbsoNo, ttl, cn, kwrd, cate, faqCnt,  fstRegr, lastUpdr, useYn);
    }
}
