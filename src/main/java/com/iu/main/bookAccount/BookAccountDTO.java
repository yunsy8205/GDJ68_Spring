package com.iu.main.bookAccount;

import java.sql.Date;

public class BookAccountDTO {
	
	private Long accountNum;
	private String id;
	private Long bookNum;
	private Long account;
	private Integer accountPassword;
	public Integer getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(Integer accountPassword) {
		this.accountPassword = accountPassword;
	}
	private Long accountBalance;
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	private Date accountDate;
	

}
