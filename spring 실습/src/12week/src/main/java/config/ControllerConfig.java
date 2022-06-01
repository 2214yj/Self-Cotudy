package config;

import Spring.MemberService;
import controller.SearchController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberService memberService;

	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberService);
		return controller;
	}

	@Bean
	public SearchController searchController() {
		SearchController controller = new SearchController();
		controller.setMemberRegisterService(memberService);
		return controller;
	}

}
