/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import java.util.*;

public class Student
{
    public String name;
    public LinkedList<Semester> semesters = new LinkedList<>();
    public String stuCode;

    public Student(String name, String stuCode,Semester s){
        this.name = name;
        this.stuCode = stuCode;
        this.semesters.add(s); 
    }

    public void addSem(Semester s){
        this.semesters.add(s);
    }
}
