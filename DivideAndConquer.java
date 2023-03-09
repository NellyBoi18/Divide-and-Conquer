import java.util.*;

public class DivideAndConquer {
    // recursive function to count the number of intersections
    private static int countIntersections(int[] q, int[] p, int left, int right) {
        if (left >= right) {
            return 0; // base case: if subarray has length 0 or 1, return 0
        }

        int mid = (left + right) / 2; // divide subarray into two halves
        int count = countIntersections(q, p, left, mid) + countIntersections(q, p, mid+1, right); // recursively count intersections in both halves
        int i = left; // index for left subarray
        int j = mid+1; // index for right subarray
        List<Integer> intersections = new ArrayList<>(); // list of intersection points

        // merge two sorted subarrays, keeping track of intersection points
        while (i <= mid && j <= right) {
            if (p[i] <= p[j]) { // use bottom line points to compare
                intersections.add(q[i]); // add top line point to list
                i++;
            } else {
                // count intersections with all points to the left in the left subarray
                count += intersections.size(); 
                j++;
            }
        }

        // add any remaining points from left subarray to intersection list
        while (i <= mid) {
            intersections.add(q[i]);
            i++;
        }

        // any remaining points in the right subarray will have already been counted in the first while loop
        while (j <= right) {
            count += intersections.size();
            j++;
        }

        return count; // return total number of intersections in this subarray
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numInstances = in.nextInt();
        int[] counts = new int[numInstances];
        int arrIndex = 0;

        while (numInstances-- > 0) {
            int n = in.nextInt(); // number of pairs of points
            int[] q = new int[n]; // top line points
            int[] p = new int[n]; // bottom line points

            for (int i = 0; i < n; i++) {
                q[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }

            counts[arrIndex] = countIntersections(q, p, 0, n-1); // count intersections using divide-and-conquer
            arrIndex++;
        }
        
        in.close();
    }
}
