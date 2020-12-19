package DB;

import java.sql.*;

public class DataBase {

    // 数据库的相关信息
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/parkinglot?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "154537839";

    // 链接与sql脚本
    Connection conn = null;
    Statement stmt = null;

    /** 初始化链接数据库 */
    public DataBase(){
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
        } catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }


    /**
     * 查
     * @param key
     * @param value
     * @param table 表名
     */
    public ResultSet select(String key, String value, String table){
        String sql;
        if (key == null) sql = "SELECT * FROM "+table;
        else sql = "SELECT * FROM "+table+" WHERE "+key+"="+value;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }catch (SQLException e){
            return null;
        }
    }


    /**
     * 增
     */
    public boolean insert(String key, String value, String table){
        String sql;
        if (key != null) sql = "INSERT INTO "+table+" ("+key+") VALUES ("+value+")";
        else sql = "INSERT INTO "+table+" VALUES ("+value+")";
        try {
            stmt.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 改，一次只能改一列
     * @param find_key 查找的关键字
     * @param find_value 查找的值
     * @param table 表名
     * @param alter_key 要改哪一列
     * @param alter_value 要改成什么
     * @return 操作成功？
     */
    public boolean updata(String find_key, String find_value, String table, String alter_key, String alter_value){
        String sql = "UPDATE "+table+" SET "+alter_key+"="+alter_value+" WHERE "+find_key+"="+find_value;
        try {
            stmt.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 删
     * @param key 关键字
     * @param value 关键字的值
     * @param table 表名
     * @return 操作成功？
     */
    public boolean delete(String key, String value, String table){
        String sql;
        if (key == null) sql = "DELETE FROM "+table;
        else sql = "DELETE FROM "+table+" WHERE "+key+"="+value;
        try {
            stmt.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] argv) {
        DataBase db = new DataBase();
        ResultSet res = db.select("id", "0", "place");
        try {
            System.out.println(res.next());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

