package com.example.WEB;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;


public class LoginServlet extends HttpServlet {



    protected String dopost(String userName, String password, String email) throws ServletException, IOException {

        Dbutil db= new Dbutil();
        user user=new user(userName,password,email);
        DAO dao=new DAO();

        try {
            //数据库链接
            Connection con=db.getCon();

            if(dao.login(con, user)!=null) {

                return "/jsp/ok.jsp";

            }else {

                return "/jsp/register.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
