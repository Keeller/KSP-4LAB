package main;

import Service.StudentsService;
import models.Students;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.HashMap;

public class Main {

    private static StudentsService studentsService=new StudentsService();

    public static String hsm(HashMap<String,HashMap<String,String>> m) {

        HashMap<String, HashMap<String,String>> request=m;
        try {
            String seq=request.get("POST").get("action");
            String answ="";
            if ("all".equals(seq)) {
                for (Students st : studentsService.findAll())
                    answ += st.toString() + ";";
            } else if ("create".equals(seq)) {
                String Name = (request.get("POST").get("name"));
                String LatName = (request.get("POST").get("LastName"));
                int year = Integer.parseInt(request.get("POST").get("year"));
                Students st = new Students(Name, LatName, year);
                studentsService.save(st);
                answ += "OK";
            } else if ("delete".equals(seq)) {
                int id = Integer.parseInt(request.get("POST").get("id"));
                studentsService.delete(studentsService.findById(id));
                answ += "OK";
            } else if ("update".equals(seq)) {
                int idu = Integer.parseInt(request.get("POST").get("id"));
                String Nameu = (request.get("POST").get("name"));
                String LatNameu = (request.get("POST").get("LastName"));
                int yearu = Integer.parseInt(request.get("POST").get("year"));
                Students st1 = studentsService.findById(idu);
                st1.setName(Nameu);
                st1.setName(LatNameu);
                st1.setYearBirth(yearu);
                studentsService.update(st1);
                answ += "OK";
            }
            return answ;

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
