package cn.nice.springboot_mail_demo;

import cn.nice.springboot_mail_demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailDemoApplicationTests {

    //发送者
    private final String to = "3445115211@qq.com";

    //验证码
    private final String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);

    //标题
    private final String subject = "验证码";

    //内容
    private final String content = "您的验证码为："+checkCode;

    //文件路径
    private final  String filePath = "C:\\Users\\lenovo\\Desktop\\mail.md";

    //图片路径
    private final String imgPath = "D:\\Users\\lenovo\\Pictures\\Camera Roll\\e9fa45ed722c17fdb0b9786ad2059f7a.jpg";

    @Autowired
    private MailService mailService;


    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail(to,subject,content);
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>您的验证码为</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(to,subject,content);
    }

    @Test
    public void sendAttachmentsMail() {
        mailService.sendAttachmentsMail(to,subject, checkCode, filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        mailService.sendInlineResourceMail(to, "主题：这是有图片的邮件", content, imgPath, rscId);
    }

}
