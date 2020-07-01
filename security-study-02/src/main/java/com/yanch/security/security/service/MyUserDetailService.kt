package com.yanch.security.security.service

import com.yanch.security.security.dto.MyUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

/**
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-07-01 16:33
 **/
@Configuration
open class MyUserDetailService : UserDetailsService {
    @Autowired
    lateinit var passwordEncoder: BCryptPasswordEncoder

    override fun loadUserByUsername(userName: String): UserDetails {
        val user = MyUser()
        user.userName = userName
        user.password = passwordEncoder.encode("123456")
        println(user.password)

        return User(userName,
                user.password,
                user.enabled,
                user.accountNonExpired,
                user.credentialsNonExpired,
                user.accountNonLocked,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"))
    }

}