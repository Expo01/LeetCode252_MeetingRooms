import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


    }
}
// given an unsorted arrary of intervals of whole # times (effectively a multi-dimensional array) such as [5,10],
// determine is a person could go to all meetings, such that no intervals overlap
// if 'intervals' == null, return trrue
//Arrays.sort(Interrvals, new Comparatorr<int[]>(), where .sort method variant with two elements passes the
// collection to be sorrted and the comparator in a lamba expreession that defines how the collection will be sorted by overriding
// compare(int[] a, int[] b) --> return a[0] - b[0]. this method retunrs -1,0,1 depending on if index 0 for array 'a' is <>= than
// value an index 0 of array 'b' where each inteerval is a 2-element array. this effectively sorts the intervals least to
// greatest based on first int in the interval but doees not assess for overlap
// define a previous interval via int[] preev = inteerrvals [0]
// for looop goes through all intervals, assigns int[] curr = intervals[i] and assesses if
// prev[1] > curr[0] to check overlap. return false if overrlap.
// redefine prev = curr @ end of each loop
// retunr true if arrray traverrsed with no overlap foound


//concept of sorting the intervals and then checking for: intervalOne[a][b] vs intervalTwo[a][b]
// if intervalOne[b] > intervalTwo[a] --> false, else true

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null) { // no length
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() { //.sort will sort based on specified comparator.
            // mutates multidimensional array and sorts each interval which is effectively a 2 element array
            @Override // overrrides the comparator instance method 'compare'
            public int compare(int[] a, int[] b) { // accepts two arrays (intervals) from the multidimensional array
                return a[0] - b[0]; // compares the first number of the interval. could either sort by ending time or
                // starting time. Compare returns -1,0,1 depending on lesser, equal or greater.
            }
        }); // at this point, 'intervals[][]' has been sorted by index 0
        int[] prev = intervals[0]; // prev is set to the interval at index 0
        for (int i = 1; i < intervals.length; i++) { //starts at index 1 since we are comparing this to 'prev' which is index 0
            int[] curr = intervals[i]; // curr = innterval at index 'i'
            if (prev[1] > curr[0]) { // states that if element 2 in interval one is greater than element one in interval
                // two, then the values overlap and return false. example: [1,5] [4,6]. 5 > 4. return false
                return false;
            }
            prev = curr; // cycles through the sorted interavls. prev goese from index 0 to index 1, etc.
            // each loop back through for loop, curr redefined as intervals[i] so will be one ahead of prev
        }
        return true;
    }
}


//ATTEMPT
//class Solution {
//    public boolean canAttendMeetings(int[][] intervals) {
//        Map<Integer, Integer> m = new HashMap<>();
//        for (int i = 0; i < intervals.length; i++) {
//            for (int j = intervals[]; )
//        }
//    }
//}

// idea: create a map. for interval[] through intervals.length-1,
// for intervals[i through second value] if !(map.containsKey) map.put (i,1)
// else return false. this is nested for loop where i need to loop through intervals array then loop through
// the range in that interval and assign to a map. this isn't great