package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by cdx on 2019/12/17.
 * desc:
 */
public class JacksonTest {

    //java对象转为json字符串
    @Test
    public void objToJson() throws IOException {
        Person p = new Person();
        p.setAge(29);
        p.setGender("女");
        p.setName("张三");
        p.setBirthday(new Date());

        // 创建 objectMapper jackson核心对象
        ObjectMapper mapper = new ObjectMapper();

        /*mapper.writeValue(parameter, object);
        parameter:
        file:
        将object转换为json字符串，并保存到指定文件中
        writer：将object。。。，填充到字符串输出流中
        outputstream：填充到字节输出流中*/

        // mapper.writeValueAsString(p);


        String s = mapper.writeValueAsString(p);
        mapper.writeValue(new File("d://a.txt"), p);
        System.out.println(s);
    }

    @Test
    public void listToJson() throws IOException {
        List<Person> list = new ArrayList<>();
        Person p = new Person();
        p.setAge(29);
        p.setGender("女");
        p.setName("张三");
        p.setBirthday(new Date());

        Person p2 = new Person();
        p2.setAge(29);
        p2.setGender("女");
        p2.setName("张三");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setAge(29);
        p3.setGender("女");
        p3.setName("张三");
        p3.setBirthday(new Date());
        list.add(p);
        list.add(p2);
        list.add(p3);

        // 创建 objectMapper jackson核心对象
        ObjectMapper mapper = new ObjectMapper();

        /*mapper.writeValue(parameter, object);
        parameter:
        file:
        将object转换为json字符串，并保存到指定文件中
        writer：将object。。。，填充到字符串输出流中
        outputstream：填充到字节输出流中*/

        // mapper.writeValueAsString(p);


        String s = mapper.writeValueAsString(list);
        //mapper.writeValue(new File("d://a.txt"), p);
        System.out.println(s);
    }

    @Test
    public void mapToJson() throws IOException {
        Map<String, Object> map = new HashMap<>();

        map.put("name", "张三");
        map.put("age", 22);

        map.put("gender", "女");

        // 创建 objectMapper jackson核心对象
        ObjectMapper mapper = new ObjectMapper();

        /*mapper.writeValue(parameter, object);
        parameter:
        file:
        将object转换为json字符串，并保存到指定文件中
        writer：将object。。。，填充到字符串输出流中
        outputstream：填充到字节输出流中*/

        // mapper.writeValueAsString(p);


        String s = mapper.writeValueAsString(map);
//        mapper.writeValue(new File("d://a.txt"), p);
        System.out.println(s);
    }

    @Test
    public void jsonToObject() throws IOException {
        String p = "{\"name\":\"张三\",\"age\":29,\"gender\":\"女\",\"birthday\":\"2019-12-17\"}";
        // 创建 objectMapper jackson核心对象
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(p, Person.class);
        System.out.println(person);
    }
}
