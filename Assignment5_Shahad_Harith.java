// Shahad Harith - 1707861 - CA1 - COCS202
// FCIT grade management

package assignment5_shahad_harith;

import java.util.*;
public class Assignment5_Shahad_Harith {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------");
        System.out.println("------    Welcome to the FCIT Grade Management System    ------");
        System.out.println("---------------------------------------------------------------");
        System.out.print(" > Please enter the name of your course (ex: COCS-101): ");
        String courseName = scan.nextLine();
        int numberOfStudents=0;
        do{
        System.out.print(" > How many students are in your "+courseName+" section : ");
        numberOfStudents = input.nextInt();
        if (numberOfStudents<=0)
            System.out.println("    Sorry! Number should be > 0 !. Please try again ! ");
        }while (numberOfStudents<=0);
        String [] studentsNames  = new String [numberOfStudents];
        double [] studentsGrades = new double [numberOfStudents];
        
        double total = 0;
        addStudents(studentsGrades,studentsNames,numberOfStudents,courseName,total);
             
   }
   
    public static void addStudents(double [] studentsGrades,String [] studentsNames,int numberOfStudents,String courseName,double total){
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        for (int i=0;i<studentsNames.length;i++){
        System.out.println("Student "+i+" information");
        System.out.print("  > Please enter student name : ");
        studentsNames[i]= scan.nextLine();
        do{
        System.out.print("  > Please enter student grade : ");
        studentsGrades[i]= input.nextDouble();
       if (studentsGrades[i]<0 || studentsGrades[i]>100)
            System.out.println("    Sorry ! Number should be >=0 and <=100 !Please try again ! ");
        total += studentsGrades[i];
        
        }while (studentsGrades[i]<0 || studentsGrades[i]>100);
   }
        printMenu(studentsGrades,studentsNames,numberOfStudents,courseName,total);
    }
    public static int printMenu(double [] studentsGrades,String [] studentsNames,int numberOfStudents,String courseName,double total){
        Scanner input = new Scanner(System.in);
        
        do{
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("------            FCIT Grade Management System           ------");
        System.out.println("------                    *MAIN MENU*                    ------");
        System.out.println("---------------------------------------------------------------");
        System.out.println(" | 1 : Enter 1 for Changing student grade                    | ");
        System.out.println(" | 2 : Enter 2 for printing students details                 | ");
        System.out.println(" | 3 : Enter 3 for printing the course statistics            | ");
        System.out.println(" | 4 : Enter 4 or a for exiting the program                  | ");
        System.out.print("   > Please enter your choice : ");
        int choice = input.nextInt();
        switch (choice){
            case 1 : changeGrade(studentsGrades,numberOfStudents);break;
            case 2 : printStudentInformation(studentsGrades,studentsNames);break;
            case 3 : printCourseInformation(studentsGrades,courseName,numberOfStudents,total);break;
            case 4 : System.exit(0);
            default : System.out.println("  Invaild selection . Please try again ! ");
        }
        } while (true);
       
    }
    
    public static void changeGrade(double [] studentsGrades , int numberOfStudents ){
        Scanner input = new Scanner(System.in);
        int i;
        do{
            System.out.print("> Please enter student number : ");
            i = input.nextInt();
            if (i < 0 ||i >=  numberOfStudents )
                System.out.println("    Sorry ! Number should be >=0 and less than or equal "+(numberOfStudents-1)+" !Please try again ! ");
            
        }while (i < 0 ||i >=  numberOfStudents);
        
        do {
        System.out.print("> Please enter student grade : ");
        studentsGrades[i]= input.nextDouble();
        if (studentsGrades[i]<0 || studentsGrades[i]>100)
            System.out.println("    Sorry ! Number should be >=0 and <=100 !Please try again ! ");
        
        }while (studentsGrades[i]<0 || studentsGrades[i]>100);
    
    
    }
    public static char gradeLetter(double grade){
        char gradeLetter ='e';
            if (grade>=90)
               gradeLetter ='A';
             
            else if (grade>=80)
               gradeLetter='B';
               
            else if (grade>=70)
               gradeLetter='C';
               
            else if (grade>=60)
               gradeLetter='D';
              
            else 
               gradeLetter='F';
            
        return gradeLetter;
        
    }
            
            
    public static void printStudentInformation(double [] studentsGrades,String [] studentsNames){
        System.out.println(" > ID\t\tName\t\tGrade\t\tGradeLetter");
        System.out.println(" > ----------------------------------------------------------");
        for (int i=0;i<studentsNames.length;i++)
        System.out.println(" > "+i+"\t\t"+studentsNames[i]+"\t\t"+studentsGrades[i]+"\t\t"+gradeLetter(studentsGrades[i]));
        
    }
    
    public static void printCourseInformation(double [] studentsGrades,String courseName,int numberOfStudents,double total){
        System.out.println();
        System.out.println(" > Course Details for "+courseName+" :");
        System.out.println(" >    Number of students : "+numberOfStudents);
        System.out.println(" >    Average Grade :"+(int)((total/numberOfStudents)*10.0)/10.0);
        int [] count = new int [5];
        for (int i=0;i<studentsGrades.length;i++){
        if (studentsGrades[i]>=90)
               count[0]+=1;
             
            else if (studentsGrades[i]>=80)
               count[1]+=1;
            
            else if (studentsGrades[i]>=70)
               count[2]+=1;
            
            else if (studentsGrades[i]>=60)
               count[3]+=1;
            
            else 
               count[4]+=1;
        }
            
        System.out.println(" >    Number of A's : "+count[0]);
        System.out.println(" >    Number of B's : "+count[1]);
        System.out.println(" >    Number of C's : "+count[2]);
        System.out.println(" >    Number of D's : "+count[3]);
        System.out.println(" >    Number of F's : "+count[4]);
        
        
    }
    
    
}
