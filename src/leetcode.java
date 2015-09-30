import java.util.Arrays; 

public class leetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,2,3,0,4};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
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

	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int a = maxDepth(root.left);
        int b = maxDepth(root.right);
        return 1+ Math.max(a,b);
        }
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p != null && q != null)
        return (p.val == q.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        else return false;
    }
	
	public static void moveZeroes(int[] nums) {
        int l =  nums.length;
        int f = 0;
        for(int i=0;i<l;i++){
        	if(nums[i] != 0){
        		if( f != i)
        		{
        			nums[f] = nums[i];
        			nums[i] = 0;
        		}
        		f++;
        	}
        	
        }
    }
}
