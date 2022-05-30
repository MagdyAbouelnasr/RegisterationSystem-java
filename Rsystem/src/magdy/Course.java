
package magdy;
import java.util.*;


public class Course {

    private int courseID;
    private String courseName;
    private int numberofRegisteredStudents;
    // Lecturer lecturer;
    private ArrayList<Lecturer> lecturers = new ArrayList<>();

    Course(int id , String name){
        courseID=id;
        courseName=name;
        numberofRegisteredStudents = 0;
    }

    public void IncrementNumberOfStudents(){
        ++numberofRegisteredStudents;
    }
    public void DecrementNumberOfStudents(){
        --numberofRegisteredStudents;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public void removeLecturer(Lecturer lecturer){
        for(int i =0;i<lecturers.size();i++){
            if(lecturers.get(i).getLecturerID()==lecturer.getLecturerID())
                lecturers.remove(i);
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLecturerNames(){
        String s="";
        for(int i =0 ;i<lecturers.size();i++)
        s+="\n# " + (i+1) + " : name : " + lecturers.get(i).getLecturerName();
        return s;
    }

    public String Information() {
            return "courseID : " + courseID + "\n course Name : " + courseName + "\n Number of Registered Students =  " + numberofRegisteredStudents  + " \n Lecturer name/s : " + getLecturerNames() +"\n\n" ;
        }

}
