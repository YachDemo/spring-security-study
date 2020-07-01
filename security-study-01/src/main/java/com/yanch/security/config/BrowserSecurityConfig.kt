package com.yanch.security.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * 我们可以通过一些配置将HTTP Basic认证修改为基于表单的认证方式。
 *
 * @see WebSecurityConfigurerAdapter (是由Spring Security提供的Web应用安全配置的适配器)
 * @author YanCh
 * @version v1.0
 * Create by 2020-07-01 16:15
 **/
@Configuration
open class BrowserSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.formLogin() //表单方式
                .and()
                .authorizeRequests() // 授权配置
                .anyRequest()        // 所有请求
                .authenticated()     // 都需要配置
    }
}