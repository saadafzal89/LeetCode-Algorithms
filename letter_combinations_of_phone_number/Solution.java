import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution{    
    public List<String> letterCombinations(String digits) {
        String [] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> res = new LinkedList<String>();
        
        if(digits.length()<1)
            return res;
        
        if(digits.length()<2)
        {
            int first_int = Integer.parseInt(digits);
            for(char s: mapping[first_int].toCharArray()){
                res.add(Character.toString(s));
            }
            return res;   
        }
        res.add("");
        for(int i=0;i<digits.length();i++){
            int x = Integer.parseInt(Character.toString(digits.charAt(i)));
        	while(res.peek().length()==i){
                String t = res.remove();
                for(char s: mapping[x].toCharArray()){
                    res.add(t+s);
                }
            }
        }
            
    	return res;
    }
    public static void main(String args[]){
        List<String> result = new ArrayList<String>();
        String input = args[0];
        Solution obj = new Solution();
        result= obj.letterCombinations(input);

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
    }
}