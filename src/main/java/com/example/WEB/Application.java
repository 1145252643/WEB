package com.example.WEB;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/reg/Email")
    public void Email(String Email) throws Exception {
        EmailServlet test=new EmailServlet();
        test.mGetVCode(Email);
    }


    @GetMapping("/reg/Login")
    public void Login(String userName,String password,String email) throws Exception {
        LoginServlet test=new LoginServlet();
        test.dopost(userName,password,email);
    }


    @GetMapping("/reg/Reg")
    public void Reg(String userName,String password,String email,String vcode) throws Exception {
        RegisterServlet test=new RegisterServlet();
        test.doPost(userName,password,email,vcode);
    }


}






