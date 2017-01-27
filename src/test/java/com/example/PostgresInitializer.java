package com.example;

import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.GenericContainer;

public class PostgresInitializer
		implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	public static GenericContainer postgres = new GenericContainer("postgres:9.6")
			.withEnv("POSTGRES_PASSWORD", "password").withEnv("POSTGRES_DB", "city")
			.withExposedPorts(5432);

	@Override
	public void initialize(
			ConfigurableApplicationContext configurableApplicationContext) {
		EnvironmentTestUtils.addEnvironment("testcontainers",
				configurableApplicationContext.getEnvironment(),
				String.format("spring.datasource.url=jdbc:postgresql://%s:%d/city",
						postgres.getContainerIpAddress(), postgres.getMappedPort(5432)));
	}

	public static GenericContainer initContainer() {
		return postgres;
	}
}
