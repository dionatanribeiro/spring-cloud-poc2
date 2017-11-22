package com.in28minutes.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());

        return null;
    }

    /**
     * Indica quando o log deve ser lançado, Ex: antes do request ser executado("pre"), depois do request("post") ou
     * apenas quando ocorrerem erros("error").
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * Informa a ordem de prioridade do filtro.
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * Possibilita adicionar regras de negócio em cada request para identificar quando o log deve ser lançado.
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

}
