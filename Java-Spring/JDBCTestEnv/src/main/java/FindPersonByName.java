import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by JohnCena on 02.04.2017.
 */
public class FindPersonByName extends MappingSqlQuery<Person> {
    private static String QUERY = "select * from names where first_name = :first_name";

    public FindPersonByName(DataSource source)
    {
        super(source,QUERY);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
    }

    protected Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person p = new Person();
        p.setFirstName(resultSet.getString("first_name"));
        p.setLastName(resultSet.getString("last_name"));
        p.setId(resultSet.getInt("id"));
        return p;
    }
}
