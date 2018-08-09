package com.robsonribeiroft;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.robsonribeiroft.GameController.*;
import static com.robsonribeiroft.GameController.pointOnPosition;

public class Main {
    private static JButton btnRedOne;
    private static JButton btnBlueTwo;
    private static JButton btnBlueOne;
    private static JButton btnRedTwo;

    /*
     * Map[0,0] = [20, 40]
     * Map[0,1] = [408, 40]
     * Map[1,0] = [20, 425]
     * Map[1,1] = [410, 430]
     * Map[-1,-1] = [215, 230]*/


    public static void main(String[] args) {
        btnRedOne = new JButton();
        btnRedTwo = new JButton();
        btnBlueOne = new JButton();
        btnBlueTwo = new JButton();

        btnRedOne.setBackground(Color.RED);
        btnRedOne.setText("1");
        btnRedOne.addActionListener(e -> btnRedOne.setLocation(pointOnPosition(LOW_LEFT)));

        btnRedTwo.setBackground(Color.RED);
        btnRedTwo.setText("2");
        btnBlueOne.setBackground(Color.BLUE);
        btnBlueOne.setText("1");
        btnBlueTwo.setBackground(Color.BLUE);
        btnBlueTwo.setText("2");

        JPanel panel = new JPanel();
        panel.add(btnRedOne);
        panel.add(btnRedTwo);
        panel.add(btnBlueOne);
        panel.add(btnBlueTwo);
        panel.setOpaque(false);

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("C:\\Users\\robso\\Desktop\\PPD\\res\\background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        JFrame frame = new JFrame("PONG-HAU-KI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (myPicture!=null){
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.add(panel);
            frame.setContentPane(picLabel);
        }
        frame.setLayout(new BorderLayout());
        frame.add(panel);

        //Setting menu
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu newGameMenu = new JMenu("New Game");
        menuBar.add(newGameMenu);
        newGameMenu.addItemListener(e -> setPiecesOnPosition(btnRedOne, btnRedTwo, btnBlueOne, btnBlueTwo));

        frame.pack();
        frame.setVisible(true);
    }




}
