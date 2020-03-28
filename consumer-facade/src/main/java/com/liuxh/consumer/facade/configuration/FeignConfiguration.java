package com.liuxh.consumer.facade.configuration;

import com.liuxh.consumer.facade.UserFacade;
import org.springframework.context.annotation.Bean;

/**
 * 配置Facade对用的FallBackFactory的Bean
 */
public class FeignConfiguration {
    @Bean
    public UserFacade.UserFacadeFactory userFacadeFactory(){
        return new UserFacade.UserFacadeFactory();
    }
}
