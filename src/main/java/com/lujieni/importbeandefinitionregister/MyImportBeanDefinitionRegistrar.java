package com.lujieni.importbeandefinitionregister;

import com.lujieni.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Auther ljn
 * @Date 2020/2/20
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry 注册类,调用registerBeanDefinition手工注册进去
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean a = registry.containsBeanDefinition("com.lujieni.bean.Red");
        boolean b = registry.containsBeanDefinition("com.lujieni.bean.Blue");
        if(a && b){
            //指定Bean定义信息,(Bean的类型)
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean,指定bean名
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
