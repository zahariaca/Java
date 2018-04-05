package com.azaharia.main;

import com.azaharia.dataexceptionhandling.DataException;
import com.azaharia.student.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 11/4/2016.
 */
public class WriteDataToFile {
    final static String fileName = "Students" + new Date().getTime() + ".txt";


    public static void main(String[] args) {
        List<Student> students =null;
        BufferedWriter bw= null;
        try {
           students = MockData.getInstance().getAllStudents();
        } catch (DataException e) {
            e.printStackTrace();
        }
        try {
            bw = new BufferedWriter(new FileWriter(new File(fileName).getAbsoluteFile()));
            if(students!=null) {
                for (Student student : students) {
                    System.out.println(student);
                    bw.write(student.toString());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
