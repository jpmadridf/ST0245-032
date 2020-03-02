
package ejerciciosenlinea;


public class Ejerciciosenlinea {

    public int countEvens (int[] nums){
        int cont=0;
        for(int i=0; i<nums.length;i++){ //
            if(nums[i]%2==0){
                cont++;
            }
        }
        return cont;
    }

    public int bigDiff (int[] nums){
        int max=nums[0];
        int min=nums[0];
        for (int i=0; i<nums.length; i++){
            max= Math.max(nums[i],max);
            min= Math.min(nums[i],min);
        }
        return max-min;
    }

    public int centeredAverage(int[] nums){
        int max=nums[0];
        int min=nums[0];
        for (int i=0; i<nums.length; i++){
            max= Math.max(nums[i],max);
            min= Math.min(nums[i],min);
        }
        int sum=0;
        for (int i=0; i<nums.length; i++){
            sum+= nums[i];
        }
        int avg= sum-max-min;
        avg= avg/(nums.length-2);
        return avg;
    }

    public int sum13(int[] nums) {
        if (nums.length==0) return 0;
        int sum=0;
        for (int i=0; i<nums.length; i++){
            if(!(nums[i]==13)) sum+= nums[i];
            else{
                i++;
            }
        }
        return sum;
    }

    public int sum67(int[] nums) {
        if (nums.length==0) return 0;
        int sum= 0;
        for (int i=0; i<nums.length; i++){
            if(!(nums[i]==6)) sum+= nums[i];
            else{
                int a= 0;
                for (int j=i; nums[j]!=7; j++){
                    a++;
                }
                i+= a;
            }
        }
        return sum;
    }    
    
    public int maxSpan(int[] nums) {
        int max= 0, a, j;
        for(int i = 0; i < nums.length; i++){
            for( j = nums.length - 1; nums[i] != nums[j]; j--);
            a= 1+j-i;
            if(a > max)
                max= a;
        }
        return max;
    }

    public int[] fix34(int[] nums) {
        int j= 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 3 && nums[i+1] != 4){
                for(; nums[j] != 4; j++);
                nums[j] = nums[i+1];
                nums[i+1] = 4;
            }
        }
        return nums;
    }

    public int[] fix45(int[] nums){
        int j = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 4 && nums[i+1] != 5){
                for(; !(nums[j] == 5 && 
                    (j == 0 || j > 0 && nums[j-1] != 4)); j++);
                nums[j] = nums[i+1];
                nums[i+1] = 5;
            }
        }
        return nums;
    }

    public boolean canBalance(int[] nums){
        int izq = 0;
        int der;
        for(int i = 0; i < nums.length - 1; i++)
            izq += nums[i];
        der = nums[nums.length-1];
        for(int i = nums.length - 2; i > 0; i--){
            if(izq == der)
                return true;
            izq -= nums[i];
            der += nums[i];
        }
        return (izq == der);
    }

    public boolean linearIn(int[] o, int[] i){
        boolean noEsta;
        for(int inI = 0, outI = 0; inI < i.length; inI++){
            noEsta = true;
            for(; outI < o.length && noEsta; outI++){
                if(i[inI] == o[outI])
                    noEsta = false;
            }
            if(noEsta)
                return false;
        }
        return true;
    }
}

