package com.jacoffee.currencyconverter.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.io.IOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class HttpUtils {

  private HttpUtils() {}

  private static Optional<String> parseHttpResponse(HttpResponse response) throws IOException {
    BufferedReader br = null;

    try {
      if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        InputStream is = response.getEntity().getContent();
        br = new BufferedReader(new InputStreamReader(is));
        Optional<String> respOpt = br.lines().reduce((pre, next) -> pre + next);
        return respOpt;
      } else {
        return Optional.empty();
      }
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    } finally {
      IOUtils.closeQuietly(br);
    }
  }

  public static Optional<String> getResponse(String url) {
    HttpGet request = new HttpGet(url);

    CloseableHttpClient client = null;
    try {
      client = HttpClientBuilder.create().build();
      HttpResponse response = client.execute(request);
      return parseHttpResponse(response);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    } finally {
      IOUtils.closeQuietly(client);
    }
  }

  public static void main(String[] args) {
    Optional<String> resp = getResponse("http://free.currencyconverterapi.com/api/v3/convert?q=EUR_CNY&compact=ultra");
    try {
      System.out.println(JsonUtils.getJsonNode(resp.get()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
