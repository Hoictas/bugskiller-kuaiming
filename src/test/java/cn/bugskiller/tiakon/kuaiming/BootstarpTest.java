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
        String keyWord = "微信图片_";
        String fileName = "微信图片_201802231039291";
        String newfile = fileName.substring(keyWord.length());
        System.out.println(newfile);
    }

    @Test
    public void testXXX() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}