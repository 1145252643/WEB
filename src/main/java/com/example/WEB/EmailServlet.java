package com.example.WEB;


import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.regex.Pattern;


public class EmailServlet extends HttpServlet {
    private EmailUtil emailUtil = EmailUtil.instance;


    public void mGetVCode(String email) throws IOException {
        if(!isEmail(email)) {  // 邮箱不正确
            return;
        }
        try {
            emailUtil.sendEmail(email);
            FileWriter nsC=new FileWriter();
            nsC.CreatFile(email);
            nsC.WriteFile(email,emailUtil.getVCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * 邮箱正确性检测
     * @param 邮箱字符串
     * @return true/false
     */
    public boolean isEmail(String email) {
        if(email.length() == 0 || email == null) {
            return false;
        }
        // 正则表达式验证邮箱
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
        return pattern.matcher(email).matches();
    }

}


