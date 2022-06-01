package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillSplit extends JFrame {
    public BillSplit() {
        frame();
    }

    public void frame() {
        JFrame f = new JFrame("Bill Calculator");

        f.setVisible(true);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(280, 5, 100, 25);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == homeButton) {
                    f.dispose();
                    Home home = new Home();
                }
            }
        });

        JButton splitEvenlyButton = new JButton("Split Evenly");
        splitEvenlyButton.setBounds(70, 100, 250, 25);
        splitEvenlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                EvenSplit page = new EvenSplit();
            }
        });

        JButton individualPay = new JButton("Everyone Pays For Themselves");
        individualPay.setBounds(70, 140, 250, 25);
        individualPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                IndividualSplit page = new IndividualSplit();
            }
        });

        JLabel labelOne = new JLabel("Split the bill evenly or everyone pays for themselves?");
        labelOne.setLayout(null);
        labelOne.setBounds(40, 0, 400, 100);

        p.setLayout(null);
        p.add(homeButton);
        p.add(splitEvenlyButton);
        p.add(individualPay);
        p.add(labelOne);
        f.add(p);
    }
}