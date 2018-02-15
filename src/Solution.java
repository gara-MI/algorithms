public class Solution {
    public static int maxWater(int []a) {
        int total = 0, high1 = 0, high2 = 0;
        for (int l = 0, r = a.length - 1; l < r;) {
            if (a[l] < a[r]) {
                high1 = Math.max(high1, a[l]);
                total += high1 - a[l++];
            } else {
                high2 = Math.max(high2, a[r]);
                total += high2 - a[r--];
            }
        }
        return total;
    }

    public static void main( String[] args ) {

        int [] a ={1,2 ,1, 5, 2, 4 ,1 ,0 ,1 ,2 ,6 ,4 ,5 ,2 ,3 ,4 ,1, 2};
        System.out.println(maxWater(a));;
    }


}
