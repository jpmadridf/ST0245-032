
package codigo;


public class codigo {


    public static void main(String[] args) {
    }
    public static double arrayMax(long[] array, int n) {
	double max, temp;
	max = array[n];
	if(n>0){
	    temp = arrayMax(array,n-1);
	    if(temp > max)
		max = temp;
	}
	return max;
    }
    
    public static boolean groupSum(int start, int[] nums, int target) {
	if (start == nums.length)
            return target == 0;
        else
            return groupSum(start + 1, nums, target - nums[start])|| groupSum( start+1 , nums, target );
    }


    
}
