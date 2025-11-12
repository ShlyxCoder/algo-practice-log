package cn.org.shelly.leetcode.design.juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTask {

    public static void main(String[] args){
        ForkJoinPool f = new ForkJoinPool();
        List<Long> list = List.of(1L,2L,3L,4L,5L);
        MyTask myTask = new MyTask(list,0,5);
        Long invoke = f.invoke(myTask);
        System.out.println("invoke = " + invoke);
    }
}
class MyTask extends RecursiveTask<Long>{
    List<Long> list ;
    int left;
    int right;
    public MyTask(List<Long> tmp, int l,int r){
        left = l;
        right = r;
        list = tmp;
    }

    @Override
    protected Long compute() {
        if(right - left < 500){
            long sum = 0L;
            for(int i = left;i<right;i++){
                sum += list.get(i);
            }
            return sum;
        }
        else{
            int mid = (left + right) >> 1;
            MyTask left = new MyTask(list,this.left, mid);
            MyTask right = new MyTask(list,mid+1, this.right);
            // 最好一边fork运行，一边直接运行
            java.util.concurrent.ForkJoinTask<Long> fork = left.fork();
            long rightAns = right.compute();
            return rightAns + fork.join();
        }
    }
}class MergeSortTask extends RecursiveTask<int[]> {
    private final int[] arr;

    public MergeSortTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected int[] compute() {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] leftPart = Arrays.copyOfRange(arr, 0, mid);
        int[] rightPart = Arrays.copyOfRange(arr, mid, arr.length);

        MergeSortTask leftTask = new MergeSortTask(leftPart);
        MergeSortTask rightTask = new MergeSortTask(rightPart);

        leftTask.fork();
        int[] rightResult = rightTask.compute();
        int[] leftResult = leftTask.join();

        return merge(leftResult, rightResult);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            result[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];

        return result;
    }}