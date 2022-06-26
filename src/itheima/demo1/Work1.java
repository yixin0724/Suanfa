package itheima.demo1;

/*
   需求：将一个数字的字符串
 */
import java.util.Arrays;

public class Work1 {
    public static void main(String[] args) {
        //定义一个字符串
        String s = "18 92 11 42 9 5";
        //把字符串里面的东西存到数组里面
        String[] strArray=s.split(" ");
        //定义一个int数组把每一个strArray数组里面的元素存到int数组里面
        int[] arr =new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            arr[i] = Integer.parseInt(strArray[i]);         //用Integer类的方法进行类型转换
        }
        //对arr整型数组进行排序
        Arrays.sort(arr);
        //把排序后的int数组中的元素进行拼接得到一个字符串，这里用StringBuilder来实现
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            //每到最后一个元素之前，每个元素后面都加个空格
            if (i == args.length-1){
                sb.append(arr[i]);
            }else {
                sb.append(arr[i]).append(" ");
            }
        }
        String reslut = sb.toString();      //将StirngBuilder类型转换为String类型
        //输出结果
        System.out.println("结果为" + reslut);
    }
}
