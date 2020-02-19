package com.lujieni.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Auther ljn
 * @Date 2020/2/15
 * MyTypeFilter会被多次调用!!!
 */
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader:读取到当前正在扫描的类的信息
     * @param metadataReaderFactory:可以获取到其他任何类信息
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取到当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("--->"+className);
        return true;
    }
}
