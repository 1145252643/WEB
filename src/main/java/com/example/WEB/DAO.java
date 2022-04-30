package com.example.WEB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    /**
     * login(Connection con,User user) 登录验证
     * (Connection con,User user)注册功能
     * @author 蒋鑫
     */
    public user login(Connection con,user user) throws Exception{
        user resultUser=null;
        String sql="select * from user where userName=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
                resultUser=new user();
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }

    //注册功能
    public boolean register(Connection con,user user) throws Exception{
        boolean flag=false;
        PreparedStatement pstmt = null;
        String sql="INSERT INTO user(userName,password,email)VALUES(?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getEmail());

        try{
            if (pstmt.executeUpdate() > 0) {
                flag = true;
            }
        }
        catch (Exception e){
            flag=false;
        }
        return flag;
    }

}

