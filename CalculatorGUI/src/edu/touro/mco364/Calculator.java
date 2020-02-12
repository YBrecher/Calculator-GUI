package edu.touro.mco364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JLabel output = new JLabel("Output");
    private JTextField input1 = new JTextField(5), input2 = new JTextField(5);
    private JButton plus = new JButton("+"),
            subtract = new JButton("-"),
            multiply = new JButton("*"),
            divide = new JButton("/");

    public Calculator() {
        setTitle("Calculator");
        this.setSize(500, 400);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(input1);
        add(input2);
        add(plus);
        add(subtract);
        add(multiply);
        add(divide);
        add(output);

        this.setVisible(true);

        plus.addActionListener(new ButtonPressedListener());
        subtract.addActionListener(new ButtonPressedListener());
        multiply.addActionListener(new ButtonPressedListener());
        divide.addActionListener(new ButtonPressedListener());
    }

    class ButtonPressedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isNumeric(input1.getText()) || !isNumeric(input2.getText())) { //check that input is numeric and not empty
                output.setText("0");
            } else if (e.getSource() == plus) {
                output.setText(String.valueOf((Integer.parseInt(input1.getText()) + Integer.parseInt(input2.getText()))));
            } else if (e.getSource() == subtract) {
                output.setText(String.valueOf(Integer.parseInt(input1.getText()) - Integer.parseInt(input2.getText())));
            } else if (e.getSource() == multiply) {
                output.setText(String.valueOf(Integer.parseInt(input1.getText()) * Integer.parseInt(input2.getText())));
            } else if (e.getSource() == divide) {
                output.setText(String.valueOf(Float.parseFloat(input1.getText()) / Float.parseFloat(input2.getText())));
            }
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
             Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}




