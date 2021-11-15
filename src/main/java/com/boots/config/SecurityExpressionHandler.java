package com.boots.config;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

public class SecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler implements MethodSecurityExpressionHandler {
    public SecurityExpressionHandler() {
    }

    protected MethodSecurityExpressionOperations createSecurityExpression(Authentication authentication, MethodInvocation invocation) {
        SecurityExpression root = new SecurityExpression(authentication);
        root.setThis(invocation.getThis());
        root.setPermissionEvaluator(this.getPermissionEvaluator());
        return root;
    }
}