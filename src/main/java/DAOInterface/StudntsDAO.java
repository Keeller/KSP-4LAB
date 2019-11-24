package DAOInterface;

import models.Students;

import java.util.List;

public interface StudntsDAO {

    Students findById(int id);

    void save(Students globalUrl);

    void update(Students globalUrl);

    void delete(Students globalUrl);

    List<Students> findAll();

}
