public class Exercise3{
	public static void main(String[]args){
        int n = 65;
        char characters;
        while (n <= 126){
            characters = (char) n;
            System.out.print(characters + " ");
            if ((n - 65 + 1) % 5 == 0){
            System.out.println();
            }
            n++;
        }
	}
}