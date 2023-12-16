/**
 * 
 */
package org.kyj.gargoyle.app.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * 
 */
@Configuration
public class SwaggerConfig {

	// 그룹별 Api 메뉴 설정
	// 그룹화를 정의할 개수에 따라 GroupedOpenApi 빈을 등록해준다.
	@Bean
	public GroupedOpenApi allApi() {
		return GroupedOpenApi.builder().group("Common").pathsToMatch("/**") // url로 필터
				.packagesToScan("org.kyj.gargoyle") // package 단위로 필터
				.build();
	}

	@Bean
	public GroupedOpenApi groupApi2() {
		return GroupedOpenApi.builder().group("User").pathsToMatch("/user").build();
	}

	@Bean
	public GroupedOpenApi groupApi3() {
		return GroupedOpenApi.builder().group("Useful").pathsToMatch("/useful").build();
	}

	// Api 설정
	@Bean
	public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion, @Value("${springdoc.email}") String email,
			@Value("${springdoc.desc}") String desc, @Value("${springdoc.url}") String url) {
		Contact name = new Contact().name("GargoyleSerivce");
		Info info = new Info().title("Gargoyle Service").version(appVersion).description(desc).contact(name);

		if (!url.isBlank())
			name.url(url);

		name.email(email);

		return new OpenAPI().components(new Components()).info(info);
	}

}
