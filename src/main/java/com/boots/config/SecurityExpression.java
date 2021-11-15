package com.boots.config;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

public class SecurityExpression extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private Object filterObject;
    private Object returnObject;
    private Object target;

    public SecurityExpression(Authentication authentication) {
        super(authentication);
    }

    public Object getFilterObject() {
        return this.filterObject;
    }

    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    public Object getReturnObject() {
        return this.returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public Object getThis() {
        return this.target;
    }

    void setThis(Object target) {
        this.target = target;
    }
}
