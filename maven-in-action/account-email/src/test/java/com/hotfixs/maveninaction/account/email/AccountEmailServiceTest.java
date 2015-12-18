package com.hotfixs.maveninaction.account.email;

/**
 * Created by wangjunwei on 7/21/15.
 */

import static junit.framework.Assert.assertEquals;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

public class AccountEmailServiceTest {
    private GreenMail greenMail;

    @Before
    public void startMailServer() throws Exception {
        greenMail = new GreenMail(new ServerSetup(8008, null, "smtp"));
        greenMail.setUser("user@123.com", "password");
        greenMail.start();
    }

    @Test
    public void testSendMail() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");

        String subject = "Test Subject";
        String htmlText = "<h3>Test</h3>";
        String sendTo = "wakemecn@gmail.com";
        accountEmailService.sendMail(sendTo, subject, htmlText);

        greenMail.waitForIncomingEmail(2000, 1);

        Message[] msgs = greenMail.getReceivedMessages();
        assertEquals(1, msgs.length);
        assertEquals(subject, msgs[0].getSubject());
        assertEquals(sendTo, msgs[0].getRecipients(Message.RecipientType.TO)[0].toString());
        assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
    }

    @After
    public void stopMailServer() throws Exception {
        greenMail.stop();
    }
}

