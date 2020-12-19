package View;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.BOTH;

public class windowsToFree extends JFrame{

    public windowsToFree(btnPlace btn){
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
        constraints.gridwidth=1; constraints.gridheight=8;
        layout.setConstraints(left, constraints);
        this.add(left);

        JPanel right = new JPanel();
        right.setBackground(new Color(-12516337));
        constraints.gridx=5; constraints.gridy=1;
        layout.setConstraints(right, constraints);
        this.add(right);

        JPanel top = new JPanel();
        top.setBackground(new Color(0xBA1432));
        constraints.gridx=0; constraints.gridy=0;
        constraints.gridheight=1; constraints.gridwidth=6;
        layout.setConstraints(top, constraints);
        this.add(top);

        JPanel botton = new JPanel();
        botton.setBackground(new Color(0x12DC62));
        constraints.gridx=0; constraints.gridy=9;
        layout.setConstraints(botton, constraints);
        this.add(botton);

        // 称呼
        JLabel owner_label = new JLabel("尊敬的"+btn.getInfo().getCar().getOwner());
        owner_label.setFont(new Font("Dialog", 0, 14));
        constraints.gridx=1; constraints.gridy=1;
        constraints.gridwidth=4; constraints.gridheight=1;
        constraints.insets=new Insets(5, 10, 5, 5);
        layout.setConstraints(owner_label, constraints);
        this.add(owner_label);


        // 费用
        JLabel charge_label = new JLabel("请缴费"+btn.getInfo().charge()+"元");
        charge_label.setFont(new Font("Dialog", 0, 16));
        constraints.gridx=1; constraints.gridy=2;
        constraints.gridwidth=3;
        constraints.insets=new Insets(5, 5, 5, 10);
        layout.setConstraints(charge_label, constraints);
        this.add(charge_label);


        // 显示二维码
        // todo

        // 放下面的按键
        JButton btn_check = new JButton("确定");
        constraints.gridx=2; constraints.gridy=7;
        constraints.gridwidth=2; constraints.gridheight=2;
        constraints.insets=new Insets(5, 5, 5, 10);
        layout.setConstraints(btn_check, constraints);
        this.add(btn_check);
        JButton btn_cancel = new JButton("取消");
        constraints.gridx=3; constraints.gridy=7;
        constraints.insets=new Insets(5, 10, 5, 5);
        layout.setConstraints(btn_cancel, constraints);
        this.add(btn_cancel);

        // 确定按键绑定
        btn_check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.getInfo().free(new DataBase());
                btn.refresh();
                dispose();
            }
        });
        // 取消按键绑定
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
