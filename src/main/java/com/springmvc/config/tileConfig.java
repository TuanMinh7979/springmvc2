package com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class tileConfig {
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver res = new UrlBasedViewResolver();
		res.setViewClass(TilesView.class);
		return res;

	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer c = new TilesConfigurer();
		c.setDefinitions("/WEB-INF/tiles.xml");
		c.setCheckRefresh(true);
		return c;
	}
}
