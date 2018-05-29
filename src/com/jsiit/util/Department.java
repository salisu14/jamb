/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.util;

/**
 *
 * @author salisu14
 * @version 1.0.0
 */
public enum Department {
    COMPUTER_SCIENCE,
    COMPUTER_ENGINEERING,
    LIBRARY_SCIENCE,
    INNOVATIVE_TECHNOLOGY,
    ELECTRICAL_ENGINEERING;
    
    /**
     * Returns a meaningful <code>String</code> that represents the departments 
     * @return A <code>String</code>
     */
    @Override
    public String toString() {
        String s = "";
        switch (this.ordinal()) {
            case 0:
                s = "Department of Computer Science";
                break;
            case 1:
                s = "Department of Computer Engineering";
                break;
            case 2:
                s = "Department of Library and Information Science";
                break;
            case 3:
                s = "Department of Innovation Technology";
                break;
            case 4:
                s = "Department of Electrical Engineering";
                break;
            default:
                break;
        }
        
        return s;
            
    }
    
}
