import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by JohnCena on 01.04.2017.
 */
public class JdbcContactDao implements ContactDao, InitializingBean {
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dat)
    {
        dataSource=dat;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void afterPropertiesSet() throws Exception{
        if(dataSource==null)
        {
            throw new BeanCreationException("Must set datasource on contactDao");
        }
    }

    public String findFirstNameById(Long id)
    {
        return jdbcTemplate.queryForObject("select first_name from persons where id=?", new Object[]{id},String.class);
    }
}
