package others;

public class ShiftingBitwise {

    public static void main (String[] args) {
        System.out.println(((-3 >> 1) == (-3 /2))); // proof it does not always divide by 2
        System.out.println((-3>>1));        // -2
        System.out.println(Integer.toBinaryString(-3>>1));
        System.out.println((-3 /2));        // -1
        System.out.println(Integer.toBinaryString(-3/2));
        System.out.println("------------");
        System.out.println(16>>1);          // 8
        System.out.println(16>>>1);         // 8
        System.out.println(16>>2);          // 4
        System.out.println(16>>>2);         // 4
        System.out.println(126>>>-1);       // 0
        System.out.println(Integer.toBinaryString(115));
        System.out.println(Integer.toBinaryString(115>>1));
        System.out.println("------------");
        System.out.println(16<<1);          // 32
        System.out.println(2<<2);         // 8
        System.out.println("------------");
        System.out.println(16>>>1);         // 8
        System.out.println(16<<2);          // 64
        System.out.println("------------");
        System.out.println(-2>>>1);         // 2147483647   /// 11111110 >>> 01111111
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-2>>>1));
        System.out.println(-2>>1);          // -1           /// 11111110 >>  11111111
        System.out.println(Integer.toBinaryString(-2>>1));
        System.out.println("------------");
        System.out.println(-20>>>1);        // 2147483638   ///
        System.out.println(-20>>1);         // -10
    }
}
