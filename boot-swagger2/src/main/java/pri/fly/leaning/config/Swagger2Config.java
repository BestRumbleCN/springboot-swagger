package pri.fly.leaning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket createPresidentDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("校长").apiInfo(presidentApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("pri.fly.leaning.controller.president"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo presidentApiInfo() {
		return new ApiInfoBuilder().title("在线接口文档").description("校长接口").termsOfServiceUrl("http://localhost:8080")
				.contact(new Contact("fly", "https://github.com/BestRumbleCN", "flyxie2009@foxmail.com")).version("1.0")
				.build();
	}
	
	@Bean
	public Docket createStudentDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("学生").apiInfo(studentApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("pri.fly.leaning.controller.student"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo studentApiInfo() {
		return new ApiInfoBuilder().title("在线接口文档").description("学生接口").termsOfServiceUrl("http://localhost:8080")
				.contact(new Contact("fly", "https://github.com/BestRumbleCN", "flyxie2009@foxmail.com")).version("1.0")
				.build();
	}
	
	@Bean
	public Docket createTeacherDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("老师").apiInfo(teacherApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("pri.fly.leaning.controller.teacher"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo teacherApiInfo() {
		return new ApiInfoBuilder().title("在线接口文档").description("老师接口").termsOfServiceUrl("http://localhost:8080")
				.contact(new Contact("fly", "https://github.com/BestRumbleCN", "flyxie2009@foxmail.com")).version("1.0")
				.build();
	}
	@Bean
	public Docket createManagerDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("管理者").apiInfo(managerApiInfo()).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Manager.class))
				.paths(PathSelectors.any()).build();
	}
	
	private ApiInfo managerApiInfo() {
		return new ApiInfoBuilder().title("在线接口文档").description("管理者").termsOfServiceUrl("http://localhost:8080")
				.contact(new Contact("fly", "https://github.com/BestRumbleCN", "flyxie2009@foxmail.com")).version("1.0")
				.build();
	}
}
