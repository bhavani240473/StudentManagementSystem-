import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Add Student
    public void addStudent(Student student) {

        String query = "INSERT INTO students(name, age, course, email, phone) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPhone());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully!");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Students
    public void viewStudents() {

        String query = "SELECT * FROM students";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== STUDENT LIST ==========");

            while (rs.next()) {

                System.out.println("-----------------------------------");
                System.out.println("Student ID : " + rs.getInt("student_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Age        : " + rs.getInt("age"));
                System.out.println("Course     : " + rs.getString("course"));
                System.out.println("Email      : " + rs.getString("email"));
                System.out.println("Phone      : " + rs.getString("phone"));
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Student
    public void searchStudent(int id) {

        String query = "SELECT * FROM students WHERE student_id=?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nStudent Found");
                System.out.println("--------------------------");
                System.out.println("Student ID : " + rs.getInt("student_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Age        : " + rs.getInt("age"));
                System.out.println("Course     : " + rs.getString("course"));
                System.out.println("Email      : " + rs.getString("email"));
                System.out.println("Phone      : " + rs.getString("phone"));

            } else {

                System.out.println("Student Not Found!");

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent(Student student) {

        String query = "UPDATE students SET name=?, age=?, course=?, email=?, phone=? WHERE student_id=?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPhone());
            ps.setInt(6, student.getStudentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {

        String query = "DELETE FROM students WHERE student_id=?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
