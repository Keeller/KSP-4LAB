package main;

import Service.StudentsService;
import models.Students;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.HashMap;

public class Main {

    private static StudentsService studentsService=new StudentsService();

    public static void main(String[] args) {

        HashMap<String, HashMap<String,String>> request=new HashMap<>();
        try {
            ObjectInputStream oi=new ObjectInputStream(System.in);
            request=(HashMap<String, HashMap<String, String>>) oi.readObject();
            oi.close();
            String seq=request.get("POST").get("action");
            String answ="";
            switch (seq){

                case "all":
                    for(Students st:studentsService.findAll())
                        answ+=st.toString()+" ";
                    break;

                case "create":
                    String Name=(request.get("POST").get("name"));
                    String LatName=(request.get("POST").get("LastName"));
                    int year=Integer.parseInt(request.get("POST").get("year"));
                    Students st=new Students(Name,LatName,year);
                    studentsService.save(st);
                    answ+="OK";
                    break;


                case "delete":
                    int id=Integer.parseInt(request.get("POST").get("id"));
                    studentsService.delete(studentsService.findById(id));
                    answ+="OK";
                    break;

                case "update":
                    int idu=Integer.parseInt(request.get("POST").get("id"));
                    String Nameu=(request.get("POST").get("name"));
                    String LatNameu=(request.get("POST").get("LastName"));
                    int yearu=Integer.parseInt(request.get("POST").get("year"));
                    Students st1=studentsService.findById(idu);
                    st1.setName(Nameu);
                    st1.setName(LatNameu);
                    st1.setYearBirth(yearu);
                    studentsService.update(st1);
                    answ+="OK";
                    break;




            }

            PrintStream ps = new PrintStream(System.out, true, "UTF-8");
            ps.println(answ);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
