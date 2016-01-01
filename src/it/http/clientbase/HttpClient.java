package it.http.clientbase;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import it.http.clientbase.properties.PropertiesReader;

public class HttpClient {

    public static void main(String[] args) throws IOException {
        PropertiesReader pr = new PropertiesReader();

        HClientBase hClientBase = new HClientBase();
        HttpResponse hResponse = hClientBase.executeGetRequest(
                pr.getPropValue("url")
        );

        HttpEntity hrBody = hResponse.getEntity();
        String hrbContent = EntityUtils.toString(hrBody);

        System.out.println(hrbContent);
    }
}
