package com.plutus.system.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContext;

@NoArgsConstructor(access = AccessLevel.NONE)
public final class SecurityUtils {
    // TODO: 10/19/2020 make normally
    public static long getAccountIdFromSecurityContext(SecurityContext context) {
        return (long) context.getAuthentication().getPrincipal();
    }
}
