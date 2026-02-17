package model.game;

import java.io.*;
import java.util.ArrayList;

public class QuestionLoader {

    public static Question[] loadFromCsv(String path){

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            ArrayList<Question> list = new ArrayList<>();

            br.readLine(); // Header überspringen

            String line;

            while((line = br.readLine()) != null){
                String[] parts = line.split(",");

                if(parts.length >= 2){
                    String frage = parts[0].trim();
                    String antwort = parts[1].trim();

                    list.add(new Question(frage, antwort));
                }
            }

            br.close();

            return list.toArray(new Question[0]);

        } catch(Exception e){
            return new Question[0];
        }
    }

    public static Question[] loadStandard(){

        return new Question[]{
                new Question("Was ist JVM?", "Java Virtual Machine"),
                new Question("Was ist JDK?", "Java Development Kit"),
                new Question("Was bedeutet OOP?", "Objektorientierte Programmierung"),
                new Question("Was ist ein Interface?", "Schnittstelle"),
                new Question("Was ist Vererbung?", "Inheritance"),
                new Question("Was ist ein Objekt?", "Instanz"),
                new Question("Was ist ein Compiler?", "Übersetzer"),
                new Question("Was ist eine Exception?", "Fehler"),
                new Question("Was ist Abstraktion?", "Vereinfachung"),
                new Question("Was ist Kapselung?", "Datenverstecken")
        };
    }
}



