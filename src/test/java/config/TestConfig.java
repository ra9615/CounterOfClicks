package config;


import nedra_test.dao.ClickDAO;
import nedra_test.service.ClickServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    public ClickServiceImpl clickServiceImpl() {
        return new ClickServiceImpl();
    }

    @Bean
    public ClickDAO clickDAO() {
        return mock(ClickDAO.class);
    }
}
