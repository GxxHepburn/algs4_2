package chaptertwo.two;

public class K3 {

    public static void main(String[] args) {
        /**
         *                                          a[i]
         *                          A   E   Q   S   U   Y   E   I   N   O   S   T
         *  sz = 1
         *  merge(a, 0, 0, 1)       A   E
         *  merge(a, 2, 2, 3)               Q   S
         *  merge(a, 4, 4, 5)                       U   Y
         *  merge(a, 6, 6, 7)                               E   I
         *  merge(a, 8, 8, 9)                                       N   O
         *  merge(a, 10, 10, 11)                                            S   T
         *
         *  sz = 2
         *  merge(a, 0, 1, 3)       A   E   Q   S
         *  merge(a, 4, 5, 7)                       E   I   U   Y
         *  merge(a, 8, 9, 11)                                      N   O   S   T
         *
         *  sz = 4
         *  merge(a, 0, 3, 7)       A   E   E   I   Q   S   U   Y
         *
         *  sz = 8
         *  merge(a, 0, 7, 11)      A   E   E   I   N   O   Q   S   S   T   U   Y
         */
    }
}
