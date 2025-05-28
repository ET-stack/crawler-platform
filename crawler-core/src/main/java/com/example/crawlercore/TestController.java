package com.example.crawlercore;

/**
 * @className: TestController
 * @description: TODO 类描述
 * @date: 2025/5/23
 **/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "crawler-core 接口响应成功";
    }
}
