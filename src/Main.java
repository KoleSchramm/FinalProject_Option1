import java.io.IOException;
import java.io.FileWriter;
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

        NameComparator nameComparator = new NameComparator();
        SelectionSort selectionSort = new SelectionSort();
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
        selectionSort.sort(students,nameComparator);
        printList(students);
    }

    public static void printList(LinkedList<Student> list){
        try (FileWriter writer = new FileWriter("Students.txt");){
            for(int i = 0; i< list.size(); i++){
                writer.write("Name: " + list.get(i).getName() + " Address: " + list.get(i).getAddress() + " GPA: " + list.get(i).getGPA() + "\n");
            }
        }
        catch (IOException e){
            System.out.println("Failed to write file.");
        }

    }
}