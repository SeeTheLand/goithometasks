package com.dermentli.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static com.dermentli.util.Print.*;


public class SolutionTwo {
    public static void main(String[] args) throws IOException {
        //reader initialization
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //name
        print("имя");
        String name = reader.readLine();
        //surname
        print("фамилию");
        String surname = reader.readLine();
        //age
        print("возраст");
        String sAge = reader.readLine();
        int nAge = Integer.parseInt(sAge);
        //placeOfBirth
        print("город рождения");
        String placeOfBirth = reader.readLine();
        //placeOfLiving
        print("город проживания");
        String placeOfLiving = reader.readLine();
        //genedr
        print("пол");
        String gender = reader.readLine();
        //screen output as per task
        print(  "-------------------- PASSPORT --------------------\n" +
                "----------------------------------------------------------\n" +
                "-----\n" +
                "----- Person: " + name + " " + surname + "\n" +
                "-----\n" +
                "----- Gender: " + gender + ", " + "age: " + nAge + "\n" +
                "-----\n" +
                "----- Location: from - " + placeOfBirth + ", current - " + placeOfLiving + "\n" +
                "-----\n" +
                "----------------------------------------------------------\n" +
                "----------------------------------------------------------");
    }
}
