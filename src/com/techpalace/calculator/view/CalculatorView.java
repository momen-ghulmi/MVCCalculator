package com.techpalace.calculator.view;

/**
 * Created by momen on 2/8/2018.
 */
import com.techpalace.calculator.controller.CalcController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public  class CalculatorView extends JFrame {
    public static ArrayList<JButton> digits;
    public static JButton add,subtract,multiply,divide,equal,reset;
    public static JLabel view;

    CalculatorView() {
        super("Calculator");
        this.getContentPane().setLayout(new GridLayout(2, 1));
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(1,2));
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,3));
        view = new JLabel();
        view.setBackground(Color.green);
        this.add(view);
        digits = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            JButton temp = new JButton("" + i);
            temp.addActionListener(CalcController.getInstance());
            temp.setSize(40,40);
            digits.add(temp);
            p.add(temp);
        }
        digits.add(new JButton("0"));
        digits.get(9).addActionListener(CalcController.getInstance());
        digits.get(9).setSize(20,20);
        p.add(new Label());
        p.add(digits.get(9));
        p.add(new Label());
        main.add(p);

        JPanel pa = new JPanel();
        pa.setLayout(new GridLayout(3,2));
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        equal = new JButton("=");
        reset = new JButton("reset");
        add.addActionListener(CalcController.getInstance());
        subtract.addActionListener(CalcController.getInstance());
        multiply.addActionListener(CalcController.getInstance());
        divide.addActionListener(CalcController.getInstance());
        equal.addActionListener(CalcController.getInstance());
        reset.addActionListener(CalcController.getInstance());
        pa.add(add);
        pa.add(subtract);
        pa.add(multiply);
        pa.add(divide);
        pa.add(equal);
        pa.add(reset);
        main.add(pa);
        this.add(main);
        this.setSize(new Dimension(300,300));
        this.setVisible(true);
        //this.pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

    }
    public static void main(String[] args){
        new CalculatorView();
    }
}
