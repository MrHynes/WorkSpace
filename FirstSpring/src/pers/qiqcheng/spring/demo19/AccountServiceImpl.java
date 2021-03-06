package pers.qiqcheng.spring.demo19;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements AccountService{

	private AccountDaoImpl accountDaoImpl;
	public void setAccountDaoImpl(AccountDaoImpl accountDaoImpl) {
		this.accountDaoImpl = accountDaoImpl;
	}
	public AccountDaoImpl getAccountDaoImpl() {
		return accountDaoImpl;
	}
	@Override
	
	public void transfer(String from, String to, Double money) {
		accountDaoImpl.out(from, money);
		//int a=1/0;
		accountDaoImpl.in(to, money);
	}

}
