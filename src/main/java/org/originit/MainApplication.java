package org.originit;


import org.originit.operator.impl.BossResumeSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @ComponentScan({"org.originit"})
public class MainApplication implements CommandLineRunner{

    @Autowired
    private BossResumeSub bossResumeSub;

    public static void main(String[] args)
    {
        new SpringApplicationBuilder(MainApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        //会在这里执行
        bossResumeSub.login();
    }
}

