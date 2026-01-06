/*
PROJECT QUESTION:

Create a complete Java Swing Student Management System with MySQL database.

The system should support the following operations:
1. INSERT student records into the database.
2. DELETE student records by ID with confirmation.
3. FETCH ALL student records and display them in a JTable.
4. REFRESH the table data from the database.

Technical requirements:
- Use Java Swing for the graphical user interface (JFrame, JPanel, JTable).
- Use DefaultTableModel for displaying data in JTable.
- Use JDBC with MySQL database connectivity.
- Use PreparedStatement for executing SQL queries.
- Perform validation before insert and delete operations.
- After inserting a record, all input fields should be cleared automatically.
- Before deleting, the system should check whether the given ID exists.

The program should have a proper UI layout, clean structure, 
and well-commented, fully working source code.
*/
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sample8 extends JFrame implements ActionListener {

    JTextField tfName, tfAge, tfGender, tfCourse, tfYear,
            tfEmail, tfPhone, tfAddress, tfGPA, tfDeleteId;

    JButton btnInsert, btnDelete, btnFetch, btnRefresh;

    JTable table;
    DefaultTableModel model;

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    Sample8() {

        setTitle("Amol's Team Management System");
        setSize(900, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel form = new JPanel(new GridLayout(10, 2, 10, 10));

        tfName = new JTextField();
        tfAge = new JTextField();
        tfGender = new JTextField();
        tfCourse = new JTextField();
        tfYear = new JTextField();
        tfEmail = new JTextField();
        tfPhone = new JTextField();
        tfAddress = new JTextField();
        tfGPA = new JTextField();

        form.add(new JLabel("Name:"));    form.add(tfName);
        form.add(new JLabel("Age:"));     form.add(tfAge);
        form.add(new JLabel("Gender:"));  form.add(tfGender);
        form.add(new JLabel("Course:"));  form.add(tfCourse);
        form.add(new JLabel("Year:"));    form.add(tfYear);
        form.add(new JLabel("Email:"));   form.add(tfEmail);
        form.add(new JLabel("Phone:"));   form.add(tfPhone);
        form.add(new JLabel("Address:")); form.add(tfAddress);
        form.add(new JLabel("GPA:"));     form.add(tfGPA);

        btnInsert = new JButton("Insert");
        btnInsert.setBackground(Color.ORANGE);
        btnInsert.addActionListener(this);
        form.add(btnInsert);

        add(form, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"ID","Name","Age","Gender","Course",
                        "Year","Email","Phone","Address","GPA"}, 0);

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout());

        tfDeleteId = new JTextField(5);

        btnFetch = new JButton("Fetch All");
        btnDelete = new JButton("Delete by ID");
        btnRefresh = new JButton("Refresh");

        btnFetch.setBackground(Color.CYAN);
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.WHITE);
        btnRefresh.setBackground(Color.GREEN);

        btnFetch.addActionListener(this);
        btnDelete.addActionListener(this);
        btnRefresh.addActionListener(this);

        bottom.add(new JLabel("Delete ID:"));
        bottom.add(tfDeleteId);
        bottom.add(btnDelete);
        bottom.add(btnFetch);
        bottom.add(btnRefresh);

        add(bottom, BorderLayout.SOUTH);

        connectDB();
        loadAllStudents();

        setVisible(true);
    }

    void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SCOE_CS_B",
                    "root",
                    "amol@2005");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void loadAllStudents() {
        try {
            model.setRowCount(0);
            ps = con.prepareStatement("SELECT * FROM student_details");
            rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("course"),
                        rs.getString("year"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getDouble("gpa")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // 🔹 CLEAR ALL INPUT FIELDS
    void clearFields() {
        tfName.setText("");
        tfAge.setText("");
        tfGender.setText("");
        tfCourse.setText("");
        tfYear.setText("");
        tfEmail.setText("");
        tfPhone.setText("");
        tfAddress.setText("");
        tfGPA.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // INSERT
            if (e.getSource() == btnInsert) {

                if (tfName.getText().isEmpty() || tfAge.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields required");
                    return;
                }

                ps = con.prepareStatement(
                        "INSERT INTO student_details " +
                        "(name,age,gender,course,year,email,phone,address,gpa) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)");

                ps.setString(1, tfName.getText());
                ps.setInt(2, Integer.parseInt(tfAge.getText()));
                ps.setString(3, tfGender.getText());
                ps.setString(4, tfCourse.getText());
                ps.setString(5, tfYear.getText());
                ps.setString(6, tfEmail.getText());
                ps.setString(7, tfPhone.getText());
                ps.setString(8, tfAddress.getText());
                ps.setDouble(9, Double.parseDouble(tfGPA.getText()));

                ps.executeUpdate();
                loadAllStudents();
                clearFields(); // ✅ INSERT ke baad fields empty
                JOptionPane.showMessageDialog(this, "Inserted Successfully");
            }

            // DELETE
            if (e.getSource() == btnDelete) {

                if (tfDeleteId.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter ID");
                    return;
                }

                int id = Integer.parseInt(tfDeleteId.getText());

                ps = con.prepareStatement(
                        "SELECT id FROM student_details WHERE id=?");
                ps.setInt(1, id);
                rs = ps.executeQuery();

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this, "ID not found");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Delete record with ID " + id + "?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    ps = con.prepareStatement(
                            "DELETE FROM student_details WHERE id=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();

                    loadAllStudents();
                    tfDeleteId.setText("");
                    JOptionPane.showMessageDialog(this, "Record Deleted");
                }
            }

            if (e.getSource() == btnFetch) {
                loadAllStudents();
            }

            if (e.getSource() == btnRefresh) {
                model.setRowCount(0);
                loadAllStudents();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Sample8();
    }
}
