
public class strStr {
	public int strStr(String haystack, String needle) {
		if(haystack == "" && needle == "") return 0;
		if(haystack == "" || needle == "") return -1;
        for(int i = 0; i < haystack.length()-needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for(int j = 0; j < needle.length(); j++){
                    if(haystack.charAt(i+j) == needle.charAt(j)){
                        return i+j;
                    }
                }
            }
        }
        return -1;
    }
}
