package org.studentoperations;
import java.util.Scanner;
import java.io.*;
import org.student.Student;
import org.patron.Patron;

public class StudentOperations {
    File file = new File("H:\\java\\all java code\\Final project\\org\\studentoperations\\data.txt");
    FileWriter fileWriter = null;
    FileReader fileReader=null;
    String line;
    boolean isContaintFound;
    int count;
    Scanner in=new Scanner(System.in);
    String id;
    char choice;

    public void insertStudent(Student S){
        System.out.println("Enter  student's libary ID: ");
        int lid=in.nextInt();
        S.setId(lid);
        in.nextLine();
        System.out.println("Enter  student ID: ");
        String sid=in.nextLine();
        S.setStudentId(sid);
        System.out.println("Enter  student Name: ");
        String sname=in.nextLine();
        S.setName(sname);
        System.out.println("Enter  student Depertment Name: ");
        String sdepartmentName=in.nextLine();
        S.setDepartmentName(sdepartmentName);
        System.out.println("Enter  student email: ");
        String semail=in.nextLine();
        S.setEmail(semail);
        System.out.println("Enter  student contactNo: ");
        String scontactNo=in.nextLine();
        S.setContactNo(scontactNo);
        System.out.println("Enter  student address: ");
        String saddress=in.nextLine();
        S.setAddress(saddress);
        System.out.println("Enter  student amount: ");
        double samount=in.nextDouble();
        in.nextLine();
        S.setAmount(samount);
        System.out.println("Enter  student Gardian Name: ");
        String sguardianName=in.nextLine();
        S.setGuardianName(sguardianName);
        System.out.println("Enter  student guardian Contact No: ");
        String sguardianContactNo=in.nextLine();
        S.setGuardianContactNo(sguardianContactNo);

        System.out.println("\n\nPlease check all information:");
        S.showInfo();
        System.out.println("Is all the information correct?(y/n)");
        choice=in.next().charAt(0);
        if(choice=='y'){
            try {
            
                fileWriter = new FileWriter(file, true);
                 fileWriter.write("\nLibrary ID: "+S.getId()+"\nStudent ID: " + S.getStudentId() + "\nName: "+ S.getName() +"\nDepartment Name: "+ S.getDepartmentName() +
                 "\nEmail: "+ S.getEmail()+"\nContact No: "+ S.getContactNo()+ "\nAddress: " + S.getAddress()+"\nAmount: "+S.getAmount()+
                 "\nGurdian Name: "+ S.getGuardianName()+ "\nGurdian Contact No: "+ S.getGuardianContactNo());
                 System.out.println("\n\t\t\tInformation Sucessfully added!!!\t\t\t");
            }
            catch(IOException io) {
                System.out.println("IOException caught!!");
            }
            finally {
                try {
                    fileWriter.close();
                }
                catch(IOException io) {
                    System.out.println("Can not close the resource!!");
                }
            }
        }
        else{
            System.out.println("Please Try Again");
        }
    }
        

    public void removeStudent(Student s){
        line=null;
        isContaintFound=false;
        count = 0;
        int numberOfLineDlete=8;
        String input="";
        try{
            fileReader = new FileReader(file);
            BufferedReader linRead= new BufferedReader(fileReader);
            while ((line = linRead.readLine()) != null) {
                if (line.contains(id)) {
                    isContaintFound = true;
                    line=null;
                    count++;
                    continue;
                }
                else if(isContaintFound && count < numberOfLineDlete){
                    count++;
                    line=null;
                }
                else if (isContaintFound && count == numberOfLineDlete) {
                    line=null;
                    isContaintFound = false;
                }
                else{
                    input += line + '\n';
                }
            }
            fileWriter = new FileWriter(file);
            fileWriter.write(input);
            System.out.println("Student Successfully Deleted!!!");
        }
        catch(IOException io) {
            System.out.println("IOException caught!!");
        }
        finally {
            try {
                fileWriter.close();
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Can not close the resource!!");
            }
        }

    }


    public Student getStudent(int studentID){
        Student st=new Student();
        id = Integer.toString(studentID);
        int numberOfLinePrint=9;
        try{

            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line=null;
            isContaintFound=false;
            count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(id)) {
                    isContaintFound = true;
                    System.out.println(line);
                    count++;
                    continue;
                }
                else if(isContaintFound && count < numberOfLinePrint){
                    count++;
                    System.out.println(line);
                }
                else if (isContaintFound && count == numberOfLinePrint) {
                    System.out.println(line);
                    isContaintFound = false;
                }
            }
        }
        catch(IOException io) {
            System.out.println("IOException caught!!");
        }
        finally {
            try {
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Can not close the resource!!");
            }
        }

        System.out.println("Do you went to delete this student?(y/n)");
        choice=in.next().charAt(0);
        if(choice=='y'){
            this.removeStudent(st);
        }else{
            
        }
        return st;
    }
    public void showAllStudents(){
        try{

            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException io) {
            System.out.println("IOException caught!!");
        }
        finally {
            try {
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Can not close the resource!!");
            }
        } 
    } 
}
