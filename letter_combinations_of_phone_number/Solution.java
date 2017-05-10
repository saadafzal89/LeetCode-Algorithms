import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Solution{

    HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
    public void initHashMap(){
        hm.put(2, new ArrayList<String>(Arrays.asList("a","b","c")));
        hm.put(3, new ArrayList<String>(Arrays.asList("d","e","f")));
        hm.put(4, new ArrayList<String>(Arrays.asList("g","h","i")));
        hm.put(5, new ArrayList<String>(Arrays.asList("j","k","l")));
        hm.put(6, new ArrayList<String>(Arrays.asList("m","n","o")));
        hm.put(7, new ArrayList<String>(Arrays.asList("p","q","r","s")));
        hm.put(8, new ArrayList<String>(Arrays.asList("t","u","v")));
        hm.put(9, new ArrayList<String>(Arrays.asList("w","x","y","z")));
    }
    public List<String> letterCombinations(String digits) {
            ArrayList<String> res = new ArrayList<String>();
            if(digits.length()<1)
                return res;
            
            if(digits.length()<2)
            {
                int first_int = Integer.parseInt(digits);
                ArrayList<String> base = new ArrayList<String>();
                base = hm.get(first_int);
                return base;
            }
            String first = Character.toString(digits.charAt(0));
            int first_int = Integer.parseInt(first);
            ArrayList<String> base = new ArrayList<String>();
            base = hm.get(first_int);

            for(int i =1;i<digits.length();i++){
                String current = Character.toString(digits.charAt(i));
                int current_int = Integer.parseInt(current);
                ArrayList<String> curr = new ArrayList<String>();
                curr = hm.get(current_int);
                for(int j =0;j<base.size();j++){
                    for(int k=0;k<curr.size();k++){
                        String temp=base.get(j)+curr.get(k);
                        res.add(temp);
                    }
                }
            }  

            return res;
    }
    public static void main(String args[]){
        List<String> result = new ArrayList<String>();
        String input = "234";
        Solution obj = new Solution();
        obj.initHashMap();
        result= obj.letterCombinations(input);

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }
}