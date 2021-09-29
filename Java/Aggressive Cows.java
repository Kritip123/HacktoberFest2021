import java.util.Arrays;
import java.util.Scanner;

public class Aggressive_Cows
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0)
        {
            int n =sc.nextInt();
            int c=sc.nextInt();

            int arr[]=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            System.out.println(larMin(arr, c));
        }
    }

    public static int larMin(int[] arr, int c)
    {
        Arrays.sort(arr);
        int n =arr.length;

        int low = 0;
        int high = arr[n-1];
        int ans =0;


        while(low <= high)
        {
            int mid= (low+high)/2;
            //System.out.println(mid);

            if(isValid(arr, c, mid))
            {
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;

        }

        return ans;
    }

    public static boolean isValid(int[] arr, int c, int dis)
    {
        c--;
        int target = arr[0]+dis;

        for(int i=1;i< arr.length;i++)
        {
             if(arr[i] >= target)
             {
                 target = arr[i]+dis;
                 c--;
             }

             if(c == 0)
                 return true;
        }

        return c <= 0 ? true : false;
    }
}
