package com.example.WEB;
import java.sql.Connection;



public class RegisterServlet  {

    protected void doPost(String userName,String password,String email,String vcode) {

        FileReader nsC=new FileReader();


        if (vcode.equals(nsC.Getcode(email))){
            Dbutil db= new Dbutil();
            user user=new user(userName,password,email);
            DAO dao=new DAO();
            try {
                //数据库链接
                Connection con=db.getCon();

                if(dao.register(con,user)) {
                    System.out.println("1");
                }else {
                    System.out.println("2");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

       }
       else {
            System.out.println("3");
        }

    }
}
