package com.javahash.spring.controller;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.apache.commons.httpclient.HttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
/**
 *
 */

@Controller
public class HelloWorldController {

    protected static InputStream getFileStream(String file) {
        return HelloWorldController.class.getResourceAsStream(file);
    }

    @RequestMapping("/index.html")
    public String hello(Model model) {
        model.addAttribute("msg", "Hello world");
        return "hello";
    }

    @RequestMapping(value = "/image.html",
                    method = RequestMethod.POST
                    )
    public void image(@RequestParam(value = "sex",
            required = true) String sex,HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        InputStream in = null;
        if(sex.equals("Male")) {
            in = getFileStream("/image/boy.jpg");
        }else {
            in = getFileStream("/image/girl.jpg");
        }
        IOUtils.copy(in, response.getOutputStream());
    }

    @RequestMapping(value = "/proxy.html",
                    method = RequestMethod.POST
                    )
    public void proxy(@RequestParam(value = "sex",
                      required = true) String sex,HttpServletResponse response)
            throws IOException, URISyntaxException {

        HttpClient client = new HttpClient();
        HttpMethod method = new PostMethod("http://localhost:10000/hello/image.html");
        method.setQueryString("sex="+sex);
        int re = client.executeMethod(method);
        System.out.println(re);
        IOUtils.copy(method.getResponseBodyAsStream(), response.getOutputStream());



    }

}
