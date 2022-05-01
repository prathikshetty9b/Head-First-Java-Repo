import java.lang.Math;

public class LearnMath {
    private int size;
    int x = 12;
    public static void main(String [] args ){
        int i = 10;
        double b = 24.02;
        LearnMath l = new LearnMath();
        System.out.println("Math.round(b) = " + Math.round(b));
        System.out.println("Math.sqrt(b) = " + Math.sqrt(i));
        System.out.println("getSize() = " + l.getSize());
        System.out.println("Call static method using object reference " + l.addNumbers(10, 20));
        System.out.println("Call static method using class Name " + LearnMath.addNumbers(10, 20));
        go(5);
        //Uncommenting below line throws you an error. Why?
        //System.out.println("getSize() = " + getSize());
        
    }

    public static void go(final int x ){
        System.out.println(x);
    }

    public void setSize(int s){
        size = s;
    }

    public static int addNumbers(int a, int b){
        return (a + b);
    }

    public int getSize(){
        return size;
    }
    
}
