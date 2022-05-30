
package magdy;

import java.util.*;

public class Collage {
    Scanner input = new Scanner(System.in);
    private int collageID;
    private  String collageName;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Lecturer> lecturers = new ArrayList<>();
    public static Collage collage=null;

    private Collage(){
        this.collageID=1;
        this.collageName="AAST";
    }

     static Collage getCollage(){
        if (collage == null )
          return  collage = new Collage();
        else
           return collage;
    }

    public void AddCourse() {
        System.out.println("Enter name of course you would like to add: ");
        String cname = input.next();
        boolean a = true;
        System.out.println("Enter ID of course : ");
        int cID = input.nextInt();
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID()==cID){
                System.out.println("ID already opted in");
                a=false;
                break;
            }
        }
        if(a){
            Course course = new Course(cID,cname);
            courses.add(course);
            System.out.println("Course successfully added...");
        }
    }

    public void AddStudent() {
        System.out.println("Enter name of Student : ");
        String sname = input.next();
        boolean b = true;
        System.out.println("Enter ID of Student : ");
        int sID = input.nextInt();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getStudentID()==sID){
                System.out.println("ID already opted in");
                b=false;
                break;
            }
        }
        if(b){
            Student student = new Student(sID,sname);
            students.add(student);
            System.out.println("Student successfully registered...");
        }
    }

    public void AddLecturer() {
        System.out.println("Enter name of Lecturer : ");
        String lname = input.next();
        boolean c = true;
        System.out.println(" Enter ID of Lecturer : ");
        int lID = input.nextInt();
        for(int i=0;i<lecturers.size();i++){
            if(lecturers.get(i).getLecturerID()==lID){
                System.out.println("ID already opted in");
                c=false;
                break;
            }
        }
        if(c) {
            Lecturer lecturer = new Lecturer(lID, lname);
            lecturers.add(lecturer);
            System.out.println("Lecturer Successfully registered...");
        }
    }

    public void RegisterCourse() {
        System.out.println("Available students : ");
        StudentInfo();
            System.out.println(" please enter student id : ");
             int sid = input.nextInt();
             int cid ;
             boolean a=true;
             boolean z = false;


        for(int i =0; i<students.size();i++){
            if(students.get(i).getStudentID() == sid){

                System.out.println("Available courses:");
                CourseInfo();
                System.out.println(" Enter course id which you like to register :");
                cid = input.nextInt();
                boolean r = students.get(i).PreRegistered(cid);
                if(r) {
                    System.out.println("Course ID already registered ");
                    a = false;
                }
                else if(!r) {
                    for (int j = 0; j < courses.size(); j++) {
                        if (courses.get(j).getCourseID() == cid) {
                            courses.get(j).IncrementNumberOfStudents();
                            students.get(i).AddCourse(courses.get(j));
                            System.out.println("Successfull Reisteration");
                            a = false;
                        }
                    }
                }
                if(a)
                System.out.println("Course id is invalid ");
                z=true;
                break;
            }



        }
        if(!z)
            System.out.println("Student id not valid");

    }

    public  void RegisterCourseL() {
        System.out.println("available lecturers : ");
        LecturerInfo();
        System.out.println("please enter Lecturer id : ");
        int lid = input.nextInt();
        int cidl;
        boolean x = true;
        boolean y = false;

        for(int i =0; i<lecturers.size();i++){
            if (lecturers.get(i).getLecturerID() == lid){
                System.out.println("Available courses:");
                CourseInfo();
                System.out.println(" Enter course id which you like to register :");
                cidl = input.nextInt();
                boolean k = lecturers.get(i).PreRegistered(cidl);

                if(k) {
                    System.out.println("Course ID already registered");
                        x=false;
                }
                else if(!k){
                for(int j=0;j<courses.size();j++){
                    if(courses.get(j).getCourseID()==cidl){
                            lecturers.get(i).AddCourse(courses.get(j));
                            courses.get(j).setLecturer(lecturers.get(i));
                            System.out.println("Successfull Reisteration");
                            x=false;
                        }
                    }
                }
                    if(x)
                        System.out.println("Course id is invalid ");
                    y=true;
                    break;
            }
        }
        if(!y)
            System.out.println("Lecturer id is invalid");

    }

    public void DisplayPstuddent(){
        System.out.println(" Enter id of student to display list of courses :");
        int dsid = input.nextInt();
        boolean l = true;
        for(int i =0; i<students.size();i++){
            if(students.get(i).getStudentID() == dsid){
                System.out.println("\n Registered Courses : ");
                students.get(i).Registered();
                l=false;
                break;
            } }
        if(l)
        System.out.println("Student id not registered");
    }

    public void DisplayPlecturer(){
        System.out.println(" Enter id of lecturer to display list of courses :");
        int dlid = input.nextInt();
        boolean l = true;
        for(int i =0; i<lecturers.size();i++){
            if(lecturers.get(i).getLecturerID() == dlid){
                System.out.println("\n Registered Courses : " );
                lecturers.get(i).Registered();

                l=false;
                break;
            } }
        if(l)
        System.out.println("Lecturer id not registered");
    }

    public void RemoverCourse(){
        System.out.println("Available courses : ");
        CourseInfo();
        System.out.println("Enter course id to remove : ");
        int id = input.nextInt();
        boolean x = true;
        for(int j=0;j<courses.size();j++){
            if(courses.get(j).getCourseID()==id){

                for(int i =0 ; i < lecturers.size();i++){
                    for(int k=0 ; k<lecturers.get(i).courses.size();k++){
                        if(lecturers.get(i).courses.get(k).getCourseID()==id)
                            lecturers.get(i).courses.remove(k);
                    }
                }

                for(int l =0 ; l < students.size();l++){
                    for(int p=0 ; p<students.get(l).courses.size();p++){
                        if(students.get(l).courses.get(p).getCourseID()==id)
                            students.get(l).courses.remove(p);
                    }
                }
                   courses.remove(j);
                x=false;
            }
        }
        if(x)
            System.out.println("Course id is invalid");
    }

    public void RemoverStudent(){

        System.out.println("Available Students :");
        StudentInfo();
        System.out.println("Enter student id to remove : ");
        int id = input.nextInt();
        boolean b = true;
        for(int j=0;j<students.size();j++){
            if(students.get(j).getStudentID()==id){

                for(int y =0 ; y < students.get(j).courses.size();y++){
                    int courseid=students.get(j).courses.get(y).getCourseID();
                    for(int k =0 ; k < courses.size() ; k++){
                        if(courses.get(k).getCourseID()==courseid)
                            courses.get(k).DecrementNumberOfStudents();
                    }
                }
                students.remove(j);
                System.out.println("Student removed successfully...");
                b=false;
            }
        }
        if(b)
            System.out.println("Student id is invalid");
    }

    public void RemoverLecturer(){
        System.out.println("Available lecturers: ");
        LecturerInfo();
        System.out.println("enter lecturer id to remove : ");
        int id = input.nextInt();
        boolean n = true;
        for(int j=0;j<lecturers.size();j++){
            if(lecturers.get(j).getLecturerID()==id){

                for(int y =0 ; y < lecturers.get(j).courses.size();y++){
                    int courseid=lecturers.get(j).courses.get(y).getCourseID();
                    for(int k =0 ; k < courses.size() ; k++){
                        if(courses.get(k).getCourseID()==courseid)
                            courses.get(k).removeLecturer(lecturers.get(j));
                    }
                }
                lecturers.remove(j);
                System.out.println("Lecturer removed successfully...");
                n=false;
            }
        }
        if(n)
            System.out.println("Lecturer id is invalid");
    }

    public void CourseInfo(){
        for(int i =0; i <courses.size();i++)
            System.out.println(courses.get(i).Information());
    }

    public void LecturerInfo(){
        for(int i =0;i<lecturers.size();i++)
            System.out.println(lecturers.get(i).Information());
    }

    public void StudentInfo(){
        for(int i =0;i<students.size();i++)
            System.out.println(students.get(i).Information());
    }

    public  int getCollageID() {
        return collageID;
    }

    public  String getCollageName() {
        return collageName;
    }

    public  String Info() {
        return "Collage{" + "collageID=" + collageID + ", collageName=" + collageName + ", Number of courses = " + courses.size() + ", Numbers of lecturerc=" + lecturers.size() + ", Number of students = " + students.size() + '}';
    }

}



