package com.jsiit.jamb;

import com.jsiit.data.Student;
import com.jsiit.data.StudentDB;
import com.jsiit.util.DBException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import com.jsiit.util.SwingValidator;

public class StudentForm extends JDialog {

    private JTextField jambNoField;
    private JTextField firstNameField;
    private JTextField middleNameField;
    private JTextField lastNameField;
    private JTextField genderField;
    private JTextField stateField;
    private JTextField aggregateField;
    private JTextField courseField;
    private JTextField lgaField;

    private JButton confirmButton;
    private JButton cancelButton;

    private Student student = new Student();

    public StudentForm(java.awt.Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
    }

    public StudentForm(java.awt.Frame parent, String title,
            boolean modal, Student student) {
        this(parent, title, modal);
        this.student = student;

        confirmButton.setText("Save");
        jambNoField.setText(student.getJambNo());
        firstNameField.setText(student.getFirstName());
        middleNameField.setText(student.getMiddle());
        lastNameField.setText(student.getLastName());
        genderField.setText(student.getGender());
        stateField.setText(student.getState());
        aggregateField.setText(Integer.toString(student.getAggregate()));
        courseField.setText(student.getCourseName());
        lgaField.setText(student.getLocalGovernment());

    }

    private void initComponents() {
        jambNoField = new JTextField();
        firstNameField = new JTextField();
        middleNameField = new JTextField();
        lastNameField = new JTextField();
        genderField = new JTextField();
        stateField = new JTextField();
        aggregateField = new JTextField();
        courseField = new JTextField();
        lgaField = new JTextField();

        cancelButton = new JButton();
        confirmButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Dimension shortField = new Dimension(120, 27);
        Dimension longField = new Dimension(250, 27);
        jambNoField.setPreferredSize(shortField);
        jambNoField.setMinimumSize(shortField);
        firstNameField.setPreferredSize(shortField);
        firstNameField.setMinimumSize(shortField);
        middleNameField.setPreferredSize(shortField);
        middleNameField.setMinimumSize(shortField);

        lastNameField.setPreferredSize(shortField);
        lastNameField.setMinimumSize(shortField);
        genderField.setPreferredSize(shortField);
        genderField.setMinimumSize(shortField);
        stateField.setPreferredSize(shortField);
        stateField.setMinimumSize(shortField);

        aggregateField.setPreferredSize(shortField);
        aggregateField.setMinimumSize(shortField);
        courseField.setPreferredSize(longField);
        courseField.setMinimumSize(longField);
        lgaField.setPreferredSize(longField);
        lgaField.setMinimumSize(longField);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener((ActionEvent) -> {
            cancelButtonActionPerformed();
        });

        confirmButton.setText("Add");
        confirmButton.addActionListener((ActionEvent) -> {
            confirmButtonActionPerformed();
        });

        // JLabel and JTextField panel
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridBagLayout());
        studentPanel.add(new JLabel("JAMB Number:"),
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        studentPanel.add(jambNoField,
                getConstraints(1, 0, GridBagConstraints.LINE_START));
        studentPanel.add(new JLabel("First Name:"),
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        studentPanel.add(firstNameField,
                getConstraints(1, 1, GridBagConstraints.LINE_START));
        studentPanel.add(new JLabel("Middle Name:"),
                getConstraints(0, 2, GridBagConstraints.LINE_END));
        studentPanel.add(middleNameField,
                getConstraints(1, 2, GridBagConstraints.LINE_START));

        studentPanel.add(new JLabel("Last Name:"),
                getConstraints(0, 3, GridBagConstraints.LINE_END));
        studentPanel.add(lastNameField,
                getConstraints(1, 3, GridBagConstraints.LINE_START));

        studentPanel.add(new JLabel("Sex:"),
                getConstraints(0, 4, GridBagConstraints.LINE_END));
        studentPanel.add(genderField,
                getConstraints(1, 4, GridBagConstraints.LINE_START));

        studentPanel.add(new JLabel("State:"),
                getConstraints(0, 5, GridBagConstraints.LINE_END));
        studentPanel.add(stateField,
                getConstraints(1, 5, GridBagConstraints.LINE_START));

        studentPanel.add(new JLabel("Aggregate:"),
                getConstraints(0, 6, GridBagConstraints.LINE_END));
        studentPanel.add(aggregateField,
                getConstraints(1, 6, GridBagConstraints.LINE_START));

        studentPanel.add(new JLabel("Course:"),
                getConstraints(0, 7, GridBagConstraints.LINE_END));
        studentPanel.add(courseField,
                getConstraints(1, 7, GridBagConstraints.LINE_START));

        studentPanel.add(new JLabel("Local Govt:"),
                getConstraints(0, 8, GridBagConstraints.LINE_END));
        studentPanel.add(lgaField,
                getConstraints(1, 8, GridBagConstraints.LINE_START));

        // JButton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // add panels to main panel
        setLayout(new BorderLayout());
        add(studentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    private GridBagConstraints getConstraints(int x, int y, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        c.anchor = anchor;
        return c;
    }

    private void cancelButtonActionPerformed() {
        dispose();
    }

    private void confirmButtonActionPerformed() {
        if (isValidData()) {
            setData();
            if (confirmButton.getText().equals("Add")) {
                doAdd();
            } else {
                doEdit();
            }
        }
    }

    private boolean isValidData() {
        SwingValidator sv = new SwingValidator();
        return sv.isPresent(jambNoField, "JAMB Number")
                && sv.isPresent(firstNameField, "First Name")
                && //sv.isPresent(middleName, "Middle Name")
                sv.isPresent(lastNameField, "Last Name")
                && sv.isPresent(genderField, "Sex")
                && sv.isPresent(stateField, "State")
                && sv.isPresent(lgaField, "Local Government")
                && sv.isPresent(aggregateField, "Aggregate")
                && sv.isInteger(aggregateField, "Aggregate");
    }

    private void setData() {
        if (isValidData()) {
            String jambno = jambNoField.getText();
            String fName = firstNameField.getText();
            String lName = lastNameField.getText();
            String middle = middleNameField.getText();
            String sex = genderField.getText();
            String st = stateField.getText();
            int aggr = Integer.parseInt(aggregateField.getText());
            String courses = courseField.getText();
            String localGovt = lgaField.getText();

            student.setJambNo(jambno);
            student.setFirstName(fName);
            student.setMiddle(middle);
            student.setLastName(lName);
            student.setGender(sex);
            student.setState(st);
            student.setAggregate(aggr);
            student.setLocalGovernment(localGovt);
            student.setCourseName(courses);
        }
    }

    private void doEdit() {
        try {
            jambNoField.setEnabled(false);
            jambNoField.setEditable(false);
            StudentDB.update(student);
            dispose();
            fireDatabaseUpdatedEvent();
        } catch (DBException e) {
            System.out.println(e);
        }
    }

    private void doAdd() {
        try {
            Student s = StudentDB.getStudent(jambNoField.getText());
            if (s == null) {
                StudentDB.add(student);
                dispose();
                fireDatabaseUpdatedEvent();
            } else {
                JOptionPane.showMessageDialog(this, "This student already exists in the database", "Student Exists", JOptionPane.ERROR_MESSAGE);
                clearFields();
            }
        } catch (DBException e) {
            System.out.println(e);
        }
    }

    private void fireDatabaseUpdatedEvent() {
        StudentManagerFrame mainWindow = (StudentManagerFrame) getOwner();
        mainWindow.fireDatabaseUpdatedEvent();
    }

    private void clearFields() {
        jambNoField.setText("");
        firstNameField.setText("");
        middleNameField.setText("");
        lastNameField.setText("");
        genderField.setText("");
        stateField.setText("");
        aggregateField.setText("");
        courseField.setText("");
        lgaField.setText("");
        jambNoField.requestFocusInWindow();
    }
}
