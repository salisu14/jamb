package com.jsiit.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class SwingValidator {

    public boolean isPresent(JTextComponent c, String title)
    {
        if (c.getText().length() == 0)
        {
            showMessage(c, title + " is a required field.");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isInteger(JTextComponent c, String title)
    {
        try
        {
            int i = Integer.parseInt(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, title + " must be an integer.");
            c.requestFocusInWindow();
            return false;
        }
    }

    public boolean isDouble(JTextComponent c, String title)
    {
        try
        {
            double d = Double.parseDouble(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, title + " must be a valid number.");
            c.requestFocusInWindow();
            return false;
        }
    }
    
    public boolean isDate(JTextComponent c, String title) 
    {
        try {
            LocalDate ld = LocalDate.parse(c.getText());
            return true;
        } catch(DateTimeException e) 
        {
           showMessage(c, title + " must be a valid date.");
            c.requestFocusInWindow();
            return false; 
        }
    }

    private void showMessage(JTextComponent c, String message)
    {
            JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
}