//https://www.pixilart.com

package snoose;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Snoose implements KeyListener {
    static final int MENU = 0;
    static final int GAME = 1;
    static final int END = 2;
    static final int NUM_STATES = 3;
    
    private int gameState = MENU;
    JFrame frame;

    MenuScreen menu;
    GameScreen game;
    EndScreen end;
    
    public static void main(String[] args) throws Exception {
        new Snoose().startGame();
    }

    private void startGame() {
        frame = new JFrame( "Snoose" );
        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.addKeyListener( this );
        
        menu = new MenuScreen( frame );
        game = new GameScreen( frame );
        end  = new EndScreen( frame );
        
        menu.drawMenu();
    }
    
    private void selectScreen() {
        
        if( gameState == MENU ) {
            menu.drawMenu();
        } else if( gameState == GAME ) {
            game.drawGame();
        } else if( gameState == END ) {
            end.drawEnd();
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if( gameState == MENU ) {
            menu.removeScreen();
        } else if( gameState == GAME ) {
            game.removeScreen();
        } else if( gameState == END ) {
            end.removeScreen();
        }
        
        gameState = ( gameState + 1 ) % NUM_STATES;
        selectScreen();
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

}
