package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Final Project Eli and Sunny"); //hello
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Bill");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to split the bill evenly or have an individualized bill? (equal / not equal)");
        String equalReponse = sc.nextLine();
        if (Objects.equals(equalReponse, "equal")) {
            equalSplit(sc);
        } else if (Objects.equals(equalReponse, "not equal")) {
            individualizedBill(sc);
        }

    }

    public static void equalSplit(Scanner sc) {
        char choice;
        do {
            System.out.println("Total cost of bill?");
            double cost = sc.nextDouble();
            System.out.println("Tip Amount? (typically 15-20%)");
            double tipPercent = sc.nextInt();
            double tipPercentToDecimal = tipPercent / 100.0;
            double tipAmount = tipPercentToDecimal * cost;
            double totalBill = tipAmount + cost;
            System.out.println("Your total bill comes out to: $ " + totalBill);
            System.out.println("How many people are you splitting among?");
            double numberPeople = sc.nextInt();

            double pricePerPerson = totalBill / numberPeople;
            System.out.println("Total cost per person is: $" + Math.round(pricePerPerson * 100) / 100.0); //rounds to the nearest hundredth

            System.out.println("Do you want to calculate another bill? (Y/N)");
            choice = sc.next().charAt(0); //reads the letter to see if user input is 'y'
        } while ((choice == 'y' || (choice == 'Y')));
        if (choice != 'Y' || choice != 'y') {
            System.exit(0);
        }
    }

    public static void individualizedBill(Scanner sc) {
        char choiceTwo;
        do {
            System.out.println("How many people spent money and ate?");
            int numberPeople = sc.nextInt();
            int[] peopleArray = new int[numberPeople];
            double sum = 0;
            for (int i = 1; i <= peopleArray.length; i++) {
                System.out.println("Person " + i + " spent: ");
                double individualSpend = sc.nextDouble();
                sum += individualSpend;
                System.out.println("Person " + i + " spent: " + individualSpend);
            }
            System.out.println("The total bill is: " + sum);
            System.out.println("Do you want to calculate another bill? Y/N");
            choiceTwo = sc.next().charAt(0);
        } while ((choiceTwo == 'y' || (choiceTwo == 'Y')));
        if (choiceTwo != 'Y' || choiceTwo != 'y') {
            System.exit(0);
        }
    }
}