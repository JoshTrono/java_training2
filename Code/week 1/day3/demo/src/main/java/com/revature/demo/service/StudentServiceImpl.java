public class StudentServiceImpl implements StudentService {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(String id, Student student) {
        // Implement the update logic based on the student id
    }

    @Override
    public void deleteStudent(String id) {
        // Implement the delete logic based on the student id
    }

    @Override
    public Student getStudent(String id) {
        // Implement the logic to get a student based on the id
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
}