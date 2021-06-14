package chaptertwo.two;

public class K5 {

    public static void main(String[] args) {
        /**
         *  N = 39
         *  自顶向下
         *      merge(a, 0, 0, 1)       2
         *      merge(a, 2, 2, 3)       2
         *      merge(a, 0, 1, 3)       4
         *      merge(a, 4, 4, 5)       2
         *      merge(a, 6, 6, 7)       2
         *      merge(a, 4, 5, 7)       4
         *      merge(a, 0, 3, 7)       8
         *      merge(a, 8, 8, 9)       2
         *      merge(a, 10, 10, 11)    2
         *      merge(a, 8, 9, 11)      4
         *      merge(a, 12, 12, 13)    2
         *      merge(a, 14, 14, 15)    2
         *      merge(a, 12, 13, 15)    4
         *      merge(a, 8, 11, 15)     8
         *      merge(a, 0, 7, 15)      16
         *      merge(a, 16, 16, 17)    2
         *      merge(a, 18, 18, 19)    2
         *      merge(a, 16, 17, 19)    4
         *      merge(a, 20, 20, 21)    2
         *      merge(a, 22, 22, 23)    2
         *      merge(a, 20, 21, 23)    4
         *      merge(a, 16, 19, 23)    8
         *      merge(a, 24, 24, 25)    2
         *      merge(a, 26, 26, 27)    2
         *      merge(a, 24, 25, 27)    4
         *      merge(a, 28, 28, 29)    2
         *      merge(a, 30, 30, 31)    2
         *      merge(a, 28, 29, 31)    4
         *      merge(a, 24, 27, 31)    8
         *      merge(a, 16, 23, 31)    16
         *      merge(a, 0, 15, 31)     32
         *      merge(a, 32, 32, 33)    2
         *      merge(a, 34, 34, 35)    2
         *      merge(a, 32, 33, 35)    4
         *      merge(a, 36, 36, 37)    2
         *      merge(a, 36, 37, 38)    3
         *      merge(a, 32, 35, 38)    7
         *      merge(a, 0,  31, 38)    39
         *
         *  自底向上
         *      sz = 1
         *      merge(a, 0, 0, 1)       2
         *      merge(a, 2, 2, 3)       2
         *      merge(a, 4, 4, 5)       2
         *      merge(a, 6, 6, 7)       2
         *      merge(a, 8, 8, 9)       2
         *      merge(a, 10, 10, 11)    2
         *      merge(a, 12, 12, 13)    2
         *      merge(a, 14, 14, 15)    2
         *      merge(a, 16, 16, 17)    2
         *      merge(a, 18, 18, 19)    2
         *      merge(a, 20, 20, 21)    2
         *      merge(a, 22, 22, 23)    2
         *      merge(a, 24, 24, 25)    2
         *      merge(a, 26, 26, 27)    2
         *      merge(a, 28, 28, 29)    2
         *      merge(a, 30, 30, 31)    2
         *      merge(a, 32, 32, 33)    2
         *      merge(a, 34, 34, 35)    2
         *      merge(a, 36, 36, 37)    2
         *
         *      sz = 2
         *      merge(a, 0, 1, 3)       4
         *      merge(a, 4, 5, 7)       4
         *      merge(a, 8, 9, 11)      4
         *      merge(a, 12, 13, 15)    4
         *      merge(a, 16, 17, 19)    4
         *      merge(a, 20, 21, 23)    4
         *      merge(a, 24, 25, 27)    4
         *      merge(a, 28, 29, 31)    4
         *      merge(a, 32, 33, 35)    4
         *      merge(a, 36, 37, 38)    3
         *
         *      sz = 4
         *      merge(a, 0, 3, 7)       8
         *      merge(a, 8, 11, 15)     8
         *      merge(a, 16, 19, 23)    8
         *      merge(a, 24, 27, 31)    8
         *      merge(a, 32, 35, 38)    7
         *
         *      sz = 8
         *      merge(a, 0, 7, 15)      16
         *      merge(a, 16, 23, 31)    16
         *
         *      sz = 16
         *      merge(a, 15, 31)        32
         *      merge(a, 31, 38)        39
         */
    }
}
