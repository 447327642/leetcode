
public class FindBadVersion {
	public int firstBadVersion(int n) {
        return (int) binaryFind(1,n);
    }
	public long binaryFind(long s, long e){
        if(s == e && isBadVersion((int)s))
            return s;
        if(isBadVersion((int)((s+e)/2))){
            return binaryFind(s,(s+e)/2);
        }else
            return binaryFind(((s+e)/2+1),e);
    }
	
    public boolean isBadVersion(long a) {
		return a >= 1702766719;
	}
}
