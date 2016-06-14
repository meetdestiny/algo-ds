package a;

public class Roman {

	public static void main(String args[]) throws Exception{
		//Test case
		System.out.println(toArabic("MMMMCMXCXI"));
	}
	
	
	public static int toArabic(String number) throws Exception {
	    String[] letters = {"M","CM","D","CD","C","XC","L","XL","X", "IX","V","IV","I"};
	    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

	    // validations
	    if (number==null || number.isEmpty()) {
	        return 0;
	    }
	    for(int i=0; i<letters.length; i++) {
	        if (number.startsWith(letters[i])) {
	            return values[i] + toArabic(number.substring(letters[i].length()));
	        }
	    }
	    throw new Exception("something bad happened");
	}
}
