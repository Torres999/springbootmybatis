package com.demo.springbootmybatis.dao.domain;

import javax.persistence.*;

@Table(name = "acct_mbr")
public class AcctMbr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "user_no")
    private String userNo;

    private String reserve1;

    private String reserve2;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return mobile_no
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * @param userNo
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * @return reserve1
     */
    public String getReserve1() {
        return reserve1;
    }

    /**
     * @param reserve1
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    /**
     * @return reserve2
     */
    public String getReserve2() {
        return reserve2;
    }

    /**
     * @param reserve2
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }
}