package practice.algorithms.strings.determiningdnahealth;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Queue;

public class Solution {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve()
    {
        int n = ni();
        char[][] ss = new char[n][];
        for (int i = 0; i < n; i++) {
            ss[i] = ns().toCharArray();
        }
        int[] h = na(n);

        int Q = ni();
        char[][] qs = new char[Q][];
        long[] es = new long[2*Q];
        for (int i = 0;i < Q; i++) {
            int s = ni(), t = ni();
            qs[i] = ns().toCharArray();
            es[i] = (long)s << 32 | (long)i << 1 | 0;
            es[i+Q] = (long)t + 1 << 32 | (long)i << 1 | 1;
        }
        Arrays.sort(es);
        long[] rets = new long[Q];
        TrieByLink[] tries = new TrieByLink[18];
        int p = 0;
        for (long e : es){
            long x = e >>> 32;
            int ind = ((int)e) >>> 1;
            int pm = (e & 1) == 0 ? -1 : 1;
            while (p < n && p <= x-1) {
                int d = Integer.numberOfTrailingZeros(p + 1);
                tries[d] = new TrieByLink();
                for (int k = p-(1 << d) + 1; k <= p; k++) {
                    tries[d].add(ss[k], h[k]);
                }
                tries[d].buildFailure();
                p++;
            }
            long lhit = 0;
            for(int d = 0;d < 18;d++){
                if(p << ~d < 0){
                    lhit += tries[d].countHit(qs[ind]);
                }
            }
            rets[ind] += lhit*pm;
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(long r : rets)min = Math.min(min, r);
        for(long r : rets)max = Math.max(max, r);

        out.println(min + " " + max);
    }

public static class TrieByLink {
        public Node root = new Node((char)0, 0);
        public int gen = 1;

        public static class Node
        {
            public int id;
            public char character;
            public Node next, firstChild;
            public long hit = 0;

            public Node fail;

            public Node(char c, int id)
            {
                this.id = id;
                this.character = c;
            }
        }

        public void add(char[] s, long hit)
        {
            Node cur = root;
            Node pre = null;
            for(char c : s){
                pre = cur; cur = cur.firstChild;
                if(cur == null){
                    cur = pre.firstChild = new Node(c, gen++);
                }else{
                    for(; cur != null && cur.character != c; pre = cur, cur = cur.next);
                    if(cur == null)cur = pre.next = new Node(c, gen++);
                }
            }
            cur.hit += hit;
        }

        public void buildFailure()
        {
            root.fail = null;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);
            while(!q.isEmpty()){
                Node cur = q.poll();
                inner:
                for(Node ch = cur.firstChild;ch != null; ch = ch.next){
                    q.add(ch);
                    for(Node to = cur.fail; to != null; to = to.fail){
                        for(Node lch = to.firstChild;lch != null; lch = lch.next){
                            if(lch.character == ch.character){
                                ch.fail = lch;
                                ch.hit += lch.hit; // propagation of hit
                                continue inner;
                            }
                        }
                    }
                    ch.fail = root;
                }
            }
        }

        public long countHit(char[] q)
        {
            Node cur = root;
            long hit = 0;
            outer:
            for(char c : q){
                for(;cur != null;cur = cur.fail){
                    for(Node ch = cur.firstChild;ch != null; ch = ch.next){
                        if(ch.character == c){
                            hit += ch.hit; // add hit
                            cur = ch;
                            continue outer;
                        }
                    }
                }
                cur = root;
            }
            return hit;
        }
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte()
    {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }


    private int[] na(int n)
    {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    void start() throws FileNotFoundException {
        if(INPUT.isEmpty()) {
            //is = System.in;
            is = new FileInputStream("src/main/resources/DeterminingDnaHealthLarge.txt");
            // Large file expected output is "118731899 118731899", medium: "3218660 11137051"
            // Timings: small: 2 ms, medium: 9 ms, large 881 ms
        } else {
            is = new ByteArrayInputStream(INPUT.getBytes());
        }

        out = new PrintWriter(System.out);
        long startMillis = System.currentTimeMillis();
        solve();
        long endMillis = System.currentTimeMillis();
        out.flush();
        System.out.printf("\nElapsed time: %d ms", endMillis - startMillis);
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.start();
    }
}