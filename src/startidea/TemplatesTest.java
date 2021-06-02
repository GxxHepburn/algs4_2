package startidea;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author gxx
 * @create 2021-06-02 19:09
 *
 * 1. IDEA中代码模板所处的位置:settings - Editor - Live Templates / Postfix Completion
 * 2. 常用的模板
 */
public class TemplatesTest {

    //模板六： prsf： 可生成 private static final
    private static final int VALUE = 10;
    //变形： psf
    public static final int VALUE2 = 12;
    //变形： psfi
    public static final int VALUE3 = 13;
    //变形： psfs
    public static final String VALUE4 = "CHINA";

    //模板一： psvm == main
    public static void main(String[] args) {
        //模板二： sout
        System.out.println("Hello!");
        //变形： soutp / soutm / soutv / xxx.sout
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("TemplatesTest.main");
        int num1 = 10;
        int num2 = 20;
        System.out.println("num2 = " + num2);
        System.out.println(num1);


        //模板三： fori
        for (int i = 0; i < 10; i++) {

        }
        String[] arr = new String[]{"Tom", "Jerry", "HanMeimei", "Lilei"};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //变形: iter
        for (String s : arr) {
            System.out.println("s = " + s);
        }
        //变形： itar
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println("s = " + s);
        }

        //模板四： list.for
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(234);
        for (Object s : list) {
            System.out.println("s = " + s);
        }
        //变形： list.fori
        for (int i = 0; i < list.size(); i++) {

        }
        //变形： list.forr
        for (int i = list.size() - 1; i >= 0; i--) {

        }

        //模板五： ifn
        if (list == null) {
            
        }
        //变形： inn
        if (list != null) {

        }
        //变形： xxx.nn
        if (list != null) {

        }
        //变形： xxx.null
        if (list == null) {

        }
    }
}
