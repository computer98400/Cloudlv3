package stmall.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stmall.ItemsApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { ItemsApplication.class })
public class CucumberSpingConfiguration {}
