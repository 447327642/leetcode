import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.transform.Rotate; 

public class leetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2};
		rotate(a,1);
		System.out.println(a[0]+"  "+a[1]);
	}	
	
	
	public static void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            if((i + k)<(nums.length)){
                System.out.println(i);
            	a[i+k] = nums[i];
            }else{
                System.out.println(i);

                a[(i+k)%nums.length] = nums[i];
            }
        }
		System.out.println(a[0]+" ==== "+a[1]);

        nums = a;
    }

	
	
	public void getComb(int[] a, int n ,int begin, int[] b, int index){
		if( n==0 ){
			for(int i = 0; i < index; i++){
				System.out.println(b[i] + "");
			}
			System.out.println();
			return;
		}
		
		for(int i = begin; i < a.length; i++){
			b[index] = a[i];
			getComb(a, n-1, n - 1, b, index+1);
		}
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

