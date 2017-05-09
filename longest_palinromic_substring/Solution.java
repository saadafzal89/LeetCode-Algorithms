
public class Solution {
	
	public boolean palindromeCheck(String str){
		int len = str.length()-1;
		int flag =0;
		for(int i=0;i<(str.length()+1)/2;i++){
			if(str.charAt(i)!=str.charAt(len)){
				flag++;
				break;
			}
			len--;
		}
		
		if(flag==0)
			return true;
		else
			return false;
	}

	public String longestPalindrome(String s){
		String res ="";
		int i=0,j=s.length();
		int half_way=(s.length()+1)/2; 
		
		while(i<=half_way && j>=half_way){
			if(palindromeCheck(s.substring(i,j))){
				res = s.substring(i,j);
				return res;
			}
			else if(palindromeCheck(s.substring(i,j-1))){
				res = s.substring(i,j-1);
				return res;
			}
			else if(palindromeCheck(s.substring(i+1,j))){
				res = s.substring(i+1,j);
				return res;
			}
			i++;j--;	
		}
		return res;
	}
	
	public static void main(String[] args) {
		String input = "eabcb";
		Solution obj = new Solution();
		String result = obj.longestPalindrome(input);
		System.out.println("Longest palindromic string: "+result);
	}
}
