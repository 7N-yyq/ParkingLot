package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DataBase;

public class ParkingLot {

    private List<Place> places = null;
    private DataBase db;


    /**
     * 用空的停车位初始化停车场
     * @param n 有几个车位
     */
    public ParkingLot(int n) {
        places = new ArrayList<>();
        this.db = new DataBase();
        for (int i = 0; i < n; i++){
            places.add(new Place(i, db));
        }
        write();
    }

    /**
     * 从数据库初始化停车位
     */
    public ParkingLot(){
        this.db = new DataBase();
        places = new ArrayList<>();
        ResultSet res = db.select(null, null, "place");
        try{
            while(res.next()){
                places.add(new Place(res, db));
            }
        }catch (SQLException e){ }
    }


    /** 从数据库中从新读车位数据 */
    public void read(){ for (Place temp : places) temp.read(); }
    /** 将车位写到数据库中 */
    public void write(){ for (Place temp : places) temp.write();}


    /**
     * 获取每一个停车位信息
     * @return 停车位信息
     */
    public List<Place> getPlaces() { return places; }


}
