
package org.basicoperations;

import java.io.*;
import java.util.Scanner;
import org.book.Book;
import org.bookoperations.BookOperations;
import org.patron.Patron;
import org.studentoperations.StudentOperations;
import org.teacheroperations.TeacherOperations;

interface IBasicOperations{
  public void borrow(Patron p, Book b);
  public void returnBook(Patron p, Book b);
  public void fine(Patron p, double ammount);
}

public class BasicOperations implements IBasicOperations{
  File file = null;
  FileReader fileReader = null;
  FileWriter fileWriter = null;

  String line;
  Scanner in = new Scanner(System.in);
  Boolean bool2 = false;
  String str=null;
  char choice;

  BookOperations bookOp;
  TeacherOperations teachOp;
  StudentOperations studentOp;
  public static String str2;
  

  public void borrow(Patron patron, Book book) {

    System.out.println("Enter Book ID: ");
    String id=in.nextLine();
    
    str2 = "";
    boolean bool = false;
    boolean bool1 = false;

    try{
      this.file = new File("H:\\java\\all java code\\Final project\\org\\bookoperations\\data.txt");
      this.fileReader = new FileReader(this.file);
      BufferedReader bufferedReader = new BufferedReader(this.fileReader);

        while ((this.line = bufferedReader.readLine()) != null){
          if (this.line.contains(id)){
            bool = true;
          }
        }
      }
      catch(IOException io){
          
      }

      try{
        fileReader.close();
      }
      catch(IOException io){
          
      }

      if (bool){
        System.out.println("Who went to borrow book?(1. Teacher or 2. Student)");
        int i = this.in.nextInt();
        in.nextLine();


        if(i==2){
          byte b2 = 7;
          byte b1 = 0;

          System.out.println("Enter Student Library ID: ");
          String lid = in.nextLine();

          try{
            this.file = new File("H:\\java\\all java code\\Final project\\org\\studentoperations\\data.txt");
            this.fileReader = new FileReader(this.file);
            BufferedReader bufferedReader1 = new BufferedReader(this.fileReader);

            while ((this.line = bufferedReader1.readLine()) != null){
              if (this.line.contains(lid))
              bool2 = Boolean.valueOf(true);
            }
          }
          catch(IOException io){
                
          }
          try{
              fileReader.close();
            }
            catch(IOException io){
                
            }

            if(bool2){
              try{
                this.file = new File("H:\\java\\all java code\\Final project\\org\\studentoperations\\data.txt");
                this.fileReader = new FileReader(this.file);
                BufferedReader bufferedReader2 = new BufferedReader(this.fileReader);

                while ((this.line = bufferedReader2.readLine()) != null){
                  if (this.line.contains(lid)){
                    str2 +=  line+ "\n";
                    System.out.println(this.line);
                    bool1 = true;
                    b1++;
                    continue;
                  }

                  else if (bool1 && b1 <= 2){
                    str2 += line+ "\n";
                    System.out.println(this.line);
                    bool1 = true;
                    b1++;
                    continue;
                  }

                  else if(bool1 && b1 > 2 && b1 < b2){
                    b1++;
                    continue;
                  }

                  else if (bool1 && b1 == b2){
                    str2 += line+ "\n";
                    System.out.println(this.line+"\n\n");
                    bool1 = false;
                    b1++;
                  }
                }
              }
              catch(IOException io){
                    
              }
              try{
                fileReader.close();
              }
              catch(IOException io){
                    
              }
                

              try{
                  this.file = new File("H:\\java\\all java code\\Final project\\org\\bookoperations\\data.txt");
                  this.fileReader = new FileReader(this.file);
                  BufferedReader bufferedReader3 = new BufferedReader(this.fileReader);
                  byte b = 10;
                  b1 = 0;

                  while ((this.line = bufferedReader3.readLine()) != null){
                    if (this.line.contains(id)){
                      str2 += line+ "\n";
                      System.out.println(this.line);
                      bool1 = true;
                      b1++;
                      continue;
                    }

                    else if(bool1 && b1 < b){
                      str2 += line+ "\n";
                      System.out.println(this.line);
                      bool1 = true;
                      b1++;
                      continue;
                    }

                    else if (bool1 && b1 == b){
                      str2 += line + "\n";
                      System.out.println(this.line);
                      bool1 = false;
                       b1++;
                     }

                  }
                  
                }
                catch (IOException iOException){
                  System.out.println("IOException caught!! 104" + iOException);
                }
                

                  System.out.println("Do you went to borrow this book?(y/n)");
                  char c = this.in.next().charAt(0);

                  if (c == 'y'){
                    try{
                      this.file = new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
                      this.fileWriter = new FileWriter(this.file, true);
                      this.fileWriter.write(str2);
                      System.out.println("\t\t\tPlease collect book. Thank you!\t\t\t");
                    }
                    catch (IOException iOException){
                      System.out.println("IOException caught!! 104" + iOException);
                    }
                    try{
                      fileWriter.close();
                    }
                    catch(IOException io) {
                      System.out.println("Can not close the resource!!");
                    }
                  }
                
                  else{
                    System.out.println("\n\t\t\tTRY AGAIN\t\t\t");
                  }
                }
            
            else{
              System.out.println("\n\t\t\tStudent Not Found\t\t\t");
            }
          }







          else if(i==1){
            byte b2 = 7;
            byte b1 = 0;
  
            System.out.println("Enter Teacher Library ID: ");
            String lid = in.nextLine();
  
            try{
              this.file = new File("H:\\java\\all java code\\Final project\\org\\teacheroperations\\data.txt");
              this.fileReader = new FileReader(this.file);
              BufferedReader bufferedReader1 = new BufferedReader(this.fileReader);
  
              while ((this.line = bufferedReader1.readLine()) != null){
                if (this.line.contains(lid))
                bool2 = Boolean.valueOf(true);
              }
            }
            catch(IOException io){
                  
            }
            try{
                fileReader.close();
              }
              catch(IOException io){
                  
              }
  
              if(bool2){
                try{
                  this.file = new File("H:\\java\\all java code\\Final project\\org\\teacheroperations\\data.txt");
                  this.fileReader = new FileReader(this.file);
                  BufferedReader bufferedReader2 = new BufferedReader(this.fileReader);
  
                  while ((this.line = bufferedReader2.readLine()) != null){
                    if (this.line.contains(lid)){
                      str2 +=  '\n' +line+ "\n";
                      System.out.println(this.line);
                      bool1 = true;
                      b1++;
                      continue;
                    }
  
                    else if (bool1 && b1 <= 2){
                      str2 += line+ "\n";
                      System.out.println(this.line);
                      bool1 = true;
                      b1++;
                      continue;
                    }
  
                    else if(bool1 && b1 > 2 && b1 < b2){
                      b1++;
                      continue;
                    }
  
                    else if (bool1 && b1 == b2){
                      str2 += line+ "\n";
                      System.out.println(this.line+"\n\n");
                      bool1 = false;
                      b1++;
                    }
                  }
                }
                catch(IOException io){
                      
                }
                try{
                  fileReader.close();
                }
                catch(IOException io){
                      
                }
                  
  
                try{
                    this.file = new File("H:\\java\\all java code\\Final project\\org\\bookoperations\\data.txt");
                    this.fileReader = new FileReader(this.file);
                    BufferedReader bufferedReader3 = new BufferedReader(this.fileReader);
                    byte b = 10;
                    b1 = 0;
  
                    while ((this.line = bufferedReader3.readLine()) != null){
                      if (this.line.contains(id)){
                        str2 += line+ "\n";
                        System.out.println(this.line);
                        bool1 = true;
                        b1++;
                        continue;
                      }
  
                      else if(bool1 && b1 < b){
                        str2 += line+ "\n";
                        System.out.println(this.line);
                        bool1 = true;
                        b1++;
                        continue;
                      }
  
                      else if (bool1 && b1 == b){
                        str2 += line + "\n";
                        System.out.println(this.line);
                        bool1 = false;
                         b1++;
                       }
  
                    }
                    
                  }
                  catch (IOException iOException){
                    System.out.println("IOException caught!! 104" + iOException);
                  }
                  
  
                    System.out.println("Do you went to borrow this book?(y/n)");
                    char c = this.in.next().charAt(0);
  
                    if (c == 'y'){
                      try{
                        this.file = new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
                        this.fileWriter = new FileWriter(this.file, true);
                        this.fileWriter.write(str2);
                        System.out.println("\t\t\tPlease collect book. Thank you!\t\t\t");
                      }
                      catch (IOException iOException){
                        System.out.println("IOException caught!! 104" + iOException);
                      }
                      try{
                        fileWriter.close();
                      }
                      catch(IOException io) {
                        System.out.println("Can not close the resource!!");
                      }
                    }
                  
                    else{
                      System.out.println("\n\t\t\tTRY AGAIN\t\t\t");
                    }
                  }
              
              else{
                System.out.println("\n\t\t\tTeacher Not Found\t\t\t");
              }
          }

         }

         else{
          System.out.println("\n\t\t\tBook Not Found\t\t\t");
         }
        }






        public void returnBook(Patron p, Book b){
          in.nextLine();
          System.out.println("Enter student/teacher library ID: ");
          String libraryID=in.nextLine();
          Boolean found=false;

          try{
            file =new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
            fileReader=new FileReader(file);
            BufferedReader bufferedReader3 = new BufferedReader(this.fileReader);
            line="";

            while((line = bufferedReader3.readLine()) != null){
              if(line.contains(libraryID)){
                found=true;
              }
            }
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileReader.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          if(found){
            String input="";
            line=null;
            int numberOfLineDlete=13;
            int count=0;
            boolean isContaintFound=false;


            try{
              file =new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
              fileReader=new FileReader(file);
              BufferedReader linRead= new BufferedReader(fileReader);
              while ((line = linRead.readLine()) != null) {
                  if (line.contains(libraryID)) {
                    System.out.println(line);
                      isContaintFound = true;
                      line=null;
                      count++;
                      continue;
                  }
                  else if(isContaintFound && count < numberOfLineDlete){
                    System.out.println(line);
                      count++;
                      line=null;
                  }
                  else if (isContaintFound && count == numberOfLineDlete) {
                    System.out.println(line);
                      line=null;
                      isContaintFound = false;
                  }
                  else{
                      input += line + '\n';
                  }
              
              }
            }
            catch (IOException iOException){
              System.out.println("IOException caught!! 104" + iOException);
            }
            try{
              fileReader.close();
            }
            catch(IOException io) {
              System.out.println("Can not close the resource!!");
            }

            System.out.println("Do you went to return this book?(y/n)");
            char c = this.in.next().charAt(0);
  
            if (c == 'y'){
              try{
                this.file = new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
                this.fileWriter = new FileWriter(this.file);
                this.fileWriter.write(input);
                System.out.println("\t\t\tNow You can submit the book\t\t\t");
              }
              catch (IOException iOException){
                System.out.println("IOException caught!! 104" + iOException);
              }
              try{
                fileWriter.close();
              }
              catch(IOException io) {
                System.out.println("Can not close the resource!!");
              }

            }
            else{
              System.out.println("\n\t\t\tTry Again\t\t\t");
            }  
          }
          else{
            System.out.println("\n\t\t\tStudent/Teacher Not Found\t\t\t");
          }
          
        }
    
     
        







    public void fine(Patron p, double amount){
      System.out.println("Who went to give the fine?(1.Teacher or 2.Student)");
      int choice=in.nextInt();
      in.nextLine();

      if(choice==1){
        System.out.println("Enter teacher library ID: ");
        String teacher_id=in.nextLine();
        boolean teacher_found=false;
        int lineOFamount=7;
        int count=0;
        String editTeacher=new String();
        double teacher_amount;
        String tamount=new String();
        String newBasic=new String();

        try{
          file =new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
          fileReader=new FileReader(file);
          BufferedReader linRead= new BufferedReader(fileReader);
          while ((line = linRead.readLine()) != null){
            if(line.contains(teacher_id)){
              teacher_found=true;
            }
          }
        }
        catch (IOException iOException){
          System.out.println("IOException caught!! 104" + iOException);
        }
        try{
          fileReader.close();
        }
        catch(IOException io) {
          System.out.println("Can not close the resource!!");
        }

        if(teacher_found){
          try{
            teacher_found=false;
            file =new File("H:\\java\\all java code\\Final project\\org\\teacheroperations\\data.txt");
            fileReader=new FileReader(file);
            BufferedReader linRead2= new BufferedReader(fileReader);

            while ((line = linRead2.readLine()) != null){
              if(line.contains(teacher_id)){
                count++;
                teacher_found=true;
                continue;
              }
              else if(teacher_found && count<lineOFamount){
                count++;
                continue;
              }
              else if(teacher_found && count==lineOFamount){
                tamount=line;
                count++;
                break;
              }
            }
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileReader.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          String add_amount=(tamount.substring(8));
          teacher_amount= Double.valueOf(add_amount);
          teacher_amount=teacher_amount-amount;
          add_amount=Double.toString(teacher_amount);

          try{
            teacher_found=false;
            editTeacher=null;
            count=0;
            file =new File("H:\\java\\all java code\\Final project\\org\\teacheroperations\\data.txt");
            fileReader=new FileReader(file);
            BufferedReader linRead1= new BufferedReader(fileReader);
            while ((line = linRead1.readLine()) != null){
              if(line.contains(teacher_id)){
                editTeacher +=line +'\n';
                count++;
                teacher_found=true;
                continue;
              }
              if(teacher_found && count<lineOFamount){
                editTeacher +=line +'\n';
                count++;
                continue;
              }
              else if(teacher_found && count==lineOFamount){
                line=null;
                editTeacher += "Amount: "+add_amount+'\n';
                count++;
              }
              else{
                editTeacher +=line +'\n';
                continue;
              }

            }
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileReader.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          try{
            File file1 =new File("H:\\java\\all java code\\Final project\\org\\teacheroperations\\data.txt");
            fileWriter=new FileWriter(file1);
            fileWriter.write(editTeacher);
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileWriter.close();
            
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          try{
            teacher_found=false;
            count=0;
            int numberOfLineDlete=13;
            newBasic="";

            file =new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
            fileReader=new FileReader(file);
            BufferedReader linRead3= new BufferedReader(fileReader);
            while ((line = linRead3.readLine()) != null) {
              if(line.contains(teacher_id)){
                line=null;
                count++;
                teacher_found=true;
                continue;
              }
                if(teacher_found && count < numberOfLineDlete){
                  System.out.println(line);
                    count++;
                    line=null;
                }
                else if (teacher_found && count == numberOfLineDlete) {
                  System.out.println(line);
                    line=null;
                    teacher_found = false;
                }
                else{
                    newBasic += line + '\n';
                }
            
            }
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileReader.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          try{
            file =new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
            fileWriter=new FileWriter(file);
            fileWriter.write(newBasic);
            System.out.println("\n\t\t\tYour Fine was taken\t\t\t");
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileWriter.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

        }
        else{
          System.out.println("\n\t\t\tTeacher not found\t\t\t");
        }


      }








      else if(choice==2){
        System.out.println("Enter student library ID: ");
        String student_id=in.nextLine();
        boolean student_found=false;
        int lineOFamount=7;
        int count=0;
        String editStudent=new String();
        double student_amount;
        String tamount=new String();
        String newBasic=new String();

        try{
          file =new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
          fileReader=new FileReader(file);
          BufferedReader linRead= new BufferedReader(fileReader);
          while ((line = linRead.readLine()) != null){
            if(line.contains(student_id)){
              student_found=true;
            }
          }
        }
        catch (IOException iOException){
          System.out.println("IOException caught!! 104" + iOException);
        }
        try{
          fileReader.close();
        }
        catch(IOException io) {
          System.out.println("Can not close the resource!!");
        }

        if(student_found){
          try{
            student_found=false;
            file =new File("H:\\java\\all java code\\Final project\\org\\studentoperations\\data.txt");
            fileReader=new FileReader(file);
            BufferedReader linRead1= new BufferedReader(fileReader);

            while ((line = linRead1.readLine()) != null){
              if(line.contains(student_id)){
                count++;
                student_found=true;
                continue;
              }
              if(student_found && count<lineOFamount){
                count++;
                continue;
              }
              else if(student_found && count==lineOFamount){
                tamount=line;
                count++;
                break;
              }
            }
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileReader.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          String add_amount=(tamount.substring(8));
          student_amount= Double.valueOf(add_amount);
          student_amount=student_amount-amount;
          add_amount=Double.toString(student_amount);

          try{
            student_found=false;
            editStudent=null;
            count=0;
            file =new File("H:\\java\\all java code\\Final project\\org\\studentoperations\\data.txt");
            fileReader=new FileReader(file);
            BufferedReader linRead2= new BufferedReader(fileReader);
            while ((line = linRead2.readLine()) != null){
              if(line.contains(student_id)){
                editStudent +=line +'\n';
                count++;
                student_found=true;
                continue;
              }
              if(student_found && count<lineOFamount){
                editStudent +=line +'\n';
                count++;
                continue;
              }
              else if(student_found && count==lineOFamount){
                line=null;
                editStudent += "Amount: "+add_amount+'\n';
                count++;
              }
              else{
                editStudent +=line +'\n';
                continue;
              }

            }
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileReader.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          try{
            file =new File("H:\\java\\all java code\\Final project\\org\\studentoperations\\data.txt");
            fileWriter=new FileWriter(file);
            fileWriter.write(editStudent);
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileWriter.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          try{
            student_found=false;
            int numberOfLineDlete=13;
            newBasic="";
            count=0;

            file =new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
            fileReader=new FileReader(file);
            BufferedReader linRead3= new BufferedReader(fileReader);
            while ((line = linRead3.readLine()) != null) {
              if(line.contains(student_id)){
                line=null;
                count++;
                student_found=true;
                continue;
              }
                if(student_found && count < numberOfLineDlete){
                  System.out.println(line);
                    count++;
                    line=null;
                }
                else if (student_found && count == numberOfLineDlete) {
                  System.out.println(line);
                    line=null;
                    student_found= false;
                }
                else{
                    newBasic += line + '\n';
                }
            
            }
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileReader.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

          try{
            file =new File("H:\\java\\all java code\\Final project\\org\\basicoperations\\data.txt");
            fileWriter=new FileWriter(file);
            fileWriter.write(newBasic);
            System.out.println("\n\t\t\tYour Fine was taken\t\t\t");
          }
          catch (IOException iOException){
            System.out.println("IOException caught!! 104" + iOException);
          }
          try{
            fileWriter.close();
          }
          catch(IOException io) {
            System.out.println("Can not close the resource!!");
          }

        }
        else{
          System.out.println("\n\t\t\tStudent not found\t\t\t");
        }
      }

    }
    
 }