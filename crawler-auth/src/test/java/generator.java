import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;

/**
 * @className: generator
 * @description: TODO 类描述
 * @date: 2025/5/27
 **/
public class generator {
    public static void main(String[] args) {
        // 1. 数据源配置
        String url = "jdbc:mysql://localhost:3306/crawler-platform?useSSL=false&useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";

// 4. 执行生成
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder
                        .author("xiaofei")
                        .outputDir("E:\\Development\\crawler-platform\\crawler-auth\\src\\main\\java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.example.crawlerauth")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
