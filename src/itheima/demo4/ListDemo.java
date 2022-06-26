package itheima.demo4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();

        Student s1 = new Student("林青霞",20);
        Student s2 = new Student("遇害",20);
        Student s3 = new Student("你睡谁",20);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        //迭代器方法进行遍历
        Iterator<Student> it = list.iterator();
        while (it.hasNext()){
            Student s = it.next();
            System.out.println(s.getName() + "," + s.getAge());
        }
        System.out.println("--------------");
        //普通for循环遍历
        for (int i=0;i<list.size();i++){
            Student s = list.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
        System.out.println("-------------");
        //增强for循环
        for (Student s : list){
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
