import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DivideAndConquer {
    // recursive function to count the number of intersections
    private static int countIntersections(int[] topLinePoints, int[] bottomLinePoints, int left, int right) {
        if (left >= right) {
            return 0; // base case: if subarray has length 0 or 1, return 0
        }

        int mid = (left + right) / 2; // divide subarray into two halves
        // recursively count intersections in both halves
        int count = countIntersections(topLinePoints, bottomLinePoints, left, mid) + countIntersections(topLinePoints, bottomLinePoints, mid+1, right);
        int leftIndex = left; // index for left subarray
        int rightIndex = mid+1; // index for right subarray
        List<Integer> intersections = new ArrayList<>(); // list of intersection points

        // merge two sorted subarrays, keeping track of intersection points
        while (leftIndex <= mid && rightIndex <= right) {
            // use bottom line points to compare
            if (bottomLinePoints[leftIndex] <= bottomLinePoints[rightIndex]) {
                intersections.add(topLinePoints[leftIndex]); // add top line point to list
                leftIndex++;
            } else { // count intersections with all points to the left in the left subarray
                count += intersections.size(); 
                rightIndex++;
            }
        }

        // add any remaining points from left subarray to intersection list
        while (leftIndex <= mid) {
            intersections.add(topLinePoints[leftIndex]);
            leftIndex++;
        }

        // any remaining points in the right subarray will have already been counted in the first while loop
        while (rightIndex <= right) {
            count += intersections.size();
            rightIndex++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numInstances = in.nextInt();
        int[] counts = new int[numInstances];
        int arrIndex = 0;

        while (numInstances-- > 0) {
            int n = in.nextInt(); // number of pairs of points
            int[] topLinePoints = new int[n]; // top line points
            int[] bottomLinePoints = new int[n]; // bottom line points

            for (int i = 0; i < n; i++) {
                topLinePoints[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                bottomLinePoints[i] = in.nextInt();
            }

            // count intersections using divide-and-conquer
            counts[arrIndex] = countIntersections(topLinePoints, bottomLinePoints, 0, n-1);
            arrIndex++;
        }
        
        in.close();

        for (int i = 0; i < numInstances; i++) {
            System.out.println(counts[i]);
        }
    }
}
