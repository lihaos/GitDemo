package cn.ch.netem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@EnableTransactionManagement
@MapperScan("cn.ch.netem.mapper")
@SpringBootApplication
public class LoanManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoanManagerApplication.class, args);
	}
}
