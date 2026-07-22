package DSA._01_Arrays.Phase1_Easy;


public class Remove_Duplicate {
    public static void main(String[] args){
        int arr[]={1,1,3,3,3,5,6,6,7};

        int j=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                j++;
                arr[j]=arr[i];
            }
        }
        
        System.out.println("Unique elements = " + (j + 1));

        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
