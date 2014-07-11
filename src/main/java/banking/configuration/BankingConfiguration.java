package banking.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={
	"banking.dao",
})
public class BankingConfiguration {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	public BankingConfiguration() {
		LOGGER.info("Constructing BankingConfiguration.");
	}
		
}
