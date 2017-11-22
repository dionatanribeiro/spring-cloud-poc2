package br.com.mercado.zipkintracingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinTracingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinTracingServerApplication.class, args);
	}
}
