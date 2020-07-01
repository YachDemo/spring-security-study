package com.yanch.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.nio.charset.Charset

/**
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-07-01 17:19
 **/
@Configuration
open class BaseConfig : WebMvcConfigurer {

    @Bean
    open fun responseBodyConverter(): HttpMessageConverter<String?>? {
        return StringHttpMessageConverter(Charset.forName("UTF-8"))
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>?>) {
        converters.add(responseBodyConverter())
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
    }

}