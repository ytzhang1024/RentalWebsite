package com.yutian.zhang.rental.common.util;

import io.github.biezhi.ome.OhMyEmail;

import javax.mail.MessagingException;
import java.util.Properties;

/**
 * MailUtil
 *
 * @author xlongwei
 * @date 2021/3/15 9:57
 */

public class MailUtil {

    /**
     * Configuration
     *
     * @param smtpHost smtpHost
     * @param userName mail address
     * @param password password
     */
    public static void configMail(String smtpHost, String userName, String password) {
        Properties properties = OhMyEmail.defaultConfig(false);
        properties.setProperty("mail.smtp.host", smtpHost);
        OhMyEmail.config(properties, userName, password);
    }


    private static final String host = "smtp.gmail.com";

    private static final String fromName = "House Rental";

    // Proxy Email Account
    private static final String username = "waynecheung1024@gmail.com";

    // Authorisation Code
    private static final String password = "llxzuwmnsfbofuwv";


    /**
     * Sent Mail
     *
     * @param to      to Receiver
     * @param title   subject Title
     * @param content content Content
     */
    public static void sendMail(String to, String title, String content) throws MessagingException {
        //Mail server
        configMail(host, username, password);
        OhMyEmail.subject(title)
                .from(fromName)
                .to(to)
                .html(content)
                .send();
    }
}
