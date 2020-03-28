package com.liuxh.consumer.facade;
import com.liuxh.consumer.facade.configuration.FeignConfiguration;
import com.liuxh.provider.api.service.UserService;
import com.liuxh.provider.api.model.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 定义每个接口的Feign实现
 * 1,通过fallbackFactory实现降级配置
 * 2,fallbackFactory 采用内部类的方式，并在FeignConfiguration中配置注入
 * 3,FeignClient->configuration固定为FeignConfiguration.class，必填
 */
@FeignClient(value = "provider",fallbackFactory = UserFacade.UserFacadeFactory.class,configuration = FeignConfiguration.class)
public interface UserFacade extends UserService {
    @Slf4j
    class UserFacadeFactory implements FallbackFactory<UserFacade>{
        @Override
        public UserFacade create(Throwable throwable) {
            log.error("调用出错了",throwable);
            return () -> new User("test",100);
        }
    }
}

