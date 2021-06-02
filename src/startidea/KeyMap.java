package startidea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gxx
 * @create 2021-06-02 16:38
 */

/*
快捷键的使用-按照eclipse修改
1   执行(run)         alt + R
2   提示补全(Class Name Completion)         alt + /
3   单行注释        ctrl + /
4   多行注释        ctrl + shift + /
5   向下复制一行(Duplicate lines)         ctrl + alt + down
6   删除一行或选中行(delete line)       ctrl + D
7   向下移动行(move statement down)      alt + down
8   向上移动行(move statement up)        alt + up
9   向下开始新的一行(start new line)        shift + enter
10  向上开始新的一行(start new line before current)         ctrl + shift + enter
11  如何查看源码(class)       ctrl + 选中指定的结构 或 ctrl + shift + T
12  万能解错/生成返回值变量        alt + enter
13  退回到前一个编辑的页面(back)       alt + left
14  进入到下一个编辑的页面(针对于上一条) (forward)       alt + right
15  查看继承关系(type hierarchy)      F4

16  格式化代码(reformat code)        ctrl + alt + L
17  提示方法参数类型(Parameter Info)        ctrl + alt + /
18  复制代码            ctrl + C
19  撤销          ctrl + Z
20  反撤销         ctrl + Y
21  剪切          ctrl + X
22  粘贴          ctrl + V
23  保存          ctrl + S
24  全选          ctrl + A
25  选中数行，整体向后移动             tab
26  选中数行，整体往前移动             shift + tab
27  查看类的机构：类似于eclipse的outline           ctrl + O(字母)
28  重构：修改变量名与方法名(rename)            alt + shift + R
29  大写转小写/小写转大写(toggle case)            ctrl + shift + Y
30  生成构造/get/set/tostring               alt + shift + S

31  查看文档说明(quick documentation)             F2
32  收起所有的方法(collapse all)               alt + shift + C
33  打开所有的方法(expand all)                alt + shift + X
34  打开代码所在的硬盘文件夹(show in explorer)          ctrl + shift + X
35  生成try-catch等(surround with)         alt + shift + Z
36  局部变量抽取为成员变量(introduce field)        alt + shift + F
37  查找/替换(当前)               ctrl + F
38  查找(全局)              ctrl + H
39  查找文件                double shift
40  查看类的继承结构图(show UML Diagram)             ctrl + shift + U
41  查看方法的多层重写结构(method hierarchy)               ctrl + alt + H
42  添加到收藏(add to favorites)                 ctrl + alt + F
43  抽取方法(Extract Method)                alt + shift + M
44  打开最近修改的文件(Recently Files)           ctrl + E
45  关闭当前打开的代码栏(close)               ctrl + W

46  关闭打开的所有代码栏(close all)               ctrl + shift + W
47  快速搜索类中的错误(next highlighted error)      ctrl + shift + Q
48  选择要粘贴的内容(Show in Explorer)             ctrl + shift + V
49  查找方法在哪里被调用(Call Hierarchy)              ctrl + shift + H
 */
public class KeyMap {

    private static List list;

    public static void main(String[] args) {

        System.out.println("Hello world");

        list = new ArrayList();

        method();
    }

    public static void method() {

    }
}
