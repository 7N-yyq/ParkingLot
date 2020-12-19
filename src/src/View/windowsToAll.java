package View;

import Model.*;
import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.BOTH;

public class windowsToAll extends JFrame{

    /**
     *
     * @param parkingLot
     * @param row
     * @param col
     */
    public windowsToAll(ParkingLot parkingLot, int row, int col){
        // 设置布局
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill= BOTH;

        // 设置边界
        constraints.weightx=10; constraints.weighty=10;
        JPanel left = new JPanel();
        left.setBackground(new Color(-16563953));
        constraints.gridx=0; constraints.gridy=1;
        constraints.gridwidth=1; constraints.gridheight=row;
        layout.setConstraints(left, constraints);
        this.add(left);

        JPanel right = new JPanel();
        right.setBackground(new Color(-12516337));
        constraints.gridx=col+1; constraints.gridy=1;
        layout.setConstraints(right, constraints);
        this.add(right);

        JPanel top = new JPanel();
        top.setBackground(new Color(0xBA1432));
        constraints.gridx=0; constraints.gridy=0;
        constraints.gridheight=1; constraints.gridwidth=2+col;
        layout.setConstraints(top, constraints);
        this.add(top);

        JPanel botton = new JPanel();
        botton.setBackground(new Color(0x12DC62));
        constraints.gridx=0; constraints.gridy=1+row;
        layout.setConstraints(botton, constraints);
        this.add(botton);


        // 将停车位添加到布局中
        constraints.weightx=100; constraints.weighty=100;
        constraints.gridheight=1; constraints.gridwidth=1;
        boolean flag = true;
        int id = 0;
        for (int i=0, k=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (!flag) break;
                if (j%2==0) { constraints.insets=new Insets(5,5,5,25); }
                else { constraints.insets=new Insets(5,25,5,5);}
                constraints.gridx = j+1; constraints.gridy = i+1;
                id = row*i+j;
                if (id == parkingLot.getPlaces().size()-1) flag = false;  // 车位放不满
                btnPlace btn = new btnPlace(parkingLot.getPlaces().get(id));
                layout.setConstraints(btn, constraints);
                this.add(btn);
            }
        }
    }


}
