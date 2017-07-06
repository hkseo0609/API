package com.hanbit.account.serviceImpl;

import java.util.Calendar;
import java.util.Vector;

import com.hanbit.account.domain.AccountBean;
import com.hanbit.account.service.AccountService;

public class AccountServiceImpl implements AccountService{
	Vector<AccountBean> vec;
	AccountBean bean;
	public AccountServiceImpl() {
		vec = new Vector<AccountBean>(10,10);
		bean = new AccountBean();
	}

	@Override
	public void createAccount(AccountBean bean) {
		//계좌개설
		int randomNo = (int)(Math.random()*99999999+10000000);
		Calendar now = Calendar.getInstance();
		int yy = now.get(now.YEAR);
		int mm = now.get(now.MONTH)+1;
		int dd = now.get(now.DAY_OF_MONTH);
		String nowDate = String.format("%d년 %d월 %d일", yy,mm,dd);
		bean.setAccountNum(randomNo);
		bean.setDate(nowDate);
		vec.add(bean);
	}

	@Override
	public Vector<AccountBean> list() {
		// 계좌 전체 목록
		return vec;
	}

	@Override
	public Vector<AccountBean> findName(String name) {
		// 이름검색(동명이인허용)
		Vector<AccountBean> temp = new Vector<AccountBean>(10,10);
		for(int i=0; i<vec.size(); i++){
			if(name.equals(vec.get(i).getName())){
				temp.add(vec.get(i));
			}
		}
		return temp;
	}

	@Override
	public AccountBean findAccount(int accountNum) {
		// 계좌번호조회
		AccountBean temp = new AccountBean();
		for(int i=0; i<vec.size(); i++){
			if(accountNum == vec.get(i).getAccountNum()){
				temp = vec.get(i);
			}
		}
		return temp;
	}

	@Override
	public int count() {
		// 전체계좌수
		return vec.size();
	}

	@Override
	public void updatePwd(AccountBean inputBean) {
		// 비밀번호 변경
		bean = findAccount(inputBean.getAccountNum());
		bean.setPwd(inputBean.getPwd());
		
	}

	@Override
	public void deposit(AccountBean inputBean) {
		// 예금
		bean = findAccount(inputBean.getAccountNum());
		bean.setMoney(bean.getMoney()+inputBean.getMoney());
		
	}

	@Override
	public void withdraw(AccountBean inputBean) {
		// 출금
		bean = findAccount(inputBean.getAccountNum());
		bean.setMoney(bean.getMoney()-inputBean.getMoney());
		
	}

	@Override
	public void delete(int accountNum) {
		// 계좌 해지
		if(vec.contains(accountNum)){
			vec.remove(accountNum);
		}
		
	}
	

}
