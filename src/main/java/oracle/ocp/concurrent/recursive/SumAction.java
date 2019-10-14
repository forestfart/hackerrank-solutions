package oracle.ocp.concurrent.recursive;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class SumAction extends RecursiveAction {
    static final int THRESHOLD_SIZE = 3;
    int stIndex, lstIndex;
    int[] data;
    public SumAction(int[] data, int start, int end) {
        this.data = data;
        this.stIndex = start;
        this.lstIndex = end;
    }
    @Override
    protected void compute() {
        int sum = 0;
        if (lstIndex - stIndex <= THRESHOLD_SIZE) {
            for (int i = stIndex; i < lstIndex; i++) {
                sum += data [i];
            }
            System.out.println(sum);
        } else {
            new SumAction(data, stIndex + THRESHOLD_SIZE, lstIndex).fork( );
            new SumAction(data, stIndex, Math.min(lstIndex, stIndex + THRESHOLD_SIZE)).compute();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool fjPool = new ForkJoinPool();
        int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        fjPool.invoke(new SumAction(data, 0, data.length));
    }

}
