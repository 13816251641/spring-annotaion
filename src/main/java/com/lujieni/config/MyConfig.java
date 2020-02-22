package com.lujieni.config;

import com.lujieni.bean.Person;
import com.lujieni.bean.RainBow;
import com.lujieni.bean.Red;
import com.lujieni.dao.BookDao;
import com.lujieni.service.BookService;
import com.lujieni.typefilter.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Auther ljn
 * @Date 2020/2/15
 * 基于配置类
 */
@Configuration //告诉spring这是一个配置类
/*@ComponentScan(value = "com.lujieni", //扫描本包及其子类,下面的排除都是在这个范围内进行排除的
        excludeFilters ={
                          @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}), //排除带有Controller注解的类
                          @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}), //排除BookService这个类
                          @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class) //自定义排除规则
                        })*/

@ComponentScan(value = "com.lujieni", //扫描本包及其子类,下面的排除都是在这个范围内进行排除的
        excludeFilters ={
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {RainBow.class,Red.class, BookDao.class}), //排除BookService这个类
        })



//@ComponentScan(value = "com.lujieni",useDefaultFilters = false,//不设置false includeFilters将不会生效
//        includeFilters ={@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})}) //只要Controller和Service注解的类


//@ComponentScan 默认要扫描带有@Controller @Service @Repository @Component标签的类
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[] : 指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] : 指定要扫描的时候需要包含哪些组件
//FilterType.ANNOTATION:按照注解
//FilterType.ASSIGNABLE_TYPE:按照给定的类型
//FilterType.ASPECTJ:使用ASPECTJ表达式
//FilterType.REGEX:使用正则指定
//FilterType.CUSTOM:使用自定义规则
public class MyConfig {

    /*
       利用@Bean方式进行的装配不受@ComponentScan的干扰
     */
    @Bean // id默认是方法名
    public Person person(){
        return new Person().setAge(27).setName("张飞");
    }


}
