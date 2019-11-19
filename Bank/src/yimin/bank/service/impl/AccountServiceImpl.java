/**
 * 
 */
package yimin.bank.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


import yimin.bank.pojo.Account;
import yimin.bank.pojo.Log;
import yimin.bank.service.AccountService;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月12日 下午10:17:42
* Description:
* 	implementation of account service
*/
public class AccountServiceImpl implements AccountService{

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		// check whether the password match the bank account
		Account accOutSelect = session.selectOne("yimin.bank.mapper.AccountMapper.selByAccnoPwd", accOut);
		if(accOutSelect!=null) {
			if(accOutSelect.getBalance() >= accOut.getBalance()) {
				Account accInSelect = session.selectOne("yimin.bank.mapper.AccountMapper.selByAccno", accIn);
				if(accInSelect!=null) {
					accIn.setBalance(accOut.getBalance());
					accOut.setBalance(-accOut.getBalance());
					int index = session.update("yimin.bank.mapper.AccountMapper.updBalanceByAccno",accOut);
					index += session.update("yimin.bank.mapper.AccountMapper.updBalanceByAccno", accIn);
					if(index == 2) {
						Log log = new Log();
						log.setAccIn(accIn.getAccNo());
						log.setAccOut(accOut.getAccNo());
						log.setMoney(accIn.getBalance());
						session.insert("yimin.bank.mapper.LogMapper.insLog", log);
						// log the information of bank	
						Logger logger = Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccOut() + "transfer to " + log.getAccIn() + "in " + new Date().toLocaleString() + "transfered" + log.getMoney());
						session.commit();
						session.close();
						return SUCCESS;
					} else {
						session.rollback();
						session.close();
						return ERROR;
					}
				} else {
					return ACCOUNT_NAME_NOT_MATCH;
				}
			} else {
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		} else {
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}
	}

}
