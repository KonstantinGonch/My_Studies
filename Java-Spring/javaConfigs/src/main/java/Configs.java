import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JohnCena on 21.03.2017.
 */
@Configuration
public class Configs {
    @Bean
    public Injectable injectable()
    {
        Injectable inj = new Injectable();
        inj.setMessage("Hi");
        return inj;
    }
}
