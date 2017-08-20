package note;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class AppConfig {
    @Bean
    ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .indentOutput(true)
                .dateFormat(new StdDateFormat())
                .build();
    }
}
