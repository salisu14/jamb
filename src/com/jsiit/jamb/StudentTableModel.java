/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.jamb;

import com.jsiit.data.Student;
import com.jsiit.data.StudentDB;
import com.jsiit.util.DBException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author salisu14
 */
public class StudentTableModel extends AbstractTableModel {

    private List<Student> students;
    private final String[] COLUMN_NAMES = { "JAMB Number", "First Name", "Middle Name", "Last Name", "Sex", "State",
        "Local Government", "Course Applied", "Aggregate" };

    public StudentTableModel() {
        try {
            students = StudentDB.getStudents();
        } catch (DBException e) {
            System.out.println(e);
        }
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return students.get(rowIndex).getJambNo();
            case 1:
                return students.get(rowIndex).getFirstName();
            case 2:
                return students.get(rowIndex).getMiddle();
            case 3:
                return students.get(rowIndex).getLastName();
            case 4:
                return students.get(rowIndex).getGender();
            case 5:
                return students.get(rowIndex).getState();
            case 6:
                return students.get(rowIndex).getLocalGovernment();
            case 7:
                return students.get(rowIndex).getCourseName();
            case 8:
                return students.get(rowIndex).getAggregate();
            default:
                return null;
        }
    }
    
    Student getStudent(int rowIndex) {
        return students.get(rowIndex);
    }
    
    void databaseUpdated() {
         try {
            students = StudentDB.getStudents();
            fireTableDataChanged();
        } catch (DBException e) {
            System.out.println(e);
        }
    }

}
