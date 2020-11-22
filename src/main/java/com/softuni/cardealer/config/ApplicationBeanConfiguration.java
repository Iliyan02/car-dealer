package com.softuni.cardealer.config;

import com.google.gson.*;
import com.softuni.cardealer.utils.XmlParser;
import com.softuni.cardealer.utils.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>(){
                    @Override public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException{
                        return LocalDateTime
                                .parse(json.getAsString(), DateTimeFormatter.ofPattern("yyy-MM-dd'T'HH:mm:ss")); }})
                .create();
    }

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }
}
