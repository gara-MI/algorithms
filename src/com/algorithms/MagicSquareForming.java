public class MagicSquareForming {

    public static void main(String[] args) {
        int [][] a = {{4,9,2,3,5,7,8,1,6},{8,3,4,1,5,9,6,7,2},{6,1,8,7,5,3,2,9,4},{2,7,6,9,5,1,4,3,8},
                      {2,9,4,7,5,3,6,1,8},{4,3,8,9,5,1,2,7,6},{8,1,6,3,5,7,4,9,2},{6,7,2,1,5,9,8,3,4}
                     };
        int [] b = new int[9];
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<9;i++){
            b[i]=scan.nextInt();
        }
        int max=100,sum=0;
        for(int i=0;i<8;i++){
            sum =0;
            for(int j=0;j<9;j++){
                sum += Math.abs(b[j]-a[i][j]);
            }
            if(max>sum){
                max= sum;
            }
        }
        System.out.println(max);
    }
}
