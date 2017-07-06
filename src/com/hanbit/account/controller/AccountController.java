package com.hanbit.account.controller;

import java.util.Vector;

import javax.swing.*;

import com.hanbit.account.domain.AccountBean;
import com.hanbit.account.service.AccountService;
import com.hanbit.account.serviceImpl.AccountServiceImpl;

public class AccountController {
	public static void main(String[] args){
		AccountService service = new AccountServiceImpl();
		AccountBean bean;
		
		while(true){
			switch(JOptionPane.showInputDialog("0.종료  1.계좌개설  2.계좌전체목록  3.이름검색  4.계좌번호조회  5.전체계좌수  6.비밀번호 변경  7.예금  8.출금  9.계좌해지")){
			case "0":
				JOptionPane.showMessageDialog(null, "프로그램 종료!");
				return;
			case "1":
				bean = new AccountBean();
				String arr[] = JOptionPane.showInputDialog("이름/비번/아이디/입금액/SSN").split("/");
				bean.setName(arr[0]);
				bean.setPwd(arr[1]);
				bean.setId(arr[2]);
				bean.setMoney(Integer.parseInt(arr[3]));
				bean.setSsn(arr[4]);
				service.createAccount(bean);
				JOptionPane.showMessageDialog(null, "계좌 개설 성공!");
				break;
			case "2":
				Vector<AccountBean> vec = service.list();
				JOptionPane.showMessageDialog(null, vec);
				break;
			case "3":
				Vector<AccountBean> vec2 = service.findName(JOptionPane.showInputDialog("이름을 입력하세요"));
				JOptionPane.showMessageDialog(null, vec2);
				break;
			case "4":
				//bean = service.findAccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호를 입력하세요")));
				JOptionPane.showMessageDialog(null, service.findAccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호를 입력하세요"))));
				break;
			case "5":
				
				JOptionPane.showMessageDialog(null, service.count());
				break;
			case "6":
				AccountBean bean2 = new AccountBean();
				String[] arr2 = JOptionPane.showInputDialog("계좌번호/비밀번호").split("/");
				bean2.setAccountNum(Integer.parseInt(arr2[0]));
				bean2.setPwd(arr2[1]);
				service.updatePwd(bean2);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
				break;
			case "7":
				AccountBean bean3 = new AccountBean();
				String[] arr3 = JOptionPane.showInputDialog("계좌번호/예금 금액").split("/");
				bean3.setAccountNum(Integer.parseInt(arr3[0]));
				bean3.setMoney(Integer.parseInt(arr3[1]));
				service.deposit(bean3);
				JOptionPane.showMessageDialog(null, "예금되었습니다.");
				break;
			case "8":
				AccountBean bean4 = new AccountBean();
				String[] arr4 = JOptionPane.showInputDialog("계좌번호/출금 금액").split("/");
				bean4.setAccountNum(Integer.parseInt(arr4[0]));
				bean4.setMoney(Integer.parseInt(arr4[1]));
				service.withdraw(bean4);
				JOptionPane.showMessageDialog(null, "출금되었습니다.");
				break;
			case "9":
				service.delete(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
				JOptionPane.showMessageDialog(null, "계좌 해지 완료");
				break;
			
			}
		}
	}

}
