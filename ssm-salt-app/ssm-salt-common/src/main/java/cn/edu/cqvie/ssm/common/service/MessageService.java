package cn.edu.cqvie.ssm.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * 消息处理
 *
 * @author zhengsh
 * @date 2020-10-31
 */
@Component
public class MessageService {

    @Autowired
    private MessageSource messageSource;

    private Locale currentLocale = new Locale("en");

    @Bean
    public static MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }

    public String getMessage(String key) {
        return messageSource.getMessage(key, null, key, currentLocale);
    }
}
