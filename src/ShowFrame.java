import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ShowFrame extends JFrame {
    public void init() {
        ShowFrame showFrame = new ShowFrame();//首先必须创建好窗体
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
//然后得到当前键盘事件的管理器
        manager.addKeyEventPostProcessor((KeyEventPostProcessor) this.getMyKeyEventHandler());
//然后为管理器添加一个新的键盘事件监听者。
    }


    public KeyEventPostProcessor getMyKeyEventHandler() {
        return new KeyEventPostProcessor() {
            @Override
            public boolean postProcessKeyEvent(KeyEvent e){
                if (e.getKeyCode() == 113){
                    System.out.println("123");
                }
                return false;
            }
        };
    }

    public static void main(String[] argv){
        ShowFrame a= new ShowFrame();
        a.setVisible(true);
    }
}