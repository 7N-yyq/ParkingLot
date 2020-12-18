import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Demo20 extends JFrame implements KeyListener{

    private static final long serialVersionUID = 1L;

    public Demo20(){
        this.setTitle("键盘事件处理");
        this.setSize(300, 200);
        this.setLocationRelativeTo(this);// 窗口居中
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭动作处理
        this.addKeyListener(this);// 添加注册键盘事件监听器
        this.setLayout(new FlowLayout(FlowLayout.LEFT,45,45));

        JButton buttonPop = new JButton("Pop out");
        this.add(buttonPop);

        buttonPop.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                System.out.println("Pop up!");
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });

        JButton buttonPrint = new JButton("Print");
        this.add(buttonPrint);

        buttonPrint.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                System.out.println("Print!");
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }

    @Override
    public void keyPressed(KeyEvent arg0){// 敲击
    }

    @Override
    public void keyReleased(KeyEvent arg0) {// 按下
        if (arg0.getKeyCode() == 114) {// 114 F3对应的编码
            System.out.print(123);
        }

        if (arg0.getKeyCode() == 80) {// 80 P 对应的编码
            System.out.println("Key P is pressed!");
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {// 释放
    }

    public static void main(String[] args) {
        new Demo20();
    }

    public static void print() {
        System.out.println("Running!");
    }
}
