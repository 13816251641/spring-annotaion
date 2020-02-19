package com.lujieni.config;

import com.lujieni.Importselector.MyImportSelector;
import com.lujieni.bean.Red;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther ljn
 * @Date 2020/2/19
 *
 * 给容器中注册组件
 * 1) 包扫描+默认是组件标注注解(@Controller/@Service/@Repository/@Component
 * 2) @Bean[导入第三方包里面的组件]
 * 3) @Import[快速给容器中导入一个组件]
 *     1) @Import(要导入容器的组件):容器中就会自动注册这个组件.id默认是包名+类名
 */
@Configuration
@Import({Red.class, MyImportSelector.class})
public class ImportConfig {



}
