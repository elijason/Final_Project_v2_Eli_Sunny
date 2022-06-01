package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IndividualSplit {
   public IndividualSplit(){
       frame();
   }

   public void frame(){
       JFrame f = new JFrame();

       f.setVisible(true);
       f.setSize(400, 400);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JPanel p = new JPanel();
       JButton goBackButton = new JButton("Go Back");
       goBackButton.setBounds(0, 5, 150, 25);
       goBackButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               f.dispose();
               BillSplit originalPage = new BillSplit();
           }
       });

       JLabel individualTitle = new JLabel("Individualized Bills");
       individualTitle.setBounds(150, 0, 410, 100);

       JLabel howManyPeople = new JLabel("How many people spent money and ate?");
       howManyPeople.setBounds(90, 70, 410, 100);

       JTextField numberOfPeople = new JTextField(20);
       numberOfPeople.setBounds(100, 130, 200, 25);

       JButton enterButton = new JButton("Enter");
       enterButton.setBounds(300, 130, 70, 25);

       enterButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   if (e.getSource() == enterButton) {
                       String strNumberOfPeople = numberOfPeople.getText();
                       int peopleNumber = Integer.parseInt(strNumberOfPeople);

                       Double[] values = new Double[peopleNumber];

                       for (int i = 0; i < values.length; i++) {
                           values[i] = Double.parseDouble(JOptionPane.showInputDialog("Person " + (i + 1) + " spent: "));
                       }

                       double sum = 0;
                       for (int i = 0; i < values.length; i++) {
                           sum += values[i];
                       }
                       JOptionPane.showMessageDialog(null, "Your total bill comes out to: $" + sum, "Each Individual Cost", JOptionPane.INFORMATION_MESSAGE);

                   }
               } catch (Exception E) {
                   JOptionPane.showMessageDialog(f.getComponent(0), "Please enter valid numbers in the fields provided.", "Error", JOptionPane.INFORMATION_MESSAGE);
               }
           }
       });
       p.setLayout(null);
       p.add(goBackButton);
       p.add(individualTitle);
       p.add(howManyPeople);
       p.add(numberOfPeople);
       p.add(enterButton);
       f.add(p);
   }
}