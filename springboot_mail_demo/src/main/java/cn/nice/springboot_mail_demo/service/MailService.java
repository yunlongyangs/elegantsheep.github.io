package cn.nice.springboot_mail_demo.service;


public interface MailService {

    //简单邮件
    public void sendSimpleMail(String to, String subject, String content);

    //html邮件
    public void sendHtmlMail(String to, String subject, String content);

    //带附件邮件
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    //带静态资源文件（图片）的邮件
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);



}
