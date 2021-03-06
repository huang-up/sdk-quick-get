package com.huang.es.controller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by admin on 2017/12/29.
 */
@RestController
public class EsqlController {

    private static final String JS = "var base_uri = location.href.replace(/_plugin\\/.*/, '');";

    private String html = StringUtils.EMPTY;

    @GetMapping(value = "/_plugin/esql")
    public void redirect2Esql(HttpServletResponse response) throws IOException {
        response.sendRedirect("/_plugin/esql/");
    }

    @GetMapping(value = "/_plugin/esql/")
    public void esql(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (StringUtils.isEmpty(html)) {
//            URL url = new URL(request.getRequestURL().toString());
//            String protocol = url.getProtocol();
//            String host = url.getHost();

            InputStream stream = null;
            Reader reader = null;
            try {
                stream = getClass().getClassLoader().getResourceAsStream("META-INF/resources/_plugin/esql/index.html");
                reader = new InputStreamReader(stream);
                html = IOUtils.toString(reader);

//                String replacement = String.format("var base_uri = \"%s://%s:%s/\";", protocol, host, 9200);
//                html = StringUtils.replace(html, JS, replacement);
            } finally {
                reader.close();
                stream.close();
            }
        }

        response.getOutputStream().write(html.getBytes());
    }
}
