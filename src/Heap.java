import java.util.*;
import java.util.Stack;

public class Heap {

    public boolean isValid(String s) {
        // write code here
        Map<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if(stack.empty())
                    return false;

                if (stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }

        if (!stack.empty())
            return false;

        return true;
    }
}