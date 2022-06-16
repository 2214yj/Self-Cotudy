package config;

import controller.HomeController;
import controller.SearchController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.MemberService;
import service.SearchService;

@Configuration
public class ControllerConfig {
	@Autowired
	private MemberService memberService;

	@Autowired
	private SearchService searchService;


	@Bean
	public HomeController homeController(){
		HomeController homeController = new HomeController();
		homeController.setMemberRegisterService(memberService);
		return homeController;
	}

	@Bean SearchController searchController(){
		SearchController searchController = new SearchController();
		searchController.setSearchRegisterService(searchService);
		return searchController;
	}

}
