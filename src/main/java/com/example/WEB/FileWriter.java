package com.example.WEB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
        public void CreatFile(String name) throws IOException {
            File src = new File("./vcode");
            if (src.exists()==false)
                src.mkdirs();
            File f1 = new File( "./vcode/" + name + ".txt");//相对路径，如果没有前面的src，就在当前目录创建文件
                    f1.createNewFile();
        }

    public void WriteFile(String name,String code)  throws FileNotFoundException{
        File file=new File("./vcode/" +name + ".txt");
        FileOutputStream f1=new FileOutputStream(file);//(file,true)，这里有true的话，代表可以在文件后面追加内容
        byte[] buff=code.getBytes();//将字符串转换为字节数组
        try {
            f1.write(buff);//把字节数组的内容写进去文件
        } catch (Exception e) {
        }finally {
            try {
                f1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*public static void main(String[] args) {
        CreatFile("1234");

    }*/


}
