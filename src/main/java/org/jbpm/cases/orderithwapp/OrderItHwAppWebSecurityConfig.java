/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.cases.orderithwapp;

import org.kie.api.executor.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration("kieServerSecurity")
@EnableWebSecurity
public class OrderItHwAppWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
            .antMatchers("/rest/*").authenticated()
            .and()
        .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication().withUser("kieserver").password(encoder.encode("kieserver1!")).roles("kie-server");
        auth.inMemoryAuthentication().withUser("adminUser").password(encoder.encode("test1234!")).roles("kie-server");
        auth.inMemoryAuthentication().withUser("executionUser").password(encoder.encode("test1234!")).roles("kie-server");
        
        auth.inMemoryAuthentication().withUser("maciek").password(encoder.encode("maciek1!")).roles("employees");
        auth.inMemoryAuthentication().withUser("tihomir").password(encoder.encode("tihomir1!")).roles("employees", "apple", "dell", "lenovo", "other");
        auth.inMemoryAuthentication().withUser("krisv").password(encoder.encode("krisv1!")).roles("employees", "manager");
        auth.inMemoryAuthentication().withUser("mary").password(encoder.encode("mary1!")).roles("employees", "manager");
        auth.inMemoryAuthentication().withUser("paul").password(encoder.encode("paul1!")).roles("employees", "manager");
    }
    

}