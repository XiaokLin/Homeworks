import java.util.Scanner;

public class exercise3{
	public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	String grade;
	double min_avg;
	double current_avg;
	double final_grade_percent;
	double final_grade;
	double score_needed;
	System.out.println("What is your desired grade?");
	grade = input.nextLine();
	System.out.println("What is the minimum average required?");
	min_avg = input.nextDouble();
	System.out.println("What is your current average in the course?");
	current_avg = input.nextDouble();
	System.out.println("How much does the final count as a percentage of the course grade?");
	final_grade_percent = input.nextDouble();
	final_grade = ((double)final_grade_percent/100);
	score_needed = ((double)min_avg-(((double)current_avg) * (1- (double)final_grade)))/(double)final_grade;
	System.out.println("You will need a score of " + score_needed + " on the final to get a " + grade + ".");
	input.close();
	}
}