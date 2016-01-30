
public class ZigZagConversion {
	public String convert(String s, int numRows) {
        StringBuffer[] bf = new StringBuffer[numRows];
        char[] sc = s.toCharArray();
        int l = sc.length;
        int i = 0;
        for(int o = 0; o < numRows; o++){
            bf[o] = new StringBuffer();
        }
        while(i < l){
            for(int j = 0; j < numRows; j++){
                if(i >= l) break;
            	bf[j].append(sc[i]);
                System.out.println(sc[i]);
                i++;
            }
            if(i >= l) break;
            for(int k = numRows-2; k > 0; k--){
                bf[k].append(sc[i]);
                System.out.println(sc[i]);
                i++;
            }
        }
        String res="";
        for(StringBuffer a : bf){
            res += a.toString();
        }
        return res;
    }
}
