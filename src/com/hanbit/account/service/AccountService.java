package com.hanbit.account.service;

import java.util.Vector;
import com.hanbit.account.domain.AccountBean;

public interface AccountService {
	public void createAccount(AccountBean bean);
	//리스트, 카운트, 이름과 계좌번호로 찾기
	public Vector<AccountBean> list();
	public Vector<AccountBean> findName(String name);
	public AccountBean findAccount(int accountNum);
	public int count();
	//업데이트 비번바꾸기, 입금, 출금
	public void updatePwd(AccountBean inputBean);
	public void deposit(AccountBean inputBean);
	public void withdraw(AccountBean inputBean);
	//계좌삭제
	public void delete(int accountNum);

}
