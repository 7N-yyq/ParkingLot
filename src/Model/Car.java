package Model;

public class Car {

    private String owner;
    private String phone;



    /**
     * 新建一个车的信息
     * @param owner  车主名字（称呼）
     * @param phone  联系方式
     */
    public Car(String owner, String phone) {
        this.owner = owner;
        this.phone = phone;
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

}
