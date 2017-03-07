package com.example.jellio.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private Calculator calculator;

    private TextView txtInput, txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = (TextView) findViewById(R.id.txtInput);
        txtOutput = (TextView) findViewById(R.id.txtOutput);
        
        this.calculator = new Calculator(txtOutput);

        initializeButtons();
    }
    
    private void updateInput(String s) {
        txtInput.setText(s);
    }
    
    private void initializeButtons() {
        findViewById(R.id.btnOne).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.ONE);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnTwo).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.TWO);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnThree).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.THREE);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnFour).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.FOUR);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnFive).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.FIVE);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnSix).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.SIX);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnSeven).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.SEVEN);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnEight).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.EIGHT);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnNine).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.NINE);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnZero).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.ZERO);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnPeriod).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.PERIOD);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.ADD);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnSubtract).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.SUBTRACT);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnMultiply).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.MULTIPLY);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnDivide).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.DIVIDE);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnEquals).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.EQUALS);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnDEL).setOnClickListener(v -> {
            calculator.addCharacter(Calculator.CALC_BUTTON.DELETE);
            updateInput(calculator.getInput());
        });
        findViewById(R.id.btnDEL).setOnLongClickListener(v -> {
            calculator.reset();
            txtInput.setText("");
            return true;
        });
    }
    
}
