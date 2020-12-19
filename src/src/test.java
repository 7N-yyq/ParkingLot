import DB.DataBase;
import Model.Car;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String[] argv){
        Car temp = null;
        System.out.println(temp.toString());

    }

    // 将java标准中的date格式转化为 格式：yyyy-MM-dd HH:mm:ss
    // 将java标准中的date格式转化为 字符串 格式：yyyy-MM-dd HH:mm:ss
    // 实体类 -> 数据库
    private static String DateFormat(Date date){
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        return formatter.format(date);
    }

    // 将字符串转化为java中的date格式
    // 数据库 -> 实体类
    private static Date DateFormat(String string){
        if (string == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(string);
        ParsePosition pos = new ParsePosition(8);
        return formatter.parse(dateString, pos);
    }
}
