import javax.sql.DataSource;
import java.util.List;

/**
 * Created by JohnCena on 01.04.2017.
 */
public interface BaseDao {
    public void setDataSource(DataSource source);
    public String getFullNameById(long id);
    public List<Person> fetchAllNames();
    public List<Person> fetchAllNamesByClass();
    public List<Person> findPersonByFirstName(String name);
    public List<Person> getPersonById(long id);
    public void update(long id);
}
