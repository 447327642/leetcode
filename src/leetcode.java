import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javafx.scene.transform.Rotate; 

public class leetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHint("11","11"));
	}	
	
	
	 public static String getHint(String secret, String guess) {
	        HashMap<Integer, Character> map = new HashMap<>();
	        HashSet<Character> set = new HashSet<>();
	        for(int i = 0; i < secret.length(); i++){
	            map.put(i,secret.charAt(i));
	            set.add(secret.charAt(i));
	        }
	        int cows = 0;
	        int bull = 0;
	        for(int i = 0; i < secret.length(); i++){
	            if(set.contains(guess.charAt(i))){
	                cows++;
	                set.remove(guess.charAt(i));
	            }
	            if(map.get(i) == guess.charAt(i))
	                bull++;
	        }
	        cows = cows - bull;
	        if(cows < 0) cows = 0;
	        return bull+"A"+cows+"B";
	    }
	
	
	public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            smap.putIfAbsent(s.charAt(i),i);
            tmap.putIfAbsent(t.charAt(i),i);
        }
        String a = "";
        String b = "";
        for(int i = 0; i < s.length(); i++){
            a +=smap.get(s.charAt(i));
            b +=tmap.get(t.charAt(i));
        }
        System.out.println(a);
        System.out.println(b);
        return a.equals(b);
    }
	
	private static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
	
	public static boolean isPalindrome(String s) {
        String a = s.replaceAll("[^a-z0-9A-Z]", "").toLowerCase();
        System.out.println(a);
        return new StringBuilder(a).reverse().toString().equals(s); 
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

