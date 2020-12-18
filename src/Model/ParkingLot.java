package Model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Place> places = null;



    /**
     * 初始化停车场，默认为空闲
     * @param n 有几个车位
     */
    public ParkingLot(int n) {
        places = new ArrayList<>();
        for (int i = 0; i < n; i++){
            places.add(new Place(i));
        }
    }


    /**
     * 用车位信息初始化停车场
     * @param places 车位信息
     */
    public ParkingLot(List<Place> places){
        this.places.addAll(places);
    }


    /**
     * 获取每一个停车位信息
     * @return 停车位信息
     */
    public List<Place> getPlaces() {
        return places;
    }


}
