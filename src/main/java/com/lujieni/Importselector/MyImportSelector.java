package com.lujieni.Importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Auther ljn
 * @Date 2020/2/19
 */
public class MyImportSelector implements ImportSelector {


    /*
        返回值,就是导入到容器中的组件全类名
        AnnotationMetadata:当前标注@Import注解的类的所有注解信息
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.lujieni.bean.Blue"};
    }
}
