package com.stuypulse.stuylib.input.keyboard.computer;

import com.stuypulse.stuylib.input.keyboard.computer.NetKeyListener;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is a simple class that
 * opens a Java AWT window, which
 * has a KeyListener that uploads
 * keyboard information to a 
 * network table
 * 
 * @author Sam (sam.belliveau@gmail.com)
 */

public class NetKeyWindow extends JFrame {

    /**
     * Serial Version UID for Frame
     */
    private static final long serialVersionUID = -8251414743098271551L;

    /**
     * NetKeyListener for window
     */
    private NetKeyListener mListener;

    /**
     * Opens Network Keyboard Input Window
     */
    public NetKeyWindow() {
        // Set Title and Open Network Table
        super("Network Keyboard Input");

        // TODO: Get team number from user
        int team = 694;

        // TODO: Get keyboard port from user
        int port = 1735;

        // TODO: Connect NetKeyListener
        mListener = new NetKeyListener(team, port);
        addKeyListener(mListener);

        // TODO: Make is connected label update
        add(new JLabel("Connected: " + mListener.isConnected()));

        // Set Visible
        setVisible(true);
    }
}