import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JohnCena on 01.04.2017.
 */
public class QueryMapper implements RowMapper<Person> {
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person p = new Person();
        p.setFirstName(resultSet.getString("first_name"));
        p.setId(resultSet.getInt("id"));
        p.setLastName(resultSet.getString("last_name"));
        return p;
    }
}
