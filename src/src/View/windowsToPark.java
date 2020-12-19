package View;

import DB.DataBase;
import Model.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.BOTH;

public class windowsToPark extends JDialog {


    public windowsToPark(btnPlace btn){
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
        constraints.gridwidth=1; constraints.gridheight=6;
        layout.setConstraints(left, constraints);
        this.add(left);

        JPanel right = new JPanel();
        right.setBackground(new Color(-12516337));
        constraints.gridx=7; constraints.gridy=1;
        layout.setConstraints(right, constraints);
        this.add(right);

        JPanel top = new JPanel();
        top.setBackground(new Color(0xBA1432));
        constraints.gridx=0; constraints.gridy=0;
        constraints.gridheight=1; constraints.gridwidth=8;
        layout.setConstraints(top, constraints);
        this.add(top);

        JPanel botton = new JPanel();
        botton.setBackground(new Color(0x12DC62));
        constraints.gridx=0; constraints.gridy=7;
        layout.setConstraints(botton, constraints);
        this.add(botton);

        // 放左侧的两个label
        JLabel owner_label = new JLabel("您的称呼");
        owner_label.setFont(new Font("Dialog", 0, 14));
        constraints.gridx=1; constraints.gridy=1;
        constraints.gridwidth=2; constraints.gridheight=2;
        constraints.insets=new Insets(5, 10, 5, 5);
        layout.setConstraints(owner_label, constraints);
        this.add(owner_label);
        JLabel phone_label = new JLabel("您的联系方式");
        phone_label.setFont(new Font("Dialog", 0, 14));
        constraints.gridx=1; constraints.gridy=3;
        constraints.insets=new Insets(5, 10, 5, 5);
        layout.setConstraints(phone_label, constraints);
        this.add(phone_label);

        // 放右侧的两个textfield
        JTextField owner_textfield = new JTextField("");
        owner_textfield.setFont(new Font("Dialog", 0, 16));
        constraints.gridx=4; constraints.gridy=1;
        constraints.gridwidth=3;
        constraints.insets=new Insets(5, 5, 5, 10);
        layout.setConstraints(owner_textfield, constraints);
        this.add(owner_textfield);
        JTextField phone_textfield = new JTextField("");
        phone_textfield.setFont(new Font("Dialog", 0, 16));
        constraints.gridx=4; constraints.gridy=3;
        constraints.gridwidth=3;
        constraints.insets=new Insets(5, 5, 5, 10);
        layout.setConstraints(phone_textfield, constraints);
        this.add(phone_textfield);

        // 放下面的按键
        JButton btn_check = new JButton("确定");
        constraints.gridx=1; constraints.gridy=5;
        constraints.gridwidth=3;
        constraints.insets=new Insets(5, 5, 5, 10);
        layout.setConstraints(btn_check, constraints);
        this.add(btn_check);
        JButton btn_cancel = new JButton("取消");
        constraints.gridx=4; constraints.gridy=5;
        constraints.insets=new Insets(5, 10, 5, 5);
        layout.setConstraints(btn_cancel, constraints);
        this.add(btn_cancel);

        // 确认按钮绑监听
        btn_check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (owner_textfield.getText().equals("") || phone_textfield.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "请完善信息", "警告", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (btn.getInfo().occupy(new Car(owner_textfield.getText()+":"+phone_textfield.getText()), new DataBase())){
                        btn.refresh();
                        dispose();
                    }
                    else JOptionPane.showMessageDialog(null, "添加出错", "警告", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // 取消按钮绑监听
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public static void main(String[] argv){
//        windowsToPark a = new windowsToPark(null);
//        a.setSize(400, 300);
//        a.setVisible(true);
    }
}
