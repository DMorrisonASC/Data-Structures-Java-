public class infix_to_postfix {
    Infix_And_Postfix<String> operationsStack;

    public infix_to_postfix() {
        this.operationsStack = new Infix_And_Postfix<String>();
    }

    public String conversion (String val) {
        String output = "";
        StringBuilder expression = new StringBuilder();
        for (char letterChar: val.toCharArray()) {
            String letter = Character.toString(letterChar);
            operationsStack.push(letter);
        }
        while (operationsStack.isEmpty() == false) {
            expression.append(operationsStack.pop());
        }
        output = expression.toString();
//        operationsStack.printOutPut();
        return output;
    }
}
