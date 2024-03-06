package ma.onmt.api.regionservice;

import ma.onmt.api.regionservice.entity.*;
import ma.onmt.api.regionservice.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
			region =regionRepository.save(region);

			Region region1 = new Region();
			region1.setName("Casablanca");
			region1 =regionRepository.save(region1);


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
