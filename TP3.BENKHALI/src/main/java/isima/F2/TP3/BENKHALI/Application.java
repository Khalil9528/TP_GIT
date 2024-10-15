package isima.F2.TP3.BENKHALI;

import org.apache.commons.lang3.StringUtils; // Importer StringUtils
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
	    SpringApplication.run(Application.class, args);
	    
	    String reversedName = StringUtils.reverse("Benkhali Khalil");
	    logger.debug("Hello Word " + reversedName); // Log au niveau DEBUG

	    logger.warn("Hello Word");
	}
}
