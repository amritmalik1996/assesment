package ProblemStatement2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProblemStatment2 {
    public static void main(String[] args){
        int[][] productionSlots = {{0, 3}, {5, 7}};
        int minResources = findMinResources(productionSlots);
        System.out.println("Minimum number of resources required: " + minResources);
    }

    public static int findMinResources(int[][] slots) {

        Arrays.sort(slots, Comparator.comparingInt(slot -> slot[1]));

        int resources = 0;
        List<Integer> endTimes = new ArrayList<>();

        for (int[] slot : slots) {
            int startTime = slot[0];
            int endTime = slot[1];
            boolean assigned = false;
            for (Integer et : endTimes) {
                if (startTime >= et) {
                    // Assign the slot to the same resource
                    assigned = true;
                    endTimes.remove(et);
                    endTimes.add(endTime);
                    break;
                }
            }
            if (!assigned) {
                resources++;
                endTimes.add(endTime);
            }
        }
        return resources;
    }
}
