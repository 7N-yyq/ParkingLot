package Model;


import java.util.Date;

public class Place {

    private int ID;
    private State state;
    private Date begin = null;
    private Car car = null;



    /**
     * 初始化一个停车位，初始状态为 空闲
     * @param ID 车位ID
     */
    public Place(int ID) {
        this.ID = ID;
        this.state = State.free;
    }


    /**
     * 得到这个车位的状态
     * @return
     */
    public State getState() { return this.state; }


    /**
     * 设置当前车为空闲
     * @return 如果occpuy->free，返回价钱
     *         如果disable->free， 返回0
     */
    public float free(){
        if (this.state == State.disable || this.state == State.free) return 0;
        else {
            this.car = null;
            this.state = State.free;
            this.begin = null;
            return charge(begin, new Date());
        }
    }


    /**
     * 在当前车位停一辆车
     * @param input 停的车
     * @return 是否停成功
     */
    public boolean occupy(Car input){
        if (this.state == State.disable || this.state == State.occupy) return false;
        else{
            this.begin = new Date();
            this.car = input;
            this.state = State.occupy;
            return true;
        }
    }


    /**
     * 设置当前车位为不可用
     */
    public void disable(){
        this.state = State.disable;
    }


    /**
     * 计算停车收费
     * @param begin 开始时间
     * @param end 结束时间
     * @return 费用
     */
    private float charge(Date begin, Date end){
        // 计算经过多长时间，/1000：ms->s  /60：s->min
//        long time = (end.getTime() - begin.getTime()) / 1000 / 60;
//        // 计算费用
//        float res = 5*time;
//        return res;
        return 0;
    }
}
