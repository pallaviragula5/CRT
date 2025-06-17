import java.util.*;

public class MedianUsingTwoHeaps {
    // Max Heap for the lower half
    private PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(Collections.reverseOrder());

    // Min Heap for the upper half
    private PriorityQueue<Integer> upperHalf = new PriorityQueue<>();

    public void addNumber(int num) {
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.offer(num);
        } else {
            upperHalf.offer(num);
        }

        // Balance the heaps (size difference should not exceed 1)
        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.offer(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    public double getMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        } else {
            return lowerHalf.peek(); // since lowerHalf is allowed to have 1 extra element
        }
    }

    public static void main(String[] args) {
        MedianUsingTwoHeaps medianFinder = new MedianUsingTwoHeaps();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter numbers one by one:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            medianFinder.addNumber(num);
            System.out.println("Median after " + (i + 1) + " elements: " + medianFinder.getMedian());
        }

        sc.close();
    }
}
