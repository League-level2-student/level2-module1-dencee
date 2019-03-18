package snoose;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuScreen extends Screen {
    JLabel label;

    public MenuScreen(JFrame frame) {
        super( frame );
        
        backgroundColor = new Color( 255, 0, 25 );
        label = new JLabel();
    }

    public void drawMenu() {
        frame.add( panel );
        panel.add( label );
        panel.setBackground( backgroundColor );
        label.setFont( new Font( "Serif", Font.PLAIN, 40 ) );
        label.setText( "MENU" );
        panel.repaint();
        frame.pack();
    }

}
