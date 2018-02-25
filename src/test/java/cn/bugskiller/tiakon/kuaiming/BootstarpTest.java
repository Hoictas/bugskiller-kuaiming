package cn.bugskiller.tiakon.kuaiming;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hoictas on 2018/2/23.
 */
public class BootstarpTest {
    @Test
    public void testMain() {
        String keyWord = " - 副本 ";
        String fileName = "20180223104717 - 副本 (2).jpg";
        System.out.println(fileName.indexOf(keyWord));
        System.out.println(keyWord.length());
        String newfile = fileName.replaceFirst(keyWord,"");
        System.out.println(newfile);
//        String newfile = fileName.substring(fileName.indexOf(keyWord),keyWord.length());
//        System.out.println(newfile);
    }

    @Test
    public void testXXX() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}