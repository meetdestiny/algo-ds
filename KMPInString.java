package a;

public class KMPInString {
	private final int r;       
	private int[][] dfa;         
	private String pat;        

	public KMPInString(String pat) {
		this.r = 256;
		this.pat = pat;

		int m = pat.length();
		dfa = new int[r][m]; 
		dfa[pat.charAt(0)][0] = 1; 
		for (int X = 0, j = 1; j < m; j++) {
			for (int c = 0; c < r; c++) 
				dfa[c][j] = dfa[c][X];     
			dfa[pat.charAt(j)][j] = j+1;   
			X = dfa[pat.charAt(j)][X];     
		} 
	} 

	public int search(String txt) {
		int m = pat.length();
		int n = txt.length();
		int i, j;
		for (i = 0, j = 0; i < n && j < m; i++) {
			j = dfa[txt.charAt(i)][j];
		}
		if (j == m) return i - m;    
        if( n == txt.length())
        	return -1;
		return n;                    
	}

	public static void main(String[] args) {
		String pat = "abc.";
		String txt = "This is a big string which contains abc.";
		System.out.println(txt.length());
		KMPInString kmp = new KMPInString(pat);
		System.out.println(kmp.search(txt));


	}
}
