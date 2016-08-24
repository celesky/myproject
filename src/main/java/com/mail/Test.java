package com.mail;

public class Test {
	public static void main(String[] args) {
		  //这个类主要是设置邮件  
	      MailSenderInfo mailInfo = new MailSenderInfo();   
	      mailInfo.setMailServerHost("smtp.lifesense.com");   
	      mailInfo.setMailServerPort("25");   
	      mailInfo.setValidate(true);   
	      mailInfo.setUserName("qiong.pan@lifesense.com");   
	      mailInfo.setPassword("Lf123456!");//您的邮箱密码   
	      mailInfo.setFromAddress("qiong.pan@lifesense.com");   
	      mailInfo.setToAddress("290519112@qq.com");   
	      mailInfo.setSubject("hello！");   
	      mailInfo.setContent("hello，this is content！");   
	        //这个类主要来发送邮件  
	      SimpleMailSender sms = new SimpleMailSender();  
	      //sms.sendTextMail(mailInfo);//发送文体格式   
	      sms.sendHtmlMail(mailInfo);//发送html格式  
	}
	
	
	
	public  void add(){
		System.out.println("just test ohye!");
	}
}
