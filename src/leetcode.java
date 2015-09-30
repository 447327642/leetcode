

public class leetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b = addDigits(56);
		System.out.println(b);
	}
	//09-29
	public static int addDigits(int num) {
        while(num>9){
        int a = num/10;
        int b = num%10;
        num = a+b;
        }
        return num;
    }
	
	public class TreeNode {
	    int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    //09-29
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int a = maxDepth(root.left);
        int b = maxDepth(root.right);
        return 1+ Math.max(a,b);
        }
}
