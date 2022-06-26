package itheima.demo2;
//自定义异常类的使用


public class ScoreException extends Exception{

    public ScoreException(){}

    public  ScoreException(String message){
        super(message);
    }
}
