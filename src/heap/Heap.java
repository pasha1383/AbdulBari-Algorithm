package heap;

public class Heap {
    static int[] arr = {50, 30, 20, 15, 10, 8, 16};
    static int height = getHeight();

    public static void main(String[] args) {
        System.out.println(isMaxHeap());
    }

    private static boolean isMaxHeap() {
        return checkMaxHeap(0);
    }

    private static boolean checkMaxHeap(int parentIndex) {
        int parentValue = getNodeValue(parentIndex);
        int leftChildValue = getLeftChildValue(parentIndex);
        int rightChildValue = getRightChildValue(parentIndex);

        if (leftChildValue == -1) {
            return true;
        } else if (rightChildValue == -1) {
            return parentValue >= leftChildValue;
        }


        boolean checkParentHeap = (parentValue >= leftChildValue && parentValue >= rightChildValue);
        boolean checkLeftTree = checkMaxHeap(getLeftChildIndex(parentIndex));
        boolean checkRightTree = checkMaxHeap(getRightChildIndex(parentIndex));

        return checkParentHeap && checkLeftTree && checkRightTree;

    }

    private static int getLeftChildValue(int parentIndex) {
        int leftChildIndex = getLeftChildIndex(parentIndex);

        if (leftChildIndex >= arr.length) {
            return -1;
        }

        return arr[leftChildIndex];
    }

    private static int getRightChildValue(int parentIndex) {
        int RightChildIndex = getRightChildIndex(parentIndex);

        if (RightChildIndex >= arr.length) {
            return -1;
        }

        return arr[RightChildIndex];
    }

    private static int getParentValue(int childIndex) {
        int ParentIndex = getParentIndex(childIndex);

        if (ParentIndex < 0) {
            return -1;
        }

        return arr[ParentIndex];
    }

    private static int getNodeValue(int index) {
        if (index >= arr.length) {
            return -1;
        }
        return arr[index];

    }

    private static int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private static int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private static int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private static int getHeight() {
        int length = arr.length;
        int level = 0;
        while (length >= 1) {
            length = length / 2;
            level++;
        }

        return level;
    }

}
