package ru.freeomsk.springbootlogging.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;


@Component
public class MDCFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
//            String userId = request.getHeader("UserId");
            String userId = UUID.randomUUID().toString();
            MDC.put("UserId", userId);
            MDC.put("CorrelationId", UUID.randomUUID().toString());
            filterChain.doFilter(request, response);
        } finally {
//            MDC.remove("UserId");
            MDC.clear();
        }
    }
}
