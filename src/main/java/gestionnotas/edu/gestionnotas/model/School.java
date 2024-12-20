package gestionnotas.edu.gestionnotas.model;

import java.util.ArrayList;
import java.util.List;

public class School {
    private Administrator administrator;
    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Subject> subjectList = new ArrayList<>();

    public School() {

    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public <T extends Person> boolean addPerson(List<T> personList, T person) {
        if (person == null || searchPerson(personList, person.getId()) != null) {
            return false; // No se agrega si la persona ya existe o es null
        }
        personList.add(person);
        return true;
    }

    private <T extends Person> T searchPerson(List<T> personList, String id) {
        for (T person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null; // No encontrado
    }

    public <T extends Person> boolean removePerson(List<T> personList, T person) {
        return person != null && personList.remove(person);
    }


    public Person validateLogin(String email, String password) throws Exception {
        // Validar administrador
        if (administrator != null && administrator.getEmail().equals(email)
                && administrator.getPassword().equals(password)) {
            return administrator;
        }

        // Validar estudiantes
        for (Student student : studentList) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                return student;
            }
        }

        // Validar docentes
        for (Teacher teacher : teacherList) {
            if (teacher.getEmail().equals(email) && teacher.getPassword().equals(password)) {
                return teacher;
            }
        }

        // Si no se encontró un usuario válido, lanzar excepción
        throw new Exception("Usuario o contraseña incorrectos");
    }

    public boolean addSubject(Subject subject){
        Subject subjectFound = searchSubject(subject.getId());
        if(subjectFound == null) {
            subjectList.add(subject);
            return true;
        }
        return false;
    }

    private Subject searchSubject(String id){
        for(Subject subject: subjectList) {
            if(subject.getId().equals(id)){
                return subject;
            }
        }
        return null;
    }

    public boolean assignSubjectToStudent(Student student, Subject subject) {
        if (student != null && subject != null) {
            // Asignar la materia al estudiante
            student.addSubject(subject);
            return true;  // Materia asignada exitosamente
        }
        return false;  // El estudiante o la materia son nulos
    }


}
