package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by admin on 2018/1/2.
 */
@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        // 1.if just simple use to start spring boot application, use as below
        /*SpringApplication app = new SpringApplication();
        app.run(Application.class, args);*/

        // 2.if need config hierarchy context or default properties or active profiles
        SpringApplicationBuilder sab = new SpringApplicationBuilder(Application.class);
        // if not set, auto detected by classpath
        sab.web(true);
        sab.run(args);
    }
    @Override
    public void run(String... strings) throws Exception {}

    /*@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.SortField,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        return new HttpMessageConverters(fastConverter);
    }*/
}
