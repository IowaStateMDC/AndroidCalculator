package com.example.jellio.calculator;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Joseph Elliott on 3/6/2017.
 */

public class Calculator {

    public enum CALC_BUTTON {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO,
        PERIOD, EQUALS, DELETE, DIVIDE, MULTIPLY, SUBTRACT, ADD
    }

    private List<String> vals;
    private TextView display;
    
    public Calculator(TextView display) {
        this.vals = new ArrayList<>();
        this.display = display;
    }

    public void reset() {
        vals = new ArrayList<>();
        display.setText("");
    }

    public String getInput() {
        StringBuilder builder = new StringBuilder();
        for (String s : vals) {
            builder.append(s);
        }
        return builder.toString();
    }

    public boolean addCharacter(CALC_BUTTON button) {

        boolean result = true;

        switch(button) {
            case ONE:
                result = addDigit("1");
                break;
            case TWO:
                result = addDigit("2");
                break;
            case THREE:
                result = addDigit("3");
                break;
            case FOUR:
                result = addDigit("4");
                break;
            case FIVE:
                result = addDigit("5");
                break;
            case SIX:
                result = addDigit("6");
                break;
            case SEVEN:
                result = addDigit("7");
                break;
            case EIGHT:
                result = addDigit("8");
                break;
            case NINE:
                result = addDigit("9");
                break;
            case ZERO:
                result = addDigit("0");
                break;
            case PERIOD:
                result = addDigit(".");
                break;
            case EQUALS:
                if (vals.size() > 0 && !isOperator(vals.get(vals.size() - 1))) {
                    double val = evaluate(vals.size());
                    vals = new ArrayList<>();
                    vals.add("" + val);
                    display.setText("");
                }
                break;
            case DELETE:
                delete();
                break;
            case DIVIDE:
                result = addOperator("/");
                break;
            case MULTIPLY:
                result = addOperator("*");
                break;
            case SUBTRACT:
                result = addOperator("-");
                break;
            case ADD:
                result = addOperator("+");
                break;
        }

        if (vals.size() > 2) {

            int cutoff = vals.size();

            if (isOperator(vals.get(cutoff - 1))) {
                cutoff--;
            }

            double val = evaluate(cutoff);
            if (val == (long) val) {
                display.setText(String.format(Locale.ENGLISH, "%d", (long) val));
            } else {
                display.setText(String.format(Locale.ENGLISH, "%s", val));
            }

        } else {

            display.setText("");

        }

        return result;
    }

    private double evaluate(int cutoff) {
        List<String> copy = new ArrayList<>();

        for (int i = 0; i < cutoff; i++) {
            copy.add(vals.get(i));
        }

        int index;
        while ((index = copy.indexOf("*")) != -1) {
            double left = Double.parseDouble(copy.remove(index - 1));
            copy.remove(index - 1);
            double right = Double.parseDouble(copy.remove(index - 1));

            double result = left * right;

            copy.add(index - 1, "" + result);
        }

        while ((index = copy.indexOf("/")) != -1) {
            double left = Double.parseDouble(copy.remove(index - 1));
            copy.remove(index - 1);
            double right = Double.parseDouble(copy.remove(index - 1));

            double result = left / right;

            copy.add(index - 1, "" + result);
        }

        // now our array of operators and values are all additions and subtractions
        double result = Double.parseDouble(copy.remove(0));
        while (copy.size() > 1) {
            String operator = copy.remove(0);
            String operand = copy.remove(0);
            if (operand.equals(".")) {
                continue;
            }
            double val = Double.parseDouble(operand);
            if (operator.equals("+")) {
                result += val;
            } else {
                result -= val;
            }
        }

        return result;
    }

    private boolean addDigit(String digit) {
        if (vals.size() == 0) {
            vals.add(digit);
        } else {
            String last = vals.get(vals.size() - 1);

            if (isOperator(last)) {
                vals.add(digit);
            } else {
                if (digit.equals(".") && last.contains(".")) {
                    return false;
                }

                last = last.concat(digit);
                vals.set(vals.size() - 1, trimLeadingZeros(last));
            }

        }

        return true;
    }

    private boolean addOperator(String operator) {
        if (vals.size() == 0) return false;

        String last = vals.get(vals.size() - 1);
        if (isOperator(last) || last.endsWith(".")) return false;

        vals.add(operator);

        return true;
    }

    private boolean delete() {
        if (vals.size() == 0) return false;

        String last = vals.get(vals.size() - 1);
        if (isOperator(last) || last.length() == 1) {
            vals.remove(vals.size() - 1);
        } else {
            vals.set(vals.size() - 1, last.substring(0, last.length() - 1));
        }

        return true;
    }

    private String trimLeadingZeros(String s) {
        int i = 0;
        while (s.charAt(i) == 0 && s.length() > 0) {
            s = s.substring(1, s.length());
        }
        return s;
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
}
