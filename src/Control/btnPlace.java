package Control;

import Model.Place;
import Model.State;
import View.windowsToFree;
import View.windowsToPark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnPlace extends JButton {

    private Place info;  // 这个停车位的信息


    public btnPlace(Place place){
        this.info = place;
        this.refresh();
        this.setPreferredSize(new Dimension(300,100));  // 设置按钮大小
        this.setFocusPainted(false);

        // 设置监听器
        btnPlace btn = this;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (info.getState().equals(State.free)) {
                    windowsToPark win = new windowsToPark(btn);
                    win.setLocationRelativeTo(null);
                    win.pack();
                    win.setVisible(true);
                }
                else if (info.getState().equals(State.occupy)) {
                    windowsToFree win = new windowsToFree(btn);
                    win.setLocationRelativeTo(null);
                    win.pack();
                    win.setVisible(true);
                }

            }
        });
    }


    /** get方法 */
    public Place getInfo() { return info; }


    /**
     * 重新现在展示
     */
    public void refresh(){
        this.setText(this.info.getState().toString());
        this.setColor();
    }



    /**
     * 设置这个按钮的颜色
     */
    private void setColor(){
        if (info.getState().equals(State.disable)){  this.setBackground(new Color(0x656665)); }
        if (info.getState().equals(State.occupy)){  this.setBackground(new Color(0xB40C2F)); }
        if (info.getState().equals(State.free)){  this.setBackground(new Color(0x73FD7F)); }
    }
}
