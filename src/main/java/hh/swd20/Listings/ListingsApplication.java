package hh.swd20.Listings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Listings.domain.Item;
import hh.swd20.Listings.domain.ItemRepository;



@SpringBootApplication
public class ListingsApplication {
	private static final Logger log = LoggerFactory.getLogger(ListingsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ListingsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner ListingsTest(ItemRepository itemRepository) {
		return (args) -> {
			log.info("Some items");
			
			itemRepository.save(new Item("First header", "First description"));
			
			log.info("Fetch all items");
			for (Item item : itemRepository.findAll()) {
				log.info(item.toString());
			}

		};
	}

}
