package es.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.core.util.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

/**
 * Created by admin on 2017/12/29.
 */
@RestController
public class HeadController {

    private static final String JS = "var base_uri = location.href.replace(/_plugin\\/.*/, '');";

    private String html = StringUtils.EMPTY;

    @GetMapping(value = "/_plugin/head")
    public void redirect2Head(HttpServletResponse response) throws IOException {
        response.sendRedirect("/_plugin/head/");
    }

    @GetMapping(value = "/_plugin/head/")
    public void head(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (StringUtils.isEmpty(html)) {
            URL url = new URL(request.getRequestURL().toString());
            String protocol = url.getProtocol();
            String host = url.getHost();

            InputStream stream = null;
            Reader reader = null;
            try {
                stream = getClass().getClassLoader().getResourceAsStream("_plugin/head/index.html");
                reader = new InputStreamReader(stream);
                html = IOUtils.toString(reader);

                String replacement = String.format("var base_uri = \"%s://%s:%s/\";", protocol, host, 9200);
                html = StringUtils.replace(html, JS, replacement);
            } finally {
                reader.close();
                stream.close();
            }
        }

        response.getOutputStream().write(html.getBytes());
    }
}
