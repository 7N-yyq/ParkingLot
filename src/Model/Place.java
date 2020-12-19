package Model;

import DB.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Place {

    private int ID;
    private State state;
    private Date begin;
    private Car car;

    private final Date timenull = new Date(0);
    private final Car carnull = new Car("null:null");

    private DataBase db;



    /**
     * 初始化一个停车位，初始状态为 空闲
     * @param ID 车位ID
     */
    public Place(int ID, DataBase db) {
        this.ID = ID;
        this.state = State.free;
        this.begin = timenull;
        this.car = carnull;
        this.db = db;
        this.write();
    }


    /**
     * 从数据库读入一个位置的信息
     * @param res
     */
    public Place(ResultSet res, DataBase db){
        this.db = db;
        try {
            ID = res.getInt("id");
            state = State.valueOf(res.getString("state"));
            begin = DateFormat(res.getTimestamp("begin"));
            car = new Car(res.getString("car"));
        }catch (SQLException e){ e.printStackTrace(); }
    }



    /** get方法 */
    public State getState() { return this.state; }
    public Car getCar() { return car; }


    /** 从数据库中 读 这个停车位的信息 */
    public void read(){
        try{
            ResultSet res = db.select("id", String.valueOf(ID), "place");
            if ( res.next() ){
                state = State.valueOf(res.getString("state"));
                begin = DateFormat(res.getTimestamp("begin"));
                car = new Car(res.getString("car"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    /** 向数据库中 写 这个停车位的信息 */
    public void write(){
        try {
            // 数据库中有该车位
            if (db.select("id", String.valueOf(ID), "place").next()) {
                db.updata("id", String.valueOf(ID), "place", "state", "'" + state + "'");
                db.updata("id", String.valueOf(ID), "place", "car", "'" + car.toString() + "'");
                db.updata("id", String.valueOf(ID), "place", "begin", "'" + String.valueOf(DateFormat(begin)) + "'");
            }
            // 数据库中无该车位
            else {
                db.insert("id,state,car,begin",
                        String.valueOf(ID) + "," +
                                "'" + state + "'," +
                                "'" + car.toString() + "'," +
                                "'" + String.valueOf(DateFormat(begin)) + "'", "place");

            }
        } catch (SQLException e) { e.printStackTrace(); }
    }


    /**
     * 设置当前车为空闲
     * @param db 关联的数据库
     * @return 如果occpuy->free，返回价钱
     *         如果disable->free， 返回0
     */
    public boolean free(DataBase db){
        if (this.state == State.disable || this.state == State.free) return false;
        else {
            this.state = State.free;
            this.car = carnull;
            this.begin = timenull;
            this.write();
            return true;
        }
    }


    /**
     * 在当前车位停一辆车
     * @param input 停的车
     * @param db 关联的数据库
     * @return 是否停成功
     */
    public boolean occupy(Car input, DataBase db){
        if (this.state == State.disable || this.state == State.occupy) return false;
        else{
            this.begin = new Date();
            this.car = input;
            this.state = State.occupy;
            this.write();
            return true;
        }
    }


    /**
     * 设置当前车位为不可用
     */
    public void disable(DataBase db){
        this.state = State.disable;
        this.write();
    }


    /**
     * 计算停车收费
     * @return 费用
     */
    public float charge(){
        Date end = new Date();
        // 计算经过多长时间，/1000：ms->s  /60：s->min
        long time = (end.getTime() - begin.getTime()) / 1000 / 60;
        // 计算费用
        return 5*time;
    }


    /** 时间格式的转化 */
    // util.Date -> SQL.Date
    private java.sql.Timestamp DateFormat(java.util.Date date){
        if (date == null) return null;
        return new java.sql.Timestamp(date.getTime());
    }

    // SQL.Date -> util.Date
    public java.util.Date DateFormat(java.sql.Timestamp date) {
        if (null == date) return null;
        return new java.util.Date(date.getTime());
    }
}
