
package ejercicoenlinea;


public class EjercicoEnLinea {

    
    public static void main(String[] args) {
        
    }
     public int factorial(int n) {
        if(n<=1){
            return 1;
        } else {
            return n* factorial(n-1);
        }
    }

    public int fibonacci(int n) {
        if(n<=1){
            return n;
        } else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public int triangle(int rows) {
        if(rows<1){
            return 0;
        }else{
            return rows+triangle(rows-1);
        }
    }

    public int powerN(int base, int n) {
        if(n==0){
            return 1;
        }else{
            return powerN(base,n-1)*base;
        }
    }

    public String changeXY(String str) {
        if(str.length()==0){
            return str;
        }else if(str.substring(0,1).equals("x")){
            return "y"+changeXY(str.substring(1));
        }else{
            return str.substring(0,1)+changeXY(str.substring(1));
        }
    }

    public boolean groupSum6(int start, int[] nums, int target){
        if(start == nums.length){
            if(target == 0){
                return true;
            }else{
                return false;
            }
        }if(nums[start] == 6){
            return groupSum6(start + 1, nums, target - nums[start]);
        }if(groupSum6(start + 1, nums, target - nums[start])){
            return true;
        }else{
            return groupSum6(start + 1, nums, target);
        }
    }

    public boolean groupNoAdj(int start, int[] nums, int target){
        if(target == 0){
            return true;
        }if(start >= nums.length){
            return false;
        }if(groupNoAdj(start + 2, nums, target - nums[start])){
            return true;
        }else{
            return groupNoAdj(start + 1, nums, target);
        }
    }

    public boolean groupSum5(int start, int[] nums, int target){
        if(start >= nums.length){
            if(target == 0){
                return true;
            }else{
                return false;
            }
        }if(nums[start] % 5 == 0){
            if(start < nums.length - 1 && nums[start+1] == 1){
                return groupSum5(start + 2, nums, target - nums[start]);
            }else{
                return groupSum5(start + 1, nums, target - nums[start]);
            }
        }if(groupSum5(start + 1, nums, target - nums[start])){
            return true;
        }else{
            return groupSum5(start + 1, nums, target);
        }
    }

    public boolean groupSumClump(int start, int[] nums, int target){
        if(start >= nums.length)
        {
            if(target == 0)
                return true;
            return false;
        }
        int i = start + 1;
        for(;  i < nums.length && nums[start] == nums[i]; i++);
        if(groupSumClump(i, nums, target - ((i - start) * nums[start])))
            return true;
        return groupSumClump(i, nums, target);	
    }

    public boolean splitArray(int[] nums){
        return splitArrayAux(nums, 0, 0);	
    }

    public boolean splitArrayAux(int[] nums, int i, int balance){
        if(i == nums.length){
            return (balance == 0);
        }if(splitArrayAux(nums, i + 1, balance + nums[i])){
            return true;
        }else{
            return splitArrayAux(nums, i + 1, balance - nums[i]);
        }
    }
}
