import java.util.List;
import java.util.ArrayList;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        int n = students.size();

        for (int i = 0; i < n - 1; i++) { // Сортировка выбором
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getAge() < students.get(minIndex).getAge()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = students.get(i);
                students.set(i, students.get(minIndex));
                students.set(minIndex, temp);
            }
        }

        for (int i = 1; i < n; i++) { // Сортировка вставками
            Student current = students.get(i);
            int j = i - 1;

            while (j >= 0 && students.get(j).getName().compareTo(current.getName()) > 0) { // Сравниваем, сохраняя порядок возрастов у одинаковых имен
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, current);
        }
    }
}
