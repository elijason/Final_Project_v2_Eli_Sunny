package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvenSplit {
    public EvenSplit() {
        frame();
    }

    public void frame() {
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

        JLabel label = new JLabel("Split A Bill Evenly");
        label.setBounds(150, 0, 410, 100);

        JLabel totalCostLabel = new JLabel("Total Cost of Bill?");
        totalCostLabel.setBounds(150, 0, 410, 200);
        JLabel dollarSign = new JLabel("$");
        dollarSign.setBounds(90, 110, 10, 20);

        JTextField totalCostField = new JTextField(20);
        totalCostField.setBounds(100, 110, 200, 25);

        JLabel tipLabel = new JLabel("Tip Amount? (typically 15-20%)");
        tipLabel.setBounds(120, 0, 410, 300);
        JLabel percentSymbol = new JLabel("%");
        percentSymbol.setBounds(300, 160, 10, 20);

        JTextField tipPercentageField = new JTextField(20);
        tipPercentageField.setBounds(100, 160, 200, 25);

        JLabel peopleNumber = new JLabel("How many people are you splitting among?");
        peopleNumber.setBounds(80, 0, 450, 400);

        JTextField numberPeopleField = new JTextField();
        numberPeopleField.setBounds(100, 210, 200, 25);

        JLabel peopleStringLabel = new JLabel("People");
        peopleStringLabel.setBounds(300, 195, 80, 50);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(100, 250, 200, 25);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try { //checks if it is a valid number
                    String strTotalCost = totalCostField.getText();
                    double totalCost = Double.parseDouble(strTotalCost);
                    String strTipField = tipPercentageField.getText();
                    double tipPercent = Double.parseDouble(strTipField);
                    double tipPercentToDecimal = tipPercent / 100.0;
                    double tipAmount = tipPercentToDecimal * totalCost;
                    double totalCostTipAmount = tipAmount + totalCost;
                    String strNumberOfPeople = numberPeopleField.getText();
                    double numberOfPeople = Double.parseDouble(strNumberOfPeople);
                    double eachPersonPays = Math.round((totalCostTipAmount / numberOfPeople) * 100.0) / 100.0; //rounds to nearest hundredth

                    JOptionPane.showMessageDialog(f.getComponent(0), "Each Person Pays: $ " + eachPersonPays, "Individual Cost", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception E){
                    JOptionPane.showMessageDialog(f.getComponent(0), "Please enter valid numbers in the fields provided.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        p.setLayout(null);
        p.add(label);
        p.add(goBackButton);
        p.add(totalCostLabel);
        p.add(totalCostField);
        p.add(dollarSign);
        p.add(tipPercentageField);
        p.add(tipLabel);
        p.add(percentSymbol);
        p.add(peopleNumber);
        p.add(numberPeopleField);
        p.add(peopleStringLabel);
        p.add(calculateButton);
        f.add(p);
    }
}