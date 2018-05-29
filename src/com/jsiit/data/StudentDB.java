/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.data;

import com.jsiit.util.DBException;
import com.jsiit.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author salisu14
 * @version 1.0.0
 */
public class StudentDB {

    /**
     *
     * @return a list of all students in the database
     * @throws DBException
     */
    public static List<Student> getStudents() throws DBException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY rg_aggregate DESC";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = getStudentFromResultSet(rs);

                students.add(s);
            }
            return students;
        } catch (SQLException e) {
            throw new DBException(e.toString());
        }
    }

    /**
     * Sets the student data to the specified <code>ResultSet</code>
     *
     * @param rs A <code>ResultSet</code> for the student data
     * @return a <code>ResultSet</code> representing the data of the student
     * @throws SQLException
     */
    private static Student getStudentFromResultSet(final ResultSet rs) throws SQLException {
        String jambNo = rs.getString("jambno");
        String fName = rs.getString("firstname");
        String middle = rs.getString("middle");
        String lName = rs.getString("lastname");
        String gender = rs.getString("gender");
        String state = rs.getString("state_name");
        int aggregate = rs.getInt("rg_aggregate");
        String course = rs.getString("course");
        String lga = rs.getString("lga");

        Student s = new Student();

        s.setJambNo(jambNo);
        s.setFirstName(fName);
        s.setLastName(lName);
        s.setMiddle(middle);
        s.setGender(gender);
        s.setState(state);
        s.setAggregate(aggregate);
        s.setCourseName(course);
        s.setLocalGovernment(lga);
        return s;
    }

    /**
     * Sets the jamb number to the specified <code>String</code>
     *
     * @param jambNo Returns a <code>Student</code> object
     * @return a <code>Student</code> for the student
     * @throws DBException
     */
    public static Student getStudent(String jambNo) throws DBException {
        String sql = "SELECT * FROM student WHERE jambNo = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, jambNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Student s = getStudentFromResultSet(rs);

                return s;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            throw new DBException(e.toString());
        }
    }
   /**
    * Add a new <code>Student</code> object
    * @param student 
    * @throws DBException 
    */
    public static void add(Student student) throws DBException {
        String sql = "INSERT INTO student(jambno,firstname,lastName,middle,gender,"
                + "state_name, rg_aggregate,course,lga)  "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getJambNo());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getMiddle());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getState());
            ps.setInt(7, student.getAggregate());
            ps.setString(8, student.getCourseName());
            ps.setString(9, student.getLocalGovernment());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex.toString());
        }
    }
    /**
     * Update a <code>Student</code> object
     * @param student
     * @throws DBException 
     */
    public static void update(Student student) throws DBException {
        String sql = "UPDATE student SET "
                + "jambno = ?, "
                + "firstname = ?, "
                + "lastname = ?, "
                + "middle = ?, "
                + "gender = ?, "
                + "state_name = ?, "
                + "rg_aggregate = ?, "
                + "course = ?, "
                + "lga = ? "
                + "WHERE jambno = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getJambNo());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getMiddle());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getState());
            ps.setInt(7, student.getAggregate());
            ps.setString(8, student.getCourseName());
            ps.setString(9, student.getLocalGovernment());
            ps.setString(10, student.getJambNo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex.toString());
        }
    }
   /**
    * Deletes the specified <code>Student</code> object
    * @param student
    * @throws DBException 
    */
    public static void delete(Student student) throws DBException {
        String sql = "DELETE FROM student "
                + "WHERE jambno = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getJambNo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex.toString());
        }
    }
/**
 * A generic method for filtering using different criteria
 * @param <T>
 * @param list
 * @param p
 * @return a <code>List&lt;T&gt;></code> for the given T
 */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
