package com.company;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame {
    public Home() {
        frame();
    }

    public void frame() {

        JFrame f = new JFrame("Bill Splitter");

        f.setVisible(true);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        JButton b1 = new JButton("Calculate A Bill");
        b1.setBounds(50, 130, 300, 25);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    f.dispose();
                    BillSplit billSplitWindow = new BillSplit();
                }
            }
        });

        JButton b2 = new JButton("Exit Application");
        b2.setBounds(50, 160, 300, 25);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    System.exit(0);
                }
            }
        });

        JLabel labelOne = new JLabel("Welcome to the Bill Splitter!");
        labelOne.setBounds(130, 5, 300, 200);

        JLabel backGroundColor = new JLabel("Set a Background Color");
        backGroundColor.setBounds(130, 270, 180, 25);

        JButton blue = new JButton("Blue");
        blue.setBounds(20, 300, 70, 25);
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setBackground(Color.BLUE);
                labelOne.setForeground(Color.WHITE);
                backGroundColor.setForeground(Color.WHITE);
                f.setBackground(Color.BLUE);
            }
        });

        JButton white = new JButton("White");
        white.setBounds(110, 300, 70, 25);
        white.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setBackground(Color.WHITE);
                labelOne.setForeground(Color.BLACK);
                backGroundColor.setForeground(Color.BLACK);
                f.setBackground(Color.WHITE);
            }
        });

        JButton black = new JButton("Black");
        black.setBounds(200, 300, 70, 25);
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setBackground(Color.BLACK);
                labelOne.setForeground(Color.WHITE);
                backGroundColor.setForeground(Color.WHITE);
                f.setBackground(Color.BLACK);
            }
        });

        JButton gray = new JButton("Gray");
        gray.setBounds(290, 300, 70, 25);
        gray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setBackground(Color.lightGray);
                labelOne.setForeground(Color.WHITE);
                backGroundColor.setForeground(Color.WHITE);
                f.setBackground(Color.lightGray);
            }
        });



        p.setLayout(null);
        p.add(b1);
        p.add(b2);
        p.add(blue);
        p.add(white);
        p.add(black);
        p.add(gray);
        p.add(labelOne);
        p.add(backGroundColor);
        f.add(p);
    }
}