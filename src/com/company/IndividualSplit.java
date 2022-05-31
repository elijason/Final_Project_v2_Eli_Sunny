package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
       goBackButton.setBounds(0, 0, 150, 25);
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
                       int x = 100; //variables declared to set base coordinates for label and textfield
                       int yLabel = 100;
                       int yTextField = 130;
                       String strNumberOfPeople = numberOfPeople.getText();
                       int peopleNumber = Integer.parseInt(strNumberOfPeople);
                       int[] peopleNumberArray = new int[peopleNumber];
                       for (int i = 0; i < peopleNumberArray.length; i++) {
                           JLabel personI = new JLabel("Person " + (i + 1) + " spent: $");
                           personI.setBounds(x, yLabel += 50, 200, 25); //+= is used as the for loop iterates to set the labels and textfields in an orderly hierarchy of positions
                           JTextField individualAmount = new JTextField();
                           individualAmount.setBounds(x, yTextField += 50, 200, 25);
                           p.add(personI);
                           p.add(individualAmount);

                           JButton calculateButton = new JButton("Calculate Bill");
                           calculateButton.setBounds(100, 70, 200, 25);
                           calculateButton.addActionListener(new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent e) {
                                   try {
                                       double sum = 0;
                                       for (int j = 0; j < peopleNumberArray.length; j++) { //for loop takes the value of the textfields and adds them together to get the final bill cost
                                           String strIndividualExpenditures = individualAmount.getText();
                                           double IndividualExpenditures = Double.parseDouble(strIndividualExpenditures);
                                           sum += IndividualExpenditures;
                                       }
                                       JOptionPane.showMessageDialog(f.getComponent(0), "Total Bill is: $ " + sum, "Total Bill", JOptionPane.INFORMATION_MESSAGE);
                                   } catch (Exception E){
                                       JOptionPane.showMessageDialog(f.getComponent(0), "Please enter valid numbers in the fields provided.", "Error", JOptionPane.INFORMATION_MESSAGE);
                                   }
                               }
                           });
                           p.add(calculateButton);
                       }
                   }
               } catch (Exception E){
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