package com.huang.jsons;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Created by h on 2018/4/1.
 */
@Slf4j
public class Jakson {
    public static void main(String[] args) throws IOException {
        /*HttpURLConnection urlConnection = (HttpURLConnection)(new URL("localhost:8080").openConnection());
        try {
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setReadTimeout(3000);
            urlConnection.setConnectTimeout(1000);
            urlConnection.setRequestMethod("POST");

            String body = "123456";

            Writer writer = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
//            JsonFactory jsonFactory = new JsonFactory();
//            jsonFactory.createGenerator(writer);

            writer.write(body);
            writer.flush();
            writer.close();
        } finally {

        }*/


        JsonFactory jsonFactory = new ObjectMapper().getFactory();

        JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out, JsonEncoding.UTF8);
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("a", 1);
        jsonGenerator.writeFieldName("b");
        jsonGenerator.writeRawValue(JSON.toJSONString(new Student("jack", 20)));
        jsonGenerator.writeObjectField("c", new Student("son", 18));
        jsonGenerator.writeArrayFieldStart("d");
        jsonGenerator.writeObject(new Student("cc", 21));
        jsonGenerator.writeObject(new Student("dd", 19));
        jsonGenerator.writeString("周杰伦");
        jsonGenerator.writeNumber(4.5);
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
        jsonGenerator.flush();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Student {

        private String name;
        private int age;
    }
}
