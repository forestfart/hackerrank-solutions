package groovy.tools

import java.nio.file.Paths

class InputFileReader {

    static def loadTwoDataInput(path, inputFile) {
        def scanner = new Scanner(Paths.get(path, inputFile))
        def n = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        def a = new int[n]
        String[] AItems = scanner.nextLine().split(" ")
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (int i = 0; i < n; i++) {
            def AItem = Integer.parseInt(AItems[i])
            a[i] = AItem
        }
        scanner.close()
        return a
    }

    static def loadThreeDataInput(path, inputFile) {
        def scanner = new Scanner(Paths.get(path, inputFile))

        def n = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        def d = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        def a = new int[n]
        String[] AItems = scanner.nextLine().split(" ")
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (int i = 0; i < n; i++) {
            def AItem = Integer.parseInt(AItems[i])
            a[i] = AItem
        }
        scanner.close()
        def params = new int[2]
        params[0] = n
        params[1] = d
        List<int[]> list = new ArrayList(2)
        list.add(params)
        list.add(a)
        return list
    }

}
