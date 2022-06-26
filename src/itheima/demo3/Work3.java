package itheima.demo3;

import java.util.ArrayList;
import java.util.List;

public class Work3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        for(int i : arr){
            System.out.println(i);
        }
        System.out.println("-------------");
        String[] string = {"Hello","World","java"};
        for(String j : string){
            System.out.println(j);
        }
        System.out.println("-------------");
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("javaee");
        list.add("He");
        for (String i : list){
            System.out.println(i);
        }
        System.out.println("-------------");

        //检验内部是不是迭代器原理,如果是的话，则在Iterator迭代器遍历添加元素会抛出并发异常
        for (String s : list){
            if (s.equals("Hello")){
                list.add("word");
            }
        }
    }
}
