import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentScorePairs {
    static class Student {
        String name;
        int marks;

        public Student(int m, String n) {
            marks = m;
            name = n;
        }
    }

    public static void printResult(int n, int d, String student[]) {
        List<Student> students = new ArrayList<Student>();

        for (String stu : student) {
            String str[] = stu.split(" ");
            students.add(new Student(Integer.parseInt(str[1]), str[0]));
        }

        Collections.sort(students, (a, b) -> a.marks - b.marks);

        for (int i = 0; i < students.size(); i++) {
            int index = search(students, i + 1, d - students.get(i).marks);
            if (index != -1)
                System.out.println(students.get(i).name + " " + students.get(index).name);
        }
    }

    public static int search(List<Student> students, int start, int sea) {
        int end = students.size() - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int val = students.get(mid).marks;
            if (val == sea)
                return mid;
            else if (val > sea)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}
