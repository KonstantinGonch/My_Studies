import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JohnCena on 01.04.2017.
 */
public class NamesFetcher extends MappingSqlQuery<Person> {
    private final static String QUERY = "select * from names";

    public NamesFetcher(DataSource ds)
    {
        super(ds,QUERY);
    }

    @Override
    protected Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person p = new Person();
        p.setFirstName(resultSet.getString("first_name"));
        p.setLastName(resultSet.getString("last_name"));
        p.setId(resultSet.getInt("id"));
        return p;
    }
}
