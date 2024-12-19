package gestionnotas.edu.gestionnotas.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private List<Subject> subjectList;

    public Teacher(String name, String id, String email, String password) {
        super(name, id, email, password);
        this.subjectList = new ArrayList<>();
    }

}
