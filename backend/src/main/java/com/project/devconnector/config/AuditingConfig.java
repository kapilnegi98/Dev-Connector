package com.project.devconnector.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

//    @Bean
//    public AuditorAware<Long> auditorProvider() {
//        return new SpringSecurityAuditAwareImpl();
//    }
//}
//
//class SpringSecurityAuditAwareImpl implements AuditorAware<Long> {
//
//    @Override
//    public Optional<Long> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null ||
//                !authentication.isAuthenticated() ||
//                authentication instanceof AnonymousAuthenticationToken) {
//            return Optional.empty();
//        }
//
//        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//
//        return Optional.ofNullable(userPrincipal.getId());
//    }
}
