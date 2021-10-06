package com.benforsberg.certmanager;

import com.benforsberg.certmanager.Cert.Cert;
import com.benforsberg.certmanager.Cert.CertRepository;
import com.benforsberg.certmanager.User.User;
import com.benforsberg.certmanager.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository,
										 CertRepository certRepository) {
		return args -> {


			User ben = new User("Ben", "Forsberg", "benj.forsberg@gmail.com", true);
			userRepository.save(ben);

			Cert benLGI = new Cert("June 2022", "ARC", "LGI", "Lifeguarding Instructor",
					"4Fh6VZ", "2 Years", false, ben);

			Cert benWSI = new Cert("February 2023", "ARC", "WSI", "Water Safety Instructor",
					"8JH5TE", "2 Years", false, ben);

			certRepository.save(benLGI);
			certRepository.save(benWSI);

			String output = "Output " + userRepository.findAll();
			System.out.println(output);
		};
	}
}
