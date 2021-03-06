package pers.qiqcheng.spring.demo16;


import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService{

	private AccountDaoImpl accountDaoImpl;
	private TransactionTemplate transactionTemplate;
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	public void setAccountDaoImpl(AccountDaoImpl accountDaoImpl) {
		this.accountDaoImpl = accountDaoImpl;
	}
	public AccountDaoImpl getAccountDaoImpl() {
		return accountDaoImpl;
	}
	@Override
	
	public void transfer(String from, String to, Double money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				accountDaoImpl.out(from, money);
			    //int a=1/0;
				accountDaoImpl.in(to, money);
			}
		});
	}

}
