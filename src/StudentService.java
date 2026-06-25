import java.sql.*;

class StudentService {

    void addStudent(int id, String name, int marks) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO students VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);

            ps.executeUpdate();
            System.out.println("Student added");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("marks"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void searchStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Found: " + rs.getString("name"));
            } else {
                System.out.println("Not found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Deleted");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void updateStudent(int id, String name, int marks) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE students SET name=?, marks=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, marks);
            ps.setInt(3, id);

            ps.executeUpdate();
            System.out.println("Updated");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}