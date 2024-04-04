package com.fastcampus.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing // Auditing 해주는 부분!
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("jaehee"); // 앞으로 등록자/수정자 이름은 jaehee로 넣어줄거임!
        // TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때 수정하기
    }
}
