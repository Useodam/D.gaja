package org.example.domain;
import java.util.Date;
import java.util.Objects;

public class CartDto {
    private int seq;
    private String cartId;
    private String prodCd;
    private String prodName;
    private int prodQty;
    private int totSetlPrice;
    private int paymtPnt;
    private int expctDcPrc;
    private int dexp;
    private int saveTerm;
    private Date fstReg;
    private String fstRegr;
    private Date lastUpd;
    private String lastUpdr;


    public CartDto() {}

    //

    public CartDto(String cartId, String prodCd, String prodName, int prodQty, int totSetlPrice) {
        this.cartId = cartId;
        this.prodCd = prodCd;
        this.prodName = prodName;
        this.prodQty = prodQty;
        this.totSetlPrice = totSetlPrice;
    }

    public CartDto(int seq, String cartId, String prodCd, String prodName, int prodQty, int totSetlPrice, int paymtPnt, int expctDcPrc, int dexp, int saveTerm, Date fstReg, String fstRegr, Date lastUpd, String lastUpdr) {
        this.seq = seq;
        this.cartId = cartId;
        this.prodCd = prodCd;
        this.prodName = prodName;
        this.prodQty = prodQty;
        this.totSetlPrice = totSetlPrice;
        this.paymtPnt = paymtPnt;
        this.expctDcPrc = expctDcPrc;
        this.dexp = dexp;
        this.saveTerm = saveTerm;
        this.fstReg = fstReg;
        this.fstRegr = fstRegr;
        this.lastUpd = lastUpd;
        this.lastUpdr = lastUpdr;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProdCd() {
        return prodCd;
    }

    public void setProdCd(String prodCd) {
        this.prodCd = prodCd;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdQty() {
        return prodQty;
    }

    public void setProdQty(int prodQty) {
        this.prodQty = prodQty;
    }

    public int getTotSetlPrice() {
        return totSetlPrice;
    }

    public void setTotSetlPrice(int totSetlPrice) {
        this.totSetlPrice = totSetlPrice;
    }

    public int getPaymtPnt() {
        return paymtPnt;
    }

    public void setPaymtPnt(int paymtPnt) {
        this.paymtPnt = paymtPnt;
    }

    public int getExpctDcPrc() {
        return expctDcPrc;
    }

    public void setExpctDcPrc(int expctDcPrc) {
        this.expctDcPrc = expctDcPrc;
    }

    public int getDexp() {
        return dexp;
    }

    public void setDexp(int dexp) {
        this.dexp = dexp;
    }

    public int getSaveTerm() {
        return saveTerm;
    }

    public void setSaveTerm(int saveTerm) {
        this.saveTerm = saveTerm;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartDto cartDto = (CartDto) o;

        if (seq != cartDto.seq) return false;
        if (prodQty != cartDto.prodQty) return false;
        if (totSetlPrice != cartDto.totSetlPrice) return false;
        if (paymtPnt != cartDto.paymtPnt) return false;
        if (expctDcPrc != cartDto.expctDcPrc) return false;
        if (dexp != cartDto.dexp) return false;
        if (saveTerm != cartDto.saveTerm) return false;
        if (!Objects.equals(cartId, cartDto.cartId)) return false;
        if (!Objects.equals(prodCd, cartDto.prodCd)) return false;
        if (!Objects.equals(prodName, cartDto.prodName)) return false;
        if (!Objects.equals(fstReg, cartDto.fstReg)) return false;
        if (!Objects.equals(fstRegr, cartDto.fstRegr)) return false;
        if (!Objects.equals(lastUpd, cartDto.lastUpd)) return false;
        return Objects.equals(lastUpdr, cartDto.lastUpdr);
    }

    @Override
    public int hashCode() {
        int result = seq;
        result = 31 * result + (cartId != null ? cartId.hashCode() : 0);
        result = 31 * result + (prodCd != null ? prodCd.hashCode() : 0);
        result = 31 * result + (prodName != null ? prodName.hashCode() : 0);
        result = 31 * result + prodQty;
        result = 31 * result + totSetlPrice;
        result = 31 * result + paymtPnt;
        result = 31 * result + expctDcPrc;
        result = 31 * result + dexp;
        result = 31 * result + saveTerm;
        result = 31 * result + (fstReg != null ? fstReg.hashCode() : 0);
        result = 31 * result + (fstRegr != null ? fstRegr.hashCode() : 0);
        result = 31 * result + (lastUpd != null ? lastUpd.hashCode() : 0);
        result = 31 * result + (lastUpdr != null ? lastUpdr.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "seq=" + seq +
                ", cartId='" + cartId + '\'' +
                ", prodCd='" + prodCd + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodQty=" + prodQty +
                ", totSetlPrice=" + totSetlPrice +
                ", paymtPnt=" + paymtPnt +
                ", expctDcPrc=" + expctDcPrc +
                ", dexp=" + dexp +
                ", saveTerm=" + saveTerm +
                ", fstReg=" + fstReg +
                ", fstRegr='" + fstRegr + '\'' +
                ", lastUpd=" + lastUpd +
                ", lastUpdr='" + lastUpdr + '\'' +
                '}';
    }
}