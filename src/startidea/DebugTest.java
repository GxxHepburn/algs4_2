package startidea;

import java.util.HashMap;

/**
 * @author gxx
 * @create 2021-06-03 0:24
 */
public class DebugTest {
    /*
        step over 进入下一步，如果当前行断点是一个方法，则不进入当前方法体内
        step into 进入下一步，如果当前行断点是一个方法，则进入当前方法体内
        force step into 进入下一步，如果当前行断点是一个方法，则进入当前方法体内（相比于step into，force step into能够进入所有的方法，比如jdk的方法）
        step out 跳出
        resume program 恢复程序运行，但如果该断点下面代码还有断点则停在下一个断点上
        stop 停止
        mute breakpoints 禁用断点，使得所有的断点失效
        view breakpoints 查看所有断点
     */

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", "12");
        map.put("school", "Tsinghua");
        map.put("major", "computer");

        String age = map.get("age");
        System.out.println("age = " + age);

        map.remove("major");
        System.out.println(map);
    }
}
