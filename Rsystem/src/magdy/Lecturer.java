
package magdy;
import java.util.*;

public class Lecturer {
    private int lecturerID;
    private String lecturerName;
     ArrayList<Course> courses = new ArrayList<>();

    Lecturer( int id , String name){
        this.lecturerID=id;
        this.lecturerName=name;
    }

    public void AddCourse(Course course) {
        courses.add(course);
    }


    public int getLecturerID() {
        return lecturerID;
    }

    public boolean PreRegistered(int cid){
        boolean k=false;
        for(int j=0;j<courses.size();j++){
            if(courses.get(j).getCourseID()==cid){
               // System.out.println("Course ID already registered");
                k=true;
            }
        }
        return k;
    }

    public void Registered(){
        for(int i =0 ; i<courses.size();i++)
            System.out.println("Course #" + (i+1) + " Name: " + courses.get(i).getCourseName() + " Course id : " + courses.get(i).getCourseID() );

    }

    public String getLecturerName() {
        return lecturerName;
    }

    public String Information() {
            return "LecturerID : " + lecturerID+ "\n Lecturer Name : " + lecturerName + "\n Number of Courses taught =  " + courses.size() +"\n\n" ;
    }
/*
    public void DisplayCourses(){
        for(int i =0;i<courses.size();i++)
            System.out.println("Course #" + (i+1) + " " + courses.get(i).getCourseName() + " Course id : " + courses.get(i).getCourseID() + "\n\n");
    }*/
}
