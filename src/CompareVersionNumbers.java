

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] a = version1.split("\\.");
		String[] b = version2.split("\\.");
		int count = 0;
		for(int i = 0; i <Math.min(a.length, b.length); i++ ){
			if(Integer.parseInt(a[i]) > Integer.parseInt(b[i])){
				return 1;
			}
			if(Integer.parseInt(a[i]) < Integer.parseInt(b[i])){
				return -1;
			}
			count++;
		}
		if(a.length > b.length){
			for(int i = b.length; i < a.length; i++){
				if(Integer.parseInt(a[i]) > 0){
					return 1;
				}
			}
		}
		
		if(a.length < b.length){
			for(int i = a.length; i < b.length; i++){
				if(Integer.parseInt(b[i]) > 0){
					return -1;
				}
			}
		}

		
		return 0;

    }
}
