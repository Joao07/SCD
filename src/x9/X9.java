
package x9;

import gui.MenuGUI;
import javax.swing.JFrame;

public class X9 {
    
    public static void main(String[] args) {
        MenuGUI menugui = new MenuGUI();
        menugui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menugui.setVisible(true);
    }
    
}
