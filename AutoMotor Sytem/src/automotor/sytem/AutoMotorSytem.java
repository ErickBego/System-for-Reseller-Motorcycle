/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automotor.sytem;

import automotor.sytem.views.Login;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author jcodogno
 */
public class AutoMotorSytem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){        
        }
        new Login().setVisible(true);
    }
    
}
