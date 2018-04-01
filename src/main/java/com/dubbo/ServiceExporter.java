package com.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dubbo.api.HelloServiceProvider;
import com.dubbo.provider.HelloServiceImpl;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

public class ServiceExporter {
    /**
     * 区别于注解和xml配置一个bean
     * 用编码方式将bean定义给spring工厂，并让spring返回这个bean对象
     * @param defaultBeanFactory
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T createSpringBean(DefaultListableBeanFactory defaultBeanFactory,Class<T> clz) {
        String beanName =clz.getName();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(clz);
        defaultBeanFactory.registerBeanDefinition(beanName, builder.getRawBeanDefinition());
        return (T)defaultBeanFactory.getBean(beanName);
    }

    /**
     * 区别于配置文件
     * 用编码方式动态暴露服务
     * 动态发布helloService
     */
    public static <T> void exportDubboService(ApplicationContext context,Class<T> serviceClaz){
        RegistryConfig registry = context.getBean(RegistryConfig.class);
        ApplicationConfig application = context.getBean(ApplicationConfig.class);
        ProtocolConfig protocol = context.getBean(ProtocolConfig.class);
        ServiceConfig<T> service = new ServiceConfig();
        AutowireCapableBeanFactory defaultBeanFactory = context.getAutowireCapableBeanFactory();
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(serviceClaz.getInterfaces()[0]);
        service.setRef(createSpringBean((DefaultListableBeanFactory)defaultBeanFactory,serviceClaz));
        service.setVersion("1.0");
        service.export();

    }
}
