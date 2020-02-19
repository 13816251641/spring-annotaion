package com.lujieni.config;

import com.lujieni.bean.Person;
import com.lujieni.condition.LinuxCondition;
import com.lujieni.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther ljn
 * @Date 2020/2/17
 * Conditional标签的使用
 */
//@Conditional(LinuxCondition.class) //满足当前条件下这个类中所有的bean才会生效
@Configuration
public class ConditionalConfig {

    /**
     * @Conditional({Condition}):按照一定的条件进行判断,满足条件给容器中注册bean
     * 只要实现Condition接口即可,按照返回的boolean值来判断是否要装配bean
     * @return
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01(){
        return new Person().setName("Bill Gates").setAge(62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02(){
        return new Person().setName("linus").setAge(48);
    }

}
