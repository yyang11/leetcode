import java.util.Stack;

public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> operands = new Stack<Integer>();
    for(int i=0; i<tokens.length; i++) {
      if(tokens[i].length() == 1 && !Character.isDigit(tokens[i].charAt(0))) {
        int operand2 = operands.pop(), operand1 = operands.pop();
        switch (tokens[i].charAt(0)) {
          case '+':
            operands.push(operand1 + operand2);
            break;
          case '-':
            operands.push(operand1 - operand2);
            break;
          case '*':
            operands.push(operand1 * operand2);
            break;
          case '/':
            operands.push(operand1 / operand2);
            break;
          default:
            System.err.println("unknown token" + tokens[i]);
        }
      }
      else {
        operands.push(Integer.parseInt(tokens[i]));
      }
    }
    if(operands.isEmpty())
      return 0;
    return operands.pop();
  }

  public static void main(String args[]) {
    String tokens[] = new String[]{"2", "1", "+", "3", "*"};
    int result =  new EvaluateReversePolishNotation().evalRPN(tokens);
    System.out.println(result);
  }
}
