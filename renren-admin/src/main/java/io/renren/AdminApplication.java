/**
 * Copyright (c) 2016-2019 炫酷游互娱 All rights reserved.
 *
 * http://www.xkygame.com
 *
 * 版权所有，侵权必究！
 */

package io.renren;

import io.renren.common.utils.IdWorker;
import io.renren.modules.sys.thread.createCodeThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AdminApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Bean
	public IdWorker idWorker() {
		return new IdWorker(1, 1);
	}

	@Bean
	public createCodeThread codeThread(){
		return new createCodeThread();
	}

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminApplication.class);
    }
}
