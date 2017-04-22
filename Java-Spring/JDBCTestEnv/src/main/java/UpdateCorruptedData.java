import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by JohnCena on 02.04.2017.
 */
public class UpdateCorruptedData extends SqlUpdate {
    private final static String QUERY = "update names set first_name = :first_name, last_name = :last_name where id = :id";

    public UpdateCorruptedData(DataSource src)
    {
        super(src,QUERY);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }
}
