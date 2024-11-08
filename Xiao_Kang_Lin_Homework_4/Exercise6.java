public class Exercise6{
    public static void main(String [] args){
        System.out.println(method());
    }
    public static char method(){
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char letter = abc.charAt(method2());
        return letter;
    }

    public static int method2() {
        long seed = System.nanoTime();
        long a = 25214903917L;  
        long c = 11L;        
        long m = (long) Math.pow(2, 48);

        seed = (a * seed + c) % m;

        int d = (int) (seed % 26) + 1; // Why do I need it to add a plus 1 if 0 is an acceptable num for my use case?
        int e = Math.abs(d);
        return e;
    }
}