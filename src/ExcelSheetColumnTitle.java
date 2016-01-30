import java.util.Stack;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        Stack<Integer> stack = new Stack<>();
        while(n != 0){
            stack.push((n-1)%26);
            n = (n-1)/26;
        }
        StringBuilder bf = new StringBuilder();
        while(!stack.isEmpty()){
            bf.append((char)(stack.pop()+'A'));
        }
        return bf.toString();
        
    }
}
