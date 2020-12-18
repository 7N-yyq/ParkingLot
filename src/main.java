import Model.ParkingLot;
import View.GUI;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] argv){

        GUI a = new GUI(new ParkingLot(16), 4,4);
        a.pack();
        a.setVisible(true);
    }
}
