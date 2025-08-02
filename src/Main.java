import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();

        String input = "";
        String name = "";
        String address = "";
        double GPA  = 0;
        boolean loop = true;

        Scanner scan = new Scanner(System.in);

        //Get user input
        while (!input.equalsIgnoreCase("done")){
            System.out.println("Type \"Add\" to add a student or type \"Done\":");
            input = scan.next();

            //Add student to student list
            if(input.equalsIgnoreCase("Add")){
                //Get name and address
                System.out.println("Input student name:");
                name = scan.next();
                System.out.println("Input student address:");
                address = scan.next();

                //Get GPA
                while (loop) {
                    System.out.println("Input student GPA:");
                    input = scan.next();
                    try{
                        GPA = Double.parseDouble(input);
                        loop = false;
                    } catch (Exception e){
                        System.out.println("Invalid input.");
                    }
                }
                students.add(new Student(name,address,GPA));
                loop = true;
                System.out.println("Student added.");

            } else if (!input.equalsIgnoreCase("done")) {
                System.out.println("Unknown input");
            }
        }
    }
}