import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Get index helpers
    private int getParent(int i) { return (i - 1) / 2; }
    private int getLeftChild(int i) { return 2 * i + 1; }
    private int getRightChild(int i) { return 2 * i + 2; }

    // Swap elements
    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    // Insert a new value
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Heapify Up
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(getParent(index)) > heap.get(index)) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    // Heapify Down
    private void heapifyDown(int index) {
        int smallest = index;
        int left = getLeftChild(index);
        int right = getRightChild(index);

        if (left < heap.size() && heap.get(left) < heap.get(smallest))
            smallest = left;

        if (right < heap.size() && heap.get(right) < heap.get(smallest))
            smallest = right;

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Get minimum (root)
    public int getMin() throws Exception {
        if (heap.isEmpty())
            throw new Exception("Heap is empty");
        return heap.get(0);
    }

    // Remove and return the min element
    public int removeMin() throws Exception {
        if (heap.isEmpty())
            throw new Exception("Heap is empty");

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

    // Display the heap
    public void displayHeap() {
        System.out.println("Heap elements: " + heap);
    }

    // Driver Code
    public static void main(String[] args) throws Exception {
        MinHeap minHeap = new MinHeap();

        int[] values = { 10, 20, 5, 6, 1, 8 };

        for (int value : values) {
            minHeap.insert(value);
            minHeap.displayHeap();
        }

        System.out.println("\nMin element: " + minHeap.getMin());

        System.out.println("\nRemoving elements:");
        while (true) {
            int min = minHeap.removeMin();
            System.out.println("Removed: " + min);
            minHeap.displayHeap();
        }
    }
}
