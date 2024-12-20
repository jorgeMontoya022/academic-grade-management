package gestionnotas.edu.gestionnotas.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private double averageStudent;
    private boolean state;
    private List<Subject> subjectList;

    public Student(String name, String id, String email, String password, double averageStudent, boolean state) {
        super(name, id, email, password);
        this.averageStudent = averageStudent;
        this.state = state;
        this.subjectList = new ArrayList<>();
    }


    public void addSubject(Subject subject) {
        if(!subjectList.contains(subject)){
            subjectList.add(subject);
        }
    }
}
