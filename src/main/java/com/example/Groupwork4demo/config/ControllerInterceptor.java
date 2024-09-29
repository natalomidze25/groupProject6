package com.example.Groupwork4demo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class ControllerInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<String> currentController = new ThreadLocal<>();

    public static String getCurrentController(){
        return currentController.get();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            currentController.set(handlerMethod.getBeanType().getSimpleName());
        }
        else{
            currentController.set(handler.getClass().getSimpleName());
        }
         return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,Object handler,Exception ex){
        currentController.remove();
    }
}
