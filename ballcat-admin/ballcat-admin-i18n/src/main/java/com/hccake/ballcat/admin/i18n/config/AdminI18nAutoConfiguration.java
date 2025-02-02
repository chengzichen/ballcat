package com.hccake.ballcat.admin.i18n.config;

import com.hccake.ballcat.autoconfigure.i18n.I18nMessageSourceAutoConfiguration;
import com.hccake.ballcat.autoconfigure.redis.MessageEventListenerAutoConfiguration;
import com.hccake.ballcat.common.i18n.I18nMessageProvider;
import com.hccake.ballcat.i18n.provider.CustomI18nMessageProvider;
import com.hccake.ballcat.i18n.service.I18nDataService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 注册一个 I18nMessageProvider
 *
 * @author hccake
 */
@AutoConfiguration(before = { I18nMessageSourceAutoConfiguration.class, MessageEventListenerAutoConfiguration.class })
@MapperScan("com.hccake.ballcat.i18n.mapper")
@ComponentScan("com.hccake.ballcat.i18n")
public class AdminI18nAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean(I18nMessageProvider.class)
	public CustomI18nMessageProvider i18nMessageProvider(I18nDataService i18nDataService) {
		return new CustomI18nMessageProvider(i18nDataService);
	}

}
