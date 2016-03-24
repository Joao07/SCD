
package x9;

import gui.MENUGUI;
import javax.swing.JFrame;

public class X9 {
    
    public static void main(String[] args) {
        MENUGUI menugui = new MENUGUI();
        menugui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menugui.setVisible(true);
    }
    
}
