package heap;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    static ArrayList<Integer> temp ;
    static ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 15, 30, 40)); // check heap sort
    static int height = getHeight();

    public static void main(String[] args) {
        heapSort();
    }

    private static void heapSort() {
        System.out.println(arr);
        temp = new ArrayList<>();
        for (int j : arr) {
            insertMaxHeap(j);
        }
        System.out.println(temp);
    }

    private static void insertMaxHeap(int key) {
        temp.add(key);
//        System.out.println("temp size is " + temp.size());
//        System.out.println(temp);
        int keyIndex = temp.size() - 1;
        int parentIndex = getParentIndex(keyIndex);
        int parentValue = getParentValue(keyIndex);
//        System.out.println("keyIndex " + keyIndex);
//        System.out.println("parentIndex " + parentIndex);
//        System.out.println("parentValue " + parentValue );

        while (key > parentValue && keyIndex != 0) {
//            System.out.println(temp);
            swap(parentIndex, keyIndex);
            keyIndex = parentIndex;
            parentIndex = getParentIndex(keyIndex);
            parentValue = getParentValue(keyIndex);
        }
//        System.out.println("after insert ");
//        System.out.println(temp);
    }

    private static boolean isMinHeap() {
        return checkMinHeap(0);
    }

    private static boolean isMaxHeap() {
        return checkMaxHeap(0);
    }

    private static boolean checkMinHeap(int parentIndex) {
        int parentValue = getNodeValue(parentIndex);
        int leftChildValue = getLeftChildValue(parentIndex);
        int rightChildValue = getRightChildValue(parentIndex);

        if (leftChildValue == -1) {
            return true;
        } else if (rightChildValue == -1) {
            return parentValue <= leftChildValue;
        }

        boolean checkParentHeap = (parentValue <= leftChildValue && parentValue <= rightChildValue);
        boolean checkLeftTree = checkMinHeap(getLeftChildIndex(parentIndex));
        boolean checkRightTree = checkMinHeap(getRightChildIndex(parentIndex));

        return checkParentHeap && checkLeftTree && checkRightTree;
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

        if (leftChildIndex >= arr.size()) {
            return -1;
        }

        return arr.get(leftChildIndex);
    }

    private static int getRightChildValue(int parentIndex) {
        int rightChildIndex = getRightChildIndex(parentIndex);

        if (rightChildIndex >= arr.size()) {
            return -1;
        }

        return arr.get(rightChildIndex);
    }

    private static int getParentValue(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
//        System.out.println("parentIndex in getParentValue " + parentIndex);
//        System.out.println("childIndex is "+childIndex);

        if (parentIndex < 0) {
            return -1;
        }

        return temp.get(parentIndex);
    }

    private static int getNodeValue(int index) {
        if (index >= arr.size()) {
            return -1;
        }
        return arr.get(index);
    }

    private static int getParentIndex(int childIndex) {
        return ((childIndex-1)/2);
    }

    private static int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private static int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private static int getHeight() {
        int length = arr.size();
        int level = 0;
        while (length >= 1) {
            length = length / 2;
            level++;
        }
        return level;
    }

    private static ArrayList<Integer> copyArrayList(ArrayList<Integer> firstList, ArrayList<Integer> secList) {
        ArrayList<Integer> newList = new ArrayList<>(secList);
        return newList;
    }

    private static void swap(int i, int j) {
        int tmp = temp.get(i);
        temp.set(i, temp.get(j));
        temp.set(j, tmp);
    }
}