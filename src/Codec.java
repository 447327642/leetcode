import java.util.ArrayList;
import java.util.List;
public class Codec {
	
	    // Encodes a list of strings to a single string.
	    public String encode(List<String> strs) {
	        StringBuilder a = new StringBuilder();
	        for(String s : strs){
	            a.append(s.length()).append("byc").append(s);
	        }
	        return a.toString();
	    }

	    // Decodes a single string to a list of strings.
	    public List<String> decode(String s) {
	        List<String> ret = new ArrayList<String>();
	        int i = 0;
	        while(i < s.length()){
	            int breaker = s.indexOf("byc", i);
	            System.out.println(breaker);
	            int size = Integer.valueOf(s.substring(i, breaker));
	            ret.add(s.substring(breaker+3,breaker+3+size));
	            i = breaker+3+size;
	        }
	        return ret;
	    }
	
}
