package stmall.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stmall.MypageApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { MypageApplication.class })
public class CucumberSpingConfiguration {}
