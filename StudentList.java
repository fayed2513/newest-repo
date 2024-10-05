import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
if(args==null||args.length!=1){
    System.out.println(Constants.message);
    return;
}
        String readLine = fileReader(Constants.studentFile);
//		Check arguments
        if (args[0].equals(Constants.student_list)) {
            System.out.println(Constants.loading);
            try {
                String studentList[] = readLine.split(Constants.splitAt);
                for (String elements : studentList) {
                    System.out.println(elements);
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        } else if (args[0].equals(Constants.random)) {
            System.out.println(Constants.loading);
            try {

                String studentList[] = readLine.split(Constants.splitAt);
                Random random = new Random();
                int number = random.nextInt(studentList.length);
                System.out.println(studentList[number].trim());
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.addStudent)) {
            System.out.println(Constants.loading);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                                   new FileWriter(Constants.studentFile, true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String date_formated = Constants.timeFormat;
                DateFormat dateFormat = new SimpleDateFormat(date_formated);
                String formatted = dateFormat.format(date);
                bufferedWriter.write(Constants.splitAt + substring +Constants.lastUpdate+ formatted);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.presentOrNot)) {
            System.out.println(Constants.loading);
            try {

                String studentList[] = readLine.split(Constants.splitAt);
                boolean done = false;
                String substring = args[0].substring(1);
                for (int idx = 0; idx < studentList.length && !done; idx++) {
                    if (studentList[idx].trim().equals(substring)) {
                        System.out.println(Constants.isFound);
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        } else if (args[0].equals(Constants.Student_count)) {
            System.out.println(Constants.loading);
            try {
                char charArray[] = readLine.toCharArray();
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
                System.out.println(count + Constants.wordBuffer);
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        }
        else{
            System.out.println(Constants.message);
        }
    }

    public static String fileReader(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                                            new InputStreamReader(
                                            new FileInputStream(Constants.studentFile)));
            return bufferedReader.readLine();
        } catch (Exception e) {
            return null;
        }
    }
}