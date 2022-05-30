
package magdy;

import java.util.*;

public class Student {
    private int studentID;
    private String studentName;
     ArrayList<Course> courses = new ArrayList<>();

    Student(int id , String name){
        this.studentID=id;
        this.studentName=name;
    }

    public void AddCourse(Course course){
        courses.add(course);
    }
    public void RemoveCourse(Course course){

    }

    public boolean PreRegistered(int cid){
        boolean r=false;
        for(int j=0;j<courses.size();j++){
            if(courses.get(j).getCourseID()==cid){
              //  System.out.println("Course already registered");
                r=true;
            }
        }
        return r;
    }

    public void Registered(){
        for(int i =0;i<courses.size();i++)
            System.out.println("Course #" + (i+1) + " Name: " + courses.get(i).getCourseName() + " Course id : " + courses.get(i).getCourseID() );
    }

    public  int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public  String Information() {
            return  "StudentID : " + studentID+ "\n Student Name : " + studentName + "\n Number of Registered courses =  " + courses.size() + "\n\n" ;
    }

    public  void DisplayCourses(){
        for(int i=0 ; i <  courses.size() ; i++)
            System.out.println((i+1) + ") " + courses.get(i).getCourseName());
        }
    }
