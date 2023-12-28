package com.example.couponcore;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableAspectJAutoProxy(exposeProxy = true)
@EnableCaching
@EnableJpaAuditing
@ComponentScan
@EnableAutoConfiguration
public class CouponCoreConfiguration {
}
