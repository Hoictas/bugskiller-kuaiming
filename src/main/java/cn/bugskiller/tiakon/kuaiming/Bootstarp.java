package cn.bugskiller.tiakon.kuaiming;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 应用名称:快名
 * 功能:剔除选中路径中所有文件名中的关键字（剔除前缀或后缀）
 * 功能逻辑:
 * 1.根据args0，遍历文件到内存中
 * 2.根据args1,剔除文件名中的关键字，返回剔除后的内容给文件命名
 * cn.bugskiller.tiakon.kuaiming.Bootstarp
 */
public class Bootstarp {
    public static StringBuilder log_strBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int count = 0;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        long startTime = System.currentTimeMillis();
        try {
            System.out.println(getCurrentDate() + "感谢使用快名!");
            log_strBuilder.append(getCurrentDate() + "感谢使用快名!");
            log_strBuilder.append("\r\n");
            if (args.length != 2) {
                returnErrorMethod(getCurrentDate() + "args is error!!!");
                return;
            }
            String filePath = args[0];
            String keyWord = args[1];
            log_strBuilder.append("文件所在的路径:" + filePath);
            log_strBuilder.append("\r\n");
            log_strBuilder.append("关键字:" + keyWord);
            log_strBuilder.append("\r\n");
            File dir = new File(filePath);
            if (!dir.exists()) {
                returnErrorMethod(getCurrentDate() + "file path is no exist!!!");
            }
            File[] files = dir.listFiles();
            for (File file : files) {

                if (!file.isFile()) {
                    returnErrorMethod(file.getName() + "not is a file!!!");
                    continue;
                }

                String fileName = file.getName();
                if (fileName.contains(keyWord)) {
                    String newfile = fileName.substring(keyWord.length());
                    //System.out.println(newfile);
                    log_strBuilder.append(fileName + " ======> " + newfile);
                    log_strBuilder.append("\r\n");
                    count++;
                    //高效率
                    file.renameTo(new File(filePath + File.separator + newfile));
                    //低效率
                    /*inputStream = new FileInputStream(file);
                    outputStream = new FileOutputStream(filePath + File.separator + newfile);
                    byte[] filebuffer = new byte[8192];
                    int readed = 0;
                    while ((readed = inputStream.read(filebuffer)) != -1) {
                        outputStream.write(filebuffer, 0, readed);
                    }
                    inputStream.close();
                    outputStream.close();*/
//                    file.delete();
                }
            }
            long endTime = System.currentTimeMillis();
            log_strBuilder.append("共修改" + count + "个文件");
            log_strBuilder.append(",历时" + (endTime - startTime) + "毫秒");
            log_strBuilder.append("\r\n");
            //System.out.println(log_strBuilder);
            outputStream = new FileOutputStream(filePath + File.separator + "log-" + count + "--" + (endTime - startTime) + ".txt");
//            outputStream = new FileOutputStream(filePath + File.separator + "log-" + count + ".txt");
            outputStream.write(log_strBuilder.toString().getBytes());
            //正确程序返回0
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void returnErrorMethod(String message) {
        log_strBuilder.append(message);
        System.err.println(message);
        System.err.println(message);
        System.err.println(message);
        //错误程序返回1
        System.exit(1);
    }

    private static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " ==============> ";
    }

}
