import java.util.Comparator;
import java.util.LinkedList;

public class SelectionSort {
    public SelectionSort(){
    }

    public void sort(LinkedList<Student> students, Comparator comparator) {
        //increment
        for(int i = 0; i<students.size() - 1; i++){
            int min = i;

            //find minimum
            for(int j = i + 1; j<students.size(); j++){
                if(comparator.compare(students.get(j), students.get(min))<0){
                    min = j;
                }
            }
            //swap first with minimum
            Student temp = students.get(min);
            students.set(min,students.get(i));
            students.set(i,temp);
        }
    }
}
