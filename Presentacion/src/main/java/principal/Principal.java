/*
 * Principal.java
 */
package principal;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import forms.LoginForm;
import java.util.Collections;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FlatLaf lookAndFeel = new FlatLightLaf();
            UIManager.setLookAndFeel(lookAndFeel);

            FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("RootPane.background", "#FF661C"));
            
            FlatLaf.setup(lookAndFeel);
            new LoginForm().setVisible(true);
        } catch (UnsupportedLookAndFeelException e) {
            
        }

    }

    
}
