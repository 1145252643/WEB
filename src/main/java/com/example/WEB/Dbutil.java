package com.example.WEB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {

    /**
     * @DbUtil类的作用 jdbc 的一些简单配置
     * dbUrl
     * dbusername
     * dbpassword
     * jdbcName
     * @author 蒋鑫
     */

    private String dbUrl = "jdbc:mysql://123.56.87.97:3306/ksvip";


    private String dbUserName = "Ksvip";
    private String dbPassword = "a308637721";
    private String jdbcName="com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    /**
     * 关闭数据库连接
     *
     * @param con
     * @throws Exception
     */
    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }


}

