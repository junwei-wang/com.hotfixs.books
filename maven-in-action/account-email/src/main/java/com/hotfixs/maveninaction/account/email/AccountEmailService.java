package com.hotfixs.maveninaction.account.email;

/**
 * Created by wangjunwei on 7/21/15.
 */
public interface AccountEmailService {
    void sendMail(String to, String subject, String htmlText) throws AccountEmailException;
}
