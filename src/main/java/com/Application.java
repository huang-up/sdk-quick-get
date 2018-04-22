package com;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by admin on 2018/1/2.
 */
@Slf4j
@EnableAsync
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
    public void run(String... strings) throws Exception {
        log.info("+++++++++++++测试info信息++++++++++++++");
        log.debug("+++++++++++++测试debug信息++++++++++++++");
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.SortField,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
        fastJsonConfig.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastConverter);
    }

}
