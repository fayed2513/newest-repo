import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
if(args==null||args.length!=1){
    System.out.println("Wrong Argument");
    return;
}
//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                                                new InputStreamReader(
                                                new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                String studentList[] = readLine.split(",");
                for (String elements : studentList) {
                    System.out.println(elements);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
						           new InputStreamReader(
                                   new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                String studentList[] = readLine.split(",");
                Random random = new Random();
                int number = random.nextInt(studentList.length);
                System.out.println(studentList[number].trim());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                                   new FileWriter("students.txt", true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String date_formated = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(date_formated);
                String formatted = dateFormat.format(date);
                bufferedWriter.write(", " + substring + "\nList last updated on " + formatted);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                                   new InputStreamReader(
                                   new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                String studentList[] = readLine.split(",");
                boolean done = false;
                String substring = args[0].substring(1);
                for (int idx = 0; idx < studentList.length && !done; idx++) {
                    if (studentList[idx].trim().equals(substring)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                                   new InputStreamReader(
                                   new FileInputStream("students.txt")));
                String list = bufferedReader.readLine();
                char charArray[] = list.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char elements : charArray) {
                    if (elements == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(bufferedReader) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else{
            System.out.println("Wrong Argument");
        }
    }
}