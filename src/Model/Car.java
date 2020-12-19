package Model;

public class Car {

    private String owner;
    private String phone;


    /**
     * 新建一个车的信息
     * @param info  车主称呼+联系方式，格式：name:phone
     */
    public Car(String info) {
        String[] temp = info.split(":");
        this.owner = temp[0];
        this.phone = temp[1];
    }


    /**
     * 获取车主姓名
     * @return  车主姓名
     */
    public String getOwner() {
        return owner;
    }


    /**
     * 获取车主联系方式
     * @return  联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 转化形式：name:phone
     * @return 转化结果
     */
    public String toString(){ return owner+":"+phone; }



}
