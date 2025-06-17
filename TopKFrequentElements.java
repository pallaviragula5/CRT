import java.util.*;

public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency using HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // Step 2: Use Min Heap (PriorityQueue) to keep top K elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k)
                minHeap.poll(); // Remove least frequent
        }

        // Step 3: Extract result from heap
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty())
            result.add(minHeap.poll().getKey());

        // Optional: reverse to get most frequent first
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // Input k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        // Compute top k frequent
        List<Integer> result = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + result);

        sc.close();
    }
}
