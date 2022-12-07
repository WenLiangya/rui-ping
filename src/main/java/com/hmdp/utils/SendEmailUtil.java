package com.hmdp.utils;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.HtmlEmail;

import java.util.Random;

@Slf4j
public class SendEmailUtil {
    private SendEmailUtil() {}

    public static String sendEmail(String emailaddress) {
        try {
            Random random = new Random();
            String code = RandomUtil.randomNumbers(6);
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.qq.com");
            email.setCharset("UTF-8");
            email.addTo(emailaddress);// 收件地址

            email.setFrom("3049625601@qq.com", "黑马点评");
            email.setAuthentication("3049625601@qq.com", "lcbygiydbggcdebh");

            email.setSubject("操作验证码");
            email.setMsg("尊敬的用户您好,您本次操作的验证码是:" + code);

            email.send();
            return code;
        } catch (Exception e) {
            log.error("邮件发送失败！");
            return null;
        }
    }

}