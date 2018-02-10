package com.techpalace.calculator.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import static com.techpalace.calculator.view.CalculatorView.view;

/**
 * Created by momen on 2/8/2018.
 */
public class CalcController implements ActionListener {
    private static CalcController instance;
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        view.setText(view.getText() + " " + b.getText());
    }
    private CalcController(){

    }
    public static CalcController getInstance() {
        if(instance == null){
            instance = new CalcController();
        }
        return instance;
    }
}
