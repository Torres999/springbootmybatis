package com.demo.springbootmybatis.dao.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Acct {
    /**
     * 用户号
     */
    @Id
    @Column(name = "user_no")
    private String userNo;

    @Id
    @Column(name = "curr_no")
    private String currNo;

    /**
     * 账户类型
     */
    @Id
    @Column(name = "acct_type_no")
    private String acctTypeNo;

    /**
     * 有效时间
     */
    @Id
    private String exp;

    /**
     * 账户号
     */
    @Column(name = "acct_no")
    private String acctNo;

    /**
     * 账户别名
     */
    @Column(name = "acct_alias")
    private String acctAlias;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 余额
     */
    private BigDecimal bal;

    /**
     * 累加余额
     */
    @Column(name = "inc_bal")
    private BigDecimal incBal;

    /**
     * 冻结金额
     */
    @Column(name = "frz_bal")
    private BigDecimal frzBal;

    /**
     * 状态
     */
    private String status;

    /**
     * 加密
     */
    private String dac;

    private Integer node;

    private Integer num;

    @Column(name = "last_time")
    private Date lastTime;

    /**
     * 获取用户号
     *
     * @return user_no - 用户号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置用户号
     *
     * @param userNo 用户号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * @return curr_no
     */
    public String getCurrNo() {
        return currNo;
    }

    /**
     * @param currNo
     */
    public void setCurrNo(String currNo) {
        this.currNo = currNo;
    }

    /**
     * 获取账户类型
     *
     * @return acct_type_no - 账户类型
     */
    public String getAcctTypeNo() {
        return acctTypeNo;
    }

    /**
     * 设置账户类型
     *
     * @param acctTypeNo 账户类型
     */
    public void setAcctTypeNo(String acctTypeNo) {
        this.acctTypeNo = acctTypeNo;
    }

    /**
     * 获取有效时间
     *
     * @return exp - 有效时间
     */
    public String getExp() {
        return exp;
    }

    /**
     * 设置有效时间
     *
     * @param exp 有效时间
     */
    public void setExp(String exp) {
        this.exp = exp;
    }

    /**
     * 获取账户号
     *
     * @return acct_no - 账户号
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * 设置账户号
     *
     * @param acctNo 账户号
     */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    /**
     * 获取账户别名
     *
     * @return acct_alias - 账户别名
     */
    public String getAcctAlias() {
        return acctAlias;
    }

    /**
     * 设置账户别名
     *
     * @param acctAlias 账户别名
     */
    public void setAcctAlias(String acctAlias) {
        this.acctAlias = acctAlias;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取余额
     *
     * @return bal - 余额
     */
    public BigDecimal getBal() {
        return bal;
    }

    /**
     * 设置余额
     *
     * @param bal 余额
     */
    public void setBal(BigDecimal bal) {
        this.bal = bal;
    }

    /**
     * 获取累加余额
     *
     * @return inc_bal - 累加余额
     */
    public BigDecimal getIncBal() {
        return incBal;
    }

    /**
     * 设置累加余额
     *
     * @param incBal 累加余额
     */
    public void setIncBal(BigDecimal incBal) {
        this.incBal = incBal;
    }

    /**
     * 获取冻结金额
     *
     * @return frz_bal - 冻结金额
     */
    public BigDecimal getFrzBal() {
        return frzBal;
    }

    /**
     * 设置冻结金额
     *
     * @param frzBal 冻结金额
     */
    public void setFrzBal(BigDecimal frzBal) {
        this.frzBal = frzBal;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取加密
     *
     * @return dac - 加密
     */
    public String getDac() {
        return dac;
    }

    /**
     * 设置加密
     *
     * @param dac 加密
     */
    public void setDac(String dac) {
        this.dac = dac;
    }

    /**
     * @return node
     */
    public Integer getNode() {
        return node;
    }

    /**
     * @param node
     */
    public void setNode(Integer node) {
        this.node = node;
    }

    /**
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return last_time
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * @param lastTime
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}