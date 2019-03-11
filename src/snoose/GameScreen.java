package snoose;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameScreen extends Screen implements ActionListener {
    JLabel hangmanImage;
    JTextField field;
    JButton guess;
    
    public GameScreen( JFrame frame ) {
        super( frame );
        
        backgroundColor = new Color(255, 125, 25);
        field = new JTextField( 20 );
        guess = new JButton( "Guess" );
    }
    
    public void drawGame() {
        panel.setBackground( backgroundColor );
        frame.add( panel );
        
        hangmanImage = createLabelImage( "Snoose5.png" );
        c.gridx = 0;
        c.gridy = 0;
        panel.add( hangmanImage, c );
        
        c.gridx = 0;
        c.gridy = 1;
        panel.add( field, c );
        
        c.gridx = 0;
        c.gridy = 2;
        panel.add( guess, c );
        
        guess.addActionListener( this );
        
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
