package model;

import java.util.Date;

public class AdvancedSearch {

    private Long bookTipId;
    private String minPageNum;
    private String maxPageNum;
    private String minCopies;
    private String maxCopies;
    private Float minPrice;
    private Float maxPrice;
    private String minNum;
    private String maxNum;
    private Date beginDate;
    private Date endDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMinNum() {
        return minNum;
    }

    public void setMinNum(String minNum) {
        this.minNum = minNum;
    }

    public String getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(String maxNum) {
        this.maxNum = maxNum;
    }

    public Long getBookTipId() {
        return bookTipId;
    }

    public void setBookTipId(Long bookTipId) {
        this.bookTipId = bookTipId;
    }

    public String getMinPageNum() {
        return minPageNum;
    }

    public void setMinPageNum(String minPageNum) {
        this.minPageNum = minPageNum;
    }

    public String getMaxPageNum() {
        return maxPageNum;
    }

    public void setMaxPageNum(String maxPageNum) {
        this.maxPageNum = maxPageNum;
    }

    public String getMinCopies() {
        return minCopies;
    }

    public void setMinCopies(String minCopies) {
        this.minCopies = minCopies;
    }

    public String getMaxCopies() {
        return maxCopies;
    }

    public void setMaxCopies(String maxCopies) {
        this.maxCopies = maxCopies;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

}
