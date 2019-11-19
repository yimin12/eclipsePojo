/**
 * 
 */
package yimin.bank.service;

import java.io.IOException;

import yimin.bank.pojo.Account;

/**
* @author yiminH-mail:hymlaucs@gmail.com
* @version Create Time：2019年11月12日 下午9:55:27
* Description:	
* 	basic function that bank need 
*/
public interface AccountService {
	// Password does not match the Account
	int ACCOUNT_PASSWORD_NOT_MATCH=1;
	// Balance Insufficient
	int ACCOUNT_BALANCE_NOT_ENOUGH=2;
	// Account Name does not match 
	int ACCOUNT_NAME_NOT_MATCH=3;
	// Transfer failed
	int ERROR=4;
	// Transfer Successful
	int SUCCESS=5;
	
	// make a transfer
	int transfer(Account accIn, Account accOut) throws IOException;
}
