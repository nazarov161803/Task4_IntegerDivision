package com.foxminded.integerDivision.logicForDivision;

public class DivisonMaker {

    public String makeDivision(int dividend, int divisor) {

        validateInput(dividend, divisor);
        return getOutput(dividend, divisor);

    }

    private String getOutput(int dividend, int divisor) {
        String[] digits = String.valueOf(dividend).split("");
        StringBuilder result = new StringBuilder();
        StringBuilder reminder = new StringBuilder();
        StringBuilder quotient = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            Integer mod;
            Integer remindNumber;
            Integer multiplyResult;

            reminder.append(digits[i]);
            remindNumber = Integer.parseInt(reminder.toString());

            if (remindNumber >= divisor) {
                mod = remindNumber % divisor;
                multiplyResult = remindNumber / divisor * divisor;

                String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminder);
                result.append(lastReminder).append("\n");

                String multiply = String.format("%" + (i + 2) + "s", multiplyResult);
                result.append(multiply).append("\n");

                String tab = String.format("%" + (i + 2) + "s", pad(reminder.length(), '-'));
                result.append(tab).append("\n");

                quotient.append(multiplyResult / divisor);
                if (i == digits.length - 1) {
                    result.append(String.format("%" + (i + 2) + "d", mod));
                }

                reminder.replace(0, reminder.length(), mod.toString());
            } else {
                if (i >= Integer.parseInt(reminder.toString())) {
                    quotient.append(0);
                }
            }
        }
        addHead(result, quotient, dividend, divisor);
        return result.toString();
    }

    private void addHead(StringBuilder result, StringBuilder quotient, Integer dividend, Integer divisor) {
        int headerSize = 3;
        int[] index = new int[headerSize];

        for (int i = 0, stringToModify = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[stringToModify] = i;
                stringToModify++;
            }

            if (stringToModify == headerSize) {
                break;
            }
        }

        StringBuilder newResult = new StringBuilder();
        newResult.append(dividend);
        result.insert(index[2], pad(newResult.length() + 1 - index[0], ' ') + "|" + quotient.toString());
        result.insert(index[1], pad(newResult.length() + 1 - index[0], ' ') + "|" + pad(quotient.length(), '-'));
        result.insert(index[0], "|" + divisor);
        result.replace(1, index[0], dividend.toString());
        System.out.println(result);
    }

    private void validateInput(int dividend, int divisor) {

        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("Dividend or divisor less than 0");
        }

        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be 0");
        }

        if (divisor > dividend) {
            throw new IllegalArgumentException("Divisor can't more than dividend");
        }
    }

    private String pad(int number, char symbol) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++) {
            result.append(symbol);
        }
        return result.toString();
    }
}
