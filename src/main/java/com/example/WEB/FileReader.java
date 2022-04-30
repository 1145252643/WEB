package com.example.WEB;

import java.io.File;
import java.io.FileInputStream;

public class FileReader{
    public String Getcode(String name){
        char[] helloArray =new char[6];
        String rt=new String(helloArray);

        try {
            File file=new File("./" +name + ".txt");
            FileInputStream f1=new FileInputStream(file);//这里需要进行抛出异常处理
            for (int i = 0; i <= 5; i++) {
                helloArray[i]=(char)(f1.read());
            }
            rt=new String(helloArray);
            f1.close();//关闭文件
        } catch (Exception e) {
            System.out.println("文件打开失败");
        }

        return rt;
    }


}


