import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javafx.scene.transform.Rotate;
import jdk.nashorn.internal.ir.LiteralNode.ArrayLiteralNode.ArrayUnit; 

public class leetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,4,3,-1,0};
		
		System.out.println(threeSum(a).get(0).get(0)+" "+threeSum(a).get(0).get(1)+" "+threeSum(a).get(0).get(2));
	}	
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 

        for(int i = 0; i < nums.length-2; i++){
            int sum = 0 - nums[0];
            int l = i+1, h = nums.length-1;
            while(l < h){
                if(nums[l]+nums[h] == sum){
                    res.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    while(l < h && nums[l] == nums[l+1]) l++;
                    while(l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                }else if(nums[l] + nums[h] < sum) l++;
                else h--;
            }
        }
        return res;
    }
	
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
        	System.out.println(nums[i]);
            if(map.containsKey(target - nums[i])){
                 int[] a = {i, map.get(target- nums[i])};
                 return a;
            }
            else{
            	map.put(nums[i] , i);
            }
                
        }
        return null;
    }
	
	
	public static String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int an = ac.length;
        int bn = bc.length;
        Stack<Character> stack = new Stack<>();
        int min = Math.min(an,bn);
        int i = 0;
        char cnt = '0';
        while(i <= min-1){
            if(ac[an-i-1] == '0' && bc[bn-i-1] == '0'){
                stack.push(cnt);
                cnt = '0';
            }else if(ac[an-i-1] == '1' && bc[bn-i-1] == '1'){
                stack.push(cnt);
                cnt = '1';
            }else{
                if(cnt == '1'){
                    stack.push('0');
                    cnt = '1';
                }else{
                	System.out.println("====");
                    stack.push('1');
                    cnt = '0';
                }
            }
            i++;
        }
        if(min == an){
            int k = 1;
            while(bn-an-k >=0 ){
                if(bc[bn-an-k] == '0'){
                    stack.push(cnt);
                    cnt = '0';
                }else if(cnt == '1'){
                    stack.push('0');
                    cnt = '1';
                }else if(cnt == '0'){
                    stack.push('1');
                    cnt = '0';
                }
                k++;
            }
        }else{
            int k = 1;
            while(an-bn-k >=0 ){
                if(ac[an-bn-k] == '0'){
                    stack.push(cnt);
                    cnt = '0';
                }else{
                    if(cnt == '1'){
                        stack.push('0');
                        cnt = '1';
                    }if(cnt == '0'){
                        stack.push('1');
                        cnt = '0';
                    }
                }
                k++;
            }
        }
        if(cnt == '1'){
            stack.push('1');
        }
        String res = "";
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
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

