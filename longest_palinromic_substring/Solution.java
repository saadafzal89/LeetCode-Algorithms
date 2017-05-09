public class Solution {
	String res="";
	
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	String temp_res1 = extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	if(temp_res1.length()>res.length())
	     		res = temp_res1;
	     	String temp_res2= extendPalindrome(s, i, i+1); //assume even length.
	     	if(temp_res2.length()>res.length())
	     		res = temp_res2;
	    }
	    return res;
	}
	
	private String extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		
		return s.substring(j+1,k);
	}
	
	public static void main(String args[]){
		
		String input = "babad";
		Solution obj = new Solution();
		String result = obj.longestPalindrome(input);
		System.out.println("Longest palindromic substring is:"+result);
	}
}