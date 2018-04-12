package com.jacoffee.currencyconverter.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

  private JsonUtils() {}

  private static ObjectMapper defaultMapper = initDefaultObjectMapper();

  public static ObjectMapper initDefaultObjectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    // exclude null fields when rendering json
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    return mapper;
  }

  public static String render(Object any) throws JsonProcessingException {
    return defaultMapper.writeValueAsString(any);
  }

  public static JsonNode getJsonNode(String jsonStr) throws IOException {
    return defaultMapper.readTree(jsonStr);
  }

}
