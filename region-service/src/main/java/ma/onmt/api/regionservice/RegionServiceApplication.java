package ma.onmt.api.regionservice;

import ma.onmt.api.regionservice.entity.*;
import ma.onmt.api.regionservice.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Configuration
@RefreshScope // Refresh the configuration
public class RegionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			RegionRepository regionRepository, EventRepository eventRepository,
			ActivityRepository activityRepository, TouristicAttractionRepository touristicAttractionRepository, AccommodationRepository accommodationRepository



	) {
		return args -> {
			//Region
			Region region = new Region();
			region.setName("Rabat");
			region.setDescription("""
						Rabat, Morocco's capital, rests along the shores of the Bouregreg River and the Atlantic Ocean. It's known for landmarks that speak to its Islamic and French-colonial heritage, including the Kasbah of the Udayas. This Berber-era royal fort is surrounded by formal French-designed gardens and overlooks the ocean.\s
					""");
			region.setArea("1000 square kilometers");
			region.setGdp("100 Million MAD");
			region.setImageUrl("https://media.istockphoto.com/id/1133193983/fr/photo/vue-du-port-de-rabat-maroc-en-afrique.jpg?s=612x612&w=0&k=20&c=6IQeIBSW2M-KjX28dfC_aZAFOCnr9R9A-84V8qZysOM=");
			region.setPopulation("1 million");
			region = regionRepository.save(region);

			Region region1 = new Region();
			region1.setName("Casablanca");
			region1.setDescription("""
						Casablanca is a port city and commercial hub in western Morocco, fronting the Atlantic Ocean. The city's French colonial legacy is seen in its downtown Mauresque architecture, a blend of Moorish style and European art deco. Standing partly over the water, the enormous Hassan II Mosque, completed in 1993, has a 210m minaret topped with lasers directed toward Mecca.
					""");
			region1.setArea("1500 square kilometers");
			region1.setImageUrl("https://media.istockphoto.com/id/1282606692/photo/evening-view-of-casablanca-cityscape-with-mosque-hassan-ii-in-morocco.jpg?s=612x612&w=0&k=20&c=kKghyuc-Y5b6-53unfvTolvJuqe7XbR_G9A457jBmNs=");
			region1.setGdp("220 Million MAD");
			region1.setPopulation("2 million");
			region1 = regionRepository.save(region1);



			//Event
			Event event = new Event();
			event.setName("Mawazine");
			event.setRegion(region);
			eventRepository.save(event);

			Event event1 = new Event();
			event1.setName("Jazzablanca");
			event1.setRegion(region1);
			eventRepository.save(event1);

			//Activity
			Activity activity = new Activity();
			activity.setName("Surf");
			activity.setRegion(region);
			activityRepository.save(activity);

			Activity activity1 = new Activity();
			activity1.setName("Ski");
			activity1.setRegion(region1);
			activityRepository.save(activity1);

			//TouristicAttraction
			TouristicAttraction touristicAttraction = new TouristicAttraction();
			touristicAttraction.setName("Chellah");
			touristicAttraction.setRegion(region);
			touristicAttractionRepository.save(touristicAttraction);

			TouristicAttraction touristicAttraction1 = new TouristicAttraction();
			touristicAttraction1.setName("Mosque Hassan II");
			touristicAttraction1.setRegion(region1);
			touristicAttractionRepository.save(touristicAttraction1);

			//Accommodation
			Accommodation accommodation = new Accommodation();
			accommodation.setName("Hotel");
			accommodation.setRegion(region);
			accommodationRepository.save(accommodation);

			Accommodation accommodation1 = new Accommodation();
			accommodation1.setName("Riad");
			accommodation1.setRegion(region1);
			accommodationRepository.save(accommodation1);





		};
	}
}
