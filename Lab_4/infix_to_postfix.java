public class infix_to_postfix {
    Infix_And_Postfix<String> operationsStack;

    public infix_to_postfix() {
        this.operationsStack = new Infix_And_Postfix<String>();
    }

    public String conversion (String val) {
        String finalOutput = "";

        StringBuilder expression = new StringBuilder();

        for (char letterChar: val.toCharArray()) {
            String currentRule = Character.toString(letterChar);
            if ( currentRule.matches("-?(0|[1-9]\\d*)") ) {
                expression.append(currentRule);
            }
            else {
//                1st case
                if (operationsStack.peek() == null) {
                    operationsStack.push(currentRule);
                }
                else if (currentRule.equals("(")) {
                    operationsStack.push(currentRule);
                }
                else if (currentRule.equals(")")) {
                    while (!operationsStack.peek().equals("(")) {
                        expression.append(operationsStack.pop());
                    }
                    operationsStack.pop();
                }

                else if (currentRule.equals("*") || currentRule.equals("/")) {
                    if (operationsStack.peek() == null) {
                        operationsStack.push(currentRule);
                    }
                    else if (operationsStack.peek().equals("*") || operationsStack.peek().equals("/")) {
                        while (!operationsStack.isEmpty() && !operationsStack.peek().equals("(")) {
                            expression.append(operationsStack.pop());
                        }
                        operationsStack.push(currentRule);
                    }

                    else if (operationsStack.peek().equals("+") || operationsStack.peek().equals("-"))  {
                        operationsStack.push(currentRule);
                    }
                    
                }

                else if (currentRule.equals("+") || currentRule.equals("-")) {
                    if (operationsStack.peek() == null) {
                        operationsStack.push(currentRule);
                    }
                    else if (operationsStack.peek().equals("*") || operationsStack.peek().equals("/") || operationsStack.peek().equals("+") || operationsStack.peek().equals("-")) {
                        while (!operationsStack.isEmpty() && !operationsStack.peek().equals("(")) {
                            expression.append(operationsStack.pop());
                        }
                        operationsStack.push(currentRule);
                    }

                    else {
                        operationsStack.push(currentRule);
                    }
                }

            }

        }
        while (operationsStack.isEmpty() == false) {
            expression.append(operationsStack.pop());
        }

       finalOutput = expression.toString();
        return finalOutput;
    }

}
