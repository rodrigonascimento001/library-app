package com.br.rodrigo.libraryapp.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static com.br.rodrigo.libraryapp.util.Constants.*;

@Configuration
public class AmazonConfiguration {
    @Autowired
    private Environment env;

    @Bean
    public BasicAWSCredentials basicAWSCredentials() {
        return new BasicAWSCredentials(env.getProperty(ACCESS_KEY), env.getProperty(SECRET_KEY));
    }

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard().withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials())).build();
    }
}
