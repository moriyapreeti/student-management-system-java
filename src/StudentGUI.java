import javax.swing.*;

public class StudentGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Management System");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("ID:");
        l1.setBounds(50, 50, 100, 30);
        frame.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(150, 50, 150, 30);
        frame.add(t1);

        JLabel l2 = new JLabel("Name:");
        l2.setBounds(50, 100, 100, 30);
        frame.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 100, 150, 30);
        frame.add(t2);

        JLabel l3 = new JLabel("Marks:");
        l3.setBounds(50, 150, 100, 30);
        frame.add(l3);

        JTextField t3 = new JTextField();
        t3.setBounds(150, 150, 150, 30);
        frame.add(t3);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(50, 220, 80, 30);
        frame.add(addBtn);

        JButton viewBtn = new JButton("View");
        viewBtn.setBounds(150, 220, 80, 30);
        frame.add(viewBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(250, 220, 80, 30);
        frame.add(deleteBtn);

        StudentService service = new StudentService();

        addBtn.addActionListener(e -> {
            int id = Integer.parseInt(t1.getText());
            String name = t2.getText();
            int marks = Integer.parseInt(t3.getText());

            service.addStudent(id, name, marks);
            JOptionPane.showMessageDialog(frame, "Student Added!");
        });

        viewBtn.addActionListener(e -> {
            service.viewStudents();
        });

        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(t1.getText());
            service.deleteStudent(id);
            JOptionPane.showMessageDialog(frame, "Deleted!");
        });

        frame.setVisible(true);
    }
}
