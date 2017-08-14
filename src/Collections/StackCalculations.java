package Collections;

public class StackCalculations {

    public static void main(String[] args) {
        String expression = "+B+a+ł---+a+g+a---+n-+w-+l+i+t---+e-+r+k--+a+c+h---";
        Stack<Character> stack = new Stack<>();

        for(char c : expression.toCharArray()) {
            if (c=='+') continue;
            if (c=='-' && !stack.isEmpty()) {
                System.out.print( stack.pull() );
                continue;
            }
            if (c=='-' && stack.isEmpty()) {
                System.out.println("Error! Attempt to pull element from empty storage!");
                break;
            }
            stack.push(c);
        }
    }
}
