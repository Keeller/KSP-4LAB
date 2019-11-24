package Service;

import DAOImpl.StudentsImpl;
import models.Students;

import java.util.List;

public class StudentsService {

    StudentsImpl gurl=new StudentsImpl();

    public StudentsService() {
    }

    public Students findById(int id){
        return gurl.findById(id);
    }

    public void save(Students gurl){
        this.gurl.save(gurl);
    }

    public void update(Students gurl){
        this.gurl.update(gurl);
    }

    public void delete(Students gurl){
        this.gurl.delete(gurl);
    }

    public List<Students> findAll(){return this.gurl.findAll();}
}
