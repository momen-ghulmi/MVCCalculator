package com.techpalace.calculator.controller;

import com.techpalace.calculator.model.calcModel;
import com.techpalace.calculator.util.InToPost;
import com.techpalace.calculator.util.PostfixCalculator;
import com.techpalace.calculator.view.CalculatorView;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import static com.techpalace.calculator.view.CalculatorView.add;
import static com.techpalace.calculator.view.CalculatorView.view;

/**
 * Created by momen on 2/8/2018.
 */
public class CalcController implements ActionListener {
    private static CalcController instance;
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if(b == CalculatorView.reset){
            CalculatorView.view.setText("");
        }
        else if(b == CalculatorView.equal){
            String equ = view.getText();
            InToPost trans = new InToPost(view.getText());
            String post = trans.doTrans();
            PostfixCalculator calc = new PostfixCalculator();
            calc.setExpression(post);
            calc.evalPostfix();
            calcModel.setRes(((int) calc.getResult()));

            view.setText(view.getText() + " " + "=" + " " + calcModel.getRes());
            calcModel.setComputedFlag(true);
            //Logger.getAnonymousLogger().info(calc.getResult() + "");
            //Logger.getAnonymousLogger().info(post);
        }
        else {
            String[] oper = {"+", "-", "*", "/","%"};
            ArrayList<String> operators = new ArrayList<>(Arrays.asList(oper));
            if(calcModel.isComputedFlag()){
                view.setText(calcModel.getRes() + "");
                calcModel.setComputedFlag(false);
            }
            if (operators.contains(b.getText())) {
                view.setText(view.getText() + " " + b.getText() + " ");
            }
            else {
                view.setText(view.getText() + "" + b.getText());
            }
        }
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
