package test;

public class MethodWithStringParam{

    public static void main(String[]args){
        String s1 = "Hello Class";
        String printString = printMe(s1);

        System.out.println(printString);
        system.out.println(printMe("Hi CS"));
    }

    public static String printMe(String sentence) {
        return sentence + "101";
    }
}