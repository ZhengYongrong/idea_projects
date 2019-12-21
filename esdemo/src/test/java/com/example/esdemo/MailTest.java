package com.example.esdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
public class MailTest {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    public void test(){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject("开会通知");
        simpleMailMessage.setText("这个是邮件的主要内容！！！");
        simpleMailMessage.setTo("zyr6668888@yeah.net");
        simpleMailMessage.setFrom("994509352@qq.com");
        javaMailSender.send(simpleMailMessage);
    }
    @Test
    public void testM() throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("开会通知");
        mimeMessageHelper.setText("<b style='color:red'>今天 7:30 开会</b>",true);
        mimeMessageHelper.setTo("zyr6668888@yeah.net");
        mimeMessageHelper.setFrom("994509352@qq.com");
        mimeMessageHelper.addAttachment("README.md",new File("C:\\Users\\Administrator\\Desktop\\music-website-master\\README.md"));
        javaMailSender.send(mimeMessage);
    }
}
