package itheima.demo5;

import java.util.HashSet;

public class HashCode {
    public static void main(String[] args) {
        HashSet<Student> hashSet = new HashSet<Student>();

        Student s1 = new Student(31,"林青霞");
        Student s2 = new Student(33,"马前森");
        Student s3 = new Student(21,"张狗子");
        Student s4 = new Student(21,"张狗子");

        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);    //在这里如果要保证元素的唯一性需要重写hashCode和equals方法

        for (Student s : hashSet){
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
