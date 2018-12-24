package array;

public class Student {
    private String name;
    private int score;
    
    public Student(String studentName, int studentScore) {
        name = studentName;
        score = studentScore;
    }
    
    @Override
    public String toString() {
        return String.format("Student(name: %s, scroe: %d)", name, score);
    }
    
    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        array.addLast(new Student("Alice", 100));
        array.addLast(new Student("Bob", 66));
        array.addLast(new Student("Charlie", 88));
        System.out.println(array);
        
    }
}
