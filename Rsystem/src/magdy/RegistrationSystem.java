
package magdy;

import java.util.*;

public class RegistrationSystem {

    private static Scanner input = new Scanner(System.in);


    public static void main(String[] args)  {
        Collage collage = Collage.getCollage();
        System.out.println(collage.getCollageName() + " ID : " + collage.getCollageID());

        while(true){

            System.out.println("MAIN MENU");

            System.out.println("\t1. Add a course"
                    + "\n\t2. Add a student"
                    + "\n\t3. Add a lecturer"
                    + "\n\t4. Register a course for a student"//enter student id
                    + "\n\t5. Register a course for a lecturer"//enter lecturer id
                    + "\n\t6. Display college information"
                    + "\n\t7. Display the complete list of courses"
                    + "\n\t8. Display the complete list of students"
                    + "\n\t9. Display the complete list of lecturers"
                    + "\n\t10. Display a list of courses currently taken by a particular student"
                    + "\n\t11. Display a list of courses currently taken by a particular lecturer"
                    + "\n\t12. Remove a course"
                    + "\n\t13. Remove a student"
                    + "\n\t14. Remove a lecturer"
                    + "\n\t15. Exit");

            int choice;
            while(true){
                System.out.println("Enter number for choice: ");
                choice = input.nextInt();
                if(choice>0&&choice<16)

                    break;

                else
                    System.out.println("Wrong input");
            }


            switch (choice)
            {   case 1 :
                        collage.AddCourse();
                break;

                case 2 :
                        collage.AddStudent();
                    break;
                case 3 :
                        collage.AddLecturer();
                    break;


                case 4 :
                    collage.RegisterCourse();
                    break;


                case 5 :
                   collage.RegisterCourseL();
                    break;


                case 6 :
                    System.out.println(collage.Info()+"\n\n");
                    break;

                case 7 :
                    collage.CourseInfo();
                    break;
                case 8 :
                    collage.StudentInfo();
                    break;
                case 9  :
                    collage.LecturerInfo();
                    break;


                case 10 :
                    collage.DisplayPstuddent();
                    break;


                case 11 :
                    collage.DisplayPlecturer();
                    break;

                case 12 :
                    collage.RemoverCourse();
                    break;

                case 13 :
                    collage.RemoverStudent();
                    break;

                case 14 :
                    collage.RemoverLecturer();
                    break;
                case 15 :
                    System.exit(0);
                    break;


            }

//      System.out.println("any input to continue");
//     String s =input.next();
            // TimeUnit.SECONDS.sleep(5);
            //TimeUnit.SECONDS.sleep(10);
            // Thread.sleep(secondsToSleep * 1000);
            //wait(100);


        }

    }

}
