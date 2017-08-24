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
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("用户信息").apiInfo(userApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("pri.fly.leaning.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo userApiInfo() {
		return new ApiInfoBuilder().title("在线接口文档").description("用户相关接口").termsOfServiceUrl("http://localhost:8080")
				.contact(new Contact("fly", "https://github.com/BestRumbleCN", "flyxie2009@foxmail.com")).version("1.0")
				.build();
	}

}
