package com.mb.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mb.sbf.App;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.Charset;

@Component
public class SbfServiceInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //String requestBody = IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8").toString());

        //logger.info("Request : " + requestBody);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        //logger.info("Request : " + request.toString());
    }
    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {

        //logger.info("Response : " + response.toString());
    }
}