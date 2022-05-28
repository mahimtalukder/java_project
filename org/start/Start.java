package org.start;
import org.student.Student;
import org.patron.Patron;
import org.studentoperations.StudentOperations;
import org.teacher.Teacher;
import org.teacheroperations.TeacherOperations;
import org.basicoperations.BasicOperations;

import org.author.*;
import org.publisher.*;
import org.book.Book;
import org.bookoperations.*;

import java.util.Scanner;

public class Start{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        StudentOperations studentoperations=new StudentOperations();
        Student student=new Student();

        TeacherOperations teacheroperations=new TeacherOperations();
        Teacher teacher=new Teacher();

        BookOperations bookoperations=new BookOperations();
        Book book=new Book();

        BasicOperations basicoperations=new BasicOperations();
        Patron patrons ;

        System.out.println("\n\t **** Welcome to AIUB library Management System ****");
        int i=1;
        while(i!=-1){
            System.out.println("\n\t\t\tMAIN MENU\n\t\t=====================\n\t\t[1] Student Management\n\t\t[2] Teacher Management\n\t\t[3] Book Management\n\t\t[4] Basic Operations\n\t\t[5] Exit\n\t\t=================\n\t\t");
            System.out.println("Enter the choice:");
            int choice=in.nextInt();
           
            if(choice==1){
                while(i!=-2){
                    System.out.println("\n\t\tStudent Management\n\t\t=====================\n\t\t[1] Insert New Student\n\t\t[2] Search by studentId\n\t\t[3] Show All Student\n\t\t[4] Main Manu\n\t\t=================\n\t\t");
                    System.out.println("Enter the choice:");
                    int student_choice =in.nextInt();
                    if(student_choice==1){
                        studentoperations.insertStudent(student);
                        continue;
                   }
                    else if(student_choice==2){
                        System.out.println("Enter student's libray ID:");
                        int id=in.nextInt();
                        studentoperations.getStudent(id);
                        continue;
                    }
                    else if(student_choice==3){
                        studentoperations.showAllStudents();
                        continue;
                    }
                    else{
                        break;
                    }

                }
            }

            else if(choice==2){
                while(i!=-2){
                    System.out.println("\n\t\tTeacher Management\n\t\t=====================\n\t\t[1] Insert New Teacher\n\t\t[2] Search by teacherId\n\t\t[3] Show All Teacher\n\t\t[4] Main Manu\n\t\t=================\n\t\t");
                    System.out.println("Enter the choice:");
                    int teacher_choice =in.nextInt();
                    if(teacher_choice==1){
                        teacheroperations.insertTeacher(teacher);
                        continue;
                    }
                
                    else if(teacher_choice==2){
                        System.out.println("Enter teacher's libray ID:");
                        int id=in.nextInt();
                        teacheroperations.getTeacher(id);
                        continue;
                    }
                    else if(teacher_choice==3){
                        teacheroperations.showAllTeachers();
                        continue;
                    }
                    else{
                        break;
                    }
                
               }
                
           }
           else if(choice==3){
            while(i!=-2){
                System.out.println("\n\t\tBook Management\n\t\t=====================\n\t\t[1] Insert New Book\n\t\t[2] Search by bookId\n\t\t[3] Show All Books\n\t\t[4] Main Manu\n\t\t=================\n\t\t");
                System.out.println("Enter the choice:");
                int teacher_choice =in.nextInt();
                if(teacher_choice==1){
                    bookoperations.insertBook(book);
                    continue;
                }
            
                else if(teacher_choice==2){
                    System.out.println("Enter Book ID:");
                    int id=in.nextInt();
                    bookoperations.getBook(id);
                    continue;
                }
                else if(teacher_choice==3){
                    bookoperations.showAllBooks();
                    continue;
                }
                else{
                    break;
                }
            
           }
           }

           else if(choice==4){
            while(i!=-2){
                System.out.println("\n\t\t Book Borrow/Return/Lost Management:\n\t\t=====================\n\t\t[1] Borrow book\n\t\t[2] Return Book\n\t\t[3] Add Fine\n\t\t[4] Main Manu\n\t\t=================\n\t\t");
                System.out.println("\tEnter the choice:");
                int basic_choice =in.nextInt();

                if(basic_choice == 1){
                    patron=student;
                    basicoperations.borrow(patron,book);
                    continue;
                }
            
                else if(basic_choice == 2){
                    patron=teacher;
                    basicoperations.returnBook(patron,book);
                    continue;
                }
                else if(basic_choice==3){
                    double amount;
                    patron=student;
                    System.out.println("\n1.For book lost = 1000 taka\n2.For late return = 100 taka");
                    int fine_choice=in.nextInt();

                    if(fine_choice==1){
                        amount=1000;
                        basicoperations. fine(patron,amount);
                    }
                    
                    else if(fine_choice==2){
                        amount=100;
                        basicoperations. fine(patron,amount);
                    }
                    
                    continue;
                }
                else{
                    break;
                }
            
           }
           }

            else {
                System.out.println("\n\t\t\tThank yow\t\t\t");
                break;
            }
            
        }
        
    }
}