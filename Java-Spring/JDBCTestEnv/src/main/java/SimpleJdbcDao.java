import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JohnCena on 01.04.2017.
 */
public class SimpleJdbcDao implements BaseDao, InitializingBean {
    private DataSource dataSource;
    private NamesFetcher namesFetcher;
    private FindPersonByName findPersonByName;
    private UpdateCorruptedData updateCorruptedData;

    public void setUpdateCorruptedData(UpdateCorruptedData updateCorruptedData) {
        this.updateCorruptedData = updateCorruptedData;
    }

    public List<Person> findPersonByFirstName(String name) {
        Map<String,Object> vals = new HashMap<String,Object>();
        vals.put("first_name","Jude");
        return findPersonByName.executeByNamedParam(vals);
    }

    public FindPersonByName getFindPersonByName() {
        return findPersonByName;
    }

    public void setFindPersonByName(FindPersonByName findPersonByName) {
        this.findPersonByName = findPersonByName;
    }

    public List<Person> fetchAllNamesByClass() {
        return namesFetcher.execute();
    }

    public NamesFetcher getNamesFetcher() {
        return namesFetcher;
    }

    public void setNamesFetcher(NamesFetcher namesFetcher) {
        this.namesFetcher = namesFetcher;
    }

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource src)
    {
        dataSource=src;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void afterPropertiesSet() throws Exception {
        if (dataSource==null)
                throw new RuntimeException("Failed to initialize DB");
    }

    public String getFullNameById(long id)
    {
        String ret = jdbcTemplate.queryForObject("select first_name from names where id=?",new Object[]{id}, String.class);
        return ret;
    }

    public List<Person> getPersonById(long id)
    {
        return jdbcTemplate.query("select * from names where id=?", new Object[]{id}, new QueryMapper());
    }

    public List<Person> fetchAllNames()
    {
        return jdbcTemplate.query("select * from names", new QueryMapper());
    }

    public void update(long id)
    {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("first_name","Varin");
        params.put("last_name","Omega");
        params.put("id",id);
        updateCorruptedData.updateByNamedParam(params);
    }
}
