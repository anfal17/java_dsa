public class OOPS{
    public static void main(String args[]) {
        Student s1 = new Student();
        Student s2 = new Student("Meow");

    }
}
    class Student {
        String name;
        int roll;

        Student() {
            System.out.println("This is non parameterized constructor");
        }

        Student(String name) {
            this.name = name;
            System.out.println("This is parameterized constructor");

        }      
    }
