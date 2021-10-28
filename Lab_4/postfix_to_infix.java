
/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor Silveyra
    Description: Develop and Implement a Program in Java for converting an Infix Expression to a Postfix Expression
    and vice versa.
 */
public class postfix_to_infix {
    Infix_And_Postfix<String> operationsStack;

    public postfix_to_infix() {
        this.operationsStack = new Infix_And_Postfix<String>();
    }

    public String conversion (String val) {
        String a = "";
        String b = "";
        String c = "";
        String x = "";

        for (char letterChar: val.toCharArray()) {
            String currentRule = Character.toString(letterChar);
            if (currentRule.matches("-?(0|[1-9]\\d*)")) {
                operationsStack.push(currentRule);
            }

            else if (currentRule.equals("+") || currentRule.equals("-") || currentRule.equals("*")
                    || currentRule.equals("/") || currentRule.equals("%")) {
                a = operationsStack.pop();
                c = operationsStack.pop();
                b = currentRule;

                x = c + b + a;

                operationsStack.push(x);
            }
        }

        return operationsStack.pop();
    }


}
