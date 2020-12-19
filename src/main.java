import DB.DataBase;
import Model.ParkingLot;
import View.windowsToAll;

public class main {

    public static void main(String[] argv){

        windowsToAll a = new windowsToAll(new ParkingLot(15), 4,4);
        a.setLocation(300, 300);
        a.pack();
        a.setVisible(true);
    }

}
