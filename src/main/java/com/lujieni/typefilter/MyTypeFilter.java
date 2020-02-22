package com.lujieni.typefilter;

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
        if(metadataReader.getClassMetadata().getClassName().contains("ment")){
            //获取当前类注解的信息
            AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
            for(String s : annotationMetadata.getAnnotationTypes()){
                System.out.println("当前正在被扫描的类注解类型:"+s);
            }
            //获取当前正在扫描类的信息
            ClassMetadata classMetadata = metadataReader.getClassMetadata();
            System.out.println("当前正在被扫描的类的类名:"+classMetadata.getClassName());
            //获取当前类的资源信息（类存放的路径...）
            Resource resource = metadataReader.getResource();
            System.out.println("当前正在被扫描的类存放的地址:"+resource.getURL());
            return false;
        }
        return true;
    }
}
