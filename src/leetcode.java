import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap; 

public class leetcode {

	public static void main(String[] args) {
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spirl(a));
	}
	
	
	private static List<Integer> spirl(int[][] a){
		int bcol = 0;
		int ecol = a[0].length - 1;
		int brow = 0;
		int erow = a.length - 1;
		LinkedList<Integer> res = new LinkedList<>();
		while(bcol <= ecol && brow <= erow){
			for(int i = bcol; i <= ecol; i++){
				res.add(a[brow][i]);
			}
			brow++;
			for(int i = brow; i <= erow; i++){
				res.add(a[i][ecol]);
			}
			ecol--;
			for(int i = ecol; i >=bcol; i--){
				res.add(a[erow][i]);
			}
			erow--;
			for(int i = erow; i >= brow; i--){
				res.add(a[i][bcol]);
			}
			bcol++;
		}
		return res;
	}	
	
	
	private static void levelorder(TreeNode a){
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(a);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i = 0; i < size; i++){
				if(q.peek().left != null) q.offer(q.peek().left);
				if(q.peek().right != null) q.offer(q.peek().right);
				System.out.print(q.poll().val);
			}
			System.out.println();
		}
	}
	
	private static void inorder(TreeNode a){
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || a != null){
			if( a!= null){
				stack.push(a);
				a = a.left;
			}else{
				a  = stack.pop();
				System.out.println(a.val);
				a = a.right;
			}
		}
	}
	
	
	private static void preorder(TreeNode a){
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || a != null){
			if(a != null){
				System.out.print(a.val);
				if(a.right != null)
					stack.push(a.right);
				a = a.left;
			}else{
				a = stack.pop();
			}
		}
	}
	
	
	private static void helper(TreeNode a){
		if(a == null) return;
		helper(a.left);
		System.out.print(a.val);
		helper(a.right);
	}
	

	static String IntersectStrings(String first, String second) {
        char[] fc = first.toCharArray();
        char[] sc = second.toCharArray();
        Arrays.sort(fc);
        Arrays.sort(sc);
        StringBuilder br = new StringBuilder();
        int i = 0;
        int j = 0;
        for(; i < fc.length&&j < sc.length; ){
            if (fc[i] < sc[j]) i++;
            else if (fc[i] > sc[j]) j++;
            else {
                br.append(fc[i]);
                i++;
                j++;
            }
        }
       
        return br.toString();

    }
	
	public enum a {
		A(0), B(1);
		private int value;
		private a(int i ){ value = i;};
	}
	
	
	public static int fbmemo(int n, int[] memo){
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 1;
		if(memo[n] != 0) {System.out.println("memo!!"); return memo[n]; }
		return fbmemo(n-1, memo) + fbmemo(n - 2, memo);
	}
	
	
	public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            Deque<Integer> d = new LinkedList<>();
            for(int i = 0; i < n; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                d.add(queue.poll().val);
            }
            if(!check(d))
                return false;
        }
        return true;
    }
    
    private  static boolean check(Deque<Integer> list){
        while(!list.isEmpty()){
           if(list.poll() != list.pop())
                return false;
        }
        return true;
    }
	
	
	
	
	public static int binarySearch(int[] nums, int t ){
		int n = nums.length;
		int lo = 0;
		int hi = n - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(t== nums[mid]) return mid;
			if(t > nums[mid]) lo = mid + 1;
			else hi = mid - 1;
		}
		return -1;
	}
	
	
	
	public static int[] sumArray(int[] a){
		int[] b = new int[a.length];
		for(int i = 0; i < a.length-1; i++){
			b[i] = a[i] + a[i+1]; 
		}
		b[a.length-1] = a[0]+a[a.length-1];
		return b;
	}
	
	
	
	public static int fb(int i){
		if(i == 0)
			return 0;
		if(i == 1)
			return 1;
		if(i == 2)
			return 1;
		
		return fb(i-2)+fb(i-1);
	}
	
	
	
	 private static final String spliter = ",";
	    private static final String NN = "X";
	
	    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private  static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.poll();
        if(val != null){
        	if (val.equals("X")) return null;
            else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
        return null;
    }
	
	
	public static String reverseWords(String s) {
        s = s.trim();
        String a = "";
        String[]  temp = s.split(" ");
        for(String b : temp){
            if(!b.equals(""))
                a +=b+" ";
        }
        s = a.trim();
        System.out.println(s);
        char[] sc = s.toCharArray();
        int start = 0;
        for(int i = 0; i < sc.length; i++){
            if(sc[i] == ' '){
                help(sc,start,i-1);
                start = i+1;
            }
            if(i == sc.length -1){
            	help(sc,start, i);
            }
        }
        help(sc,0,sc.length-1);
        return String.valueOf(sc);
    }
    public static void help(char[] s, int start, int end){
        while(start <= end){
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }
	
	 public static int help(int n){
	        if(n == 1) return 1;
	        if(n == 2) return 2;
	        if(n == 0 ) return 1;
	        return help(n-1)+help(n-2);
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

