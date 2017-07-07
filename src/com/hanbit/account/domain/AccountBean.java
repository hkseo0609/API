package com.hanbit.account.domain;

public class AccountBean {
	public String name, id, pwd, txDate, ssn;
	public int money, accountNum;
	public final static String bankName = "KB국민은행";
	
	public void setName(String name){
		this.name = name;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	public void setDate(String txDate){
		this.txDate = txDate;
	}
	public void setSsn(String ssn){
		this.ssn = ssn;
	}
	public void setMoney(int money){
		this.money = money;
	}
	public void setAccountNum(int accountNum){
		this.accountNum = accountNum;
	}
	//get
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public String getPwd(){
		return pwd;
	}
	public String getSsn(){
		return ssn;
	}
	public String gettxDate(){
		return txDate;
	}
	public int getMoney(){
		return money;
	}
	public int getAccountNum(){
		return accountNum;
	}
	public String toString(){
		return String.format("이름:%s  계좌번호:%d  날짜:%s  잔액:%d  ",name,accountNum,txDate,money);
	}
	
	
}
