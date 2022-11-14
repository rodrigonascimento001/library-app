//package com.br.rodrigo.libraryapp.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class JpaConfig {
//    @Value("${db.host}")
//    String host;
//
//    @Value("${db.name}")
//    String dbName;
//
//    @Value("${db.pass}")
//    String pass;
//
//    @Value("${db.username}")
//    String username;
//
//    @Bean
//    public DataSource getDataSource(){
//        System.out.println("&&&&&"+ host);
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url(getDataSourceUrl())
//                .username(username)
//                .password(pass)
//                .build();
//    }
//
//    private String getDataSourceUrl(){
//        return"jdbc:mysql://"
//                +host+"/"
//                +dbName
//                +"?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
//    }
//}