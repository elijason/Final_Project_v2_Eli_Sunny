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

       p.add(goBackButton);
       f.add(p);
   }
}
