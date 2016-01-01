package it.http.clientbase;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class HClientBase {

    private HttpClient httpClient = null;
    private String urlRequest = null;

    public HClientBase() {
        this.httpClient = HttpClientBuilder.create().build();
    }

    public HClientBase(String urlRequest) {
        this.httpClient = HttpClientBuilder.create().build();
        this.urlRequest = urlRequest;
    }

    public HClientBase(HttpClient httpClient, String urlRequest) {
        this.httpClient = httpClient;
        this.urlRequest = urlRequest;
    }

    public HttpResponse executeGetRequest(String urlRequest) throws IOException {
        HttpGet getRequest = new HttpGet(urlRequest);
        return httpClient.execute(getRequest);
    }

    public HttpResponse executePostRequest(String url, List<NameValuePair> params) throws UnsupportedEncodingException, IOException {
        HttpPost postRequest = new HttpPost(url);
        postRequest.setEntity(new UrlEncodedFormEntity(params));
        return this.httpClient.execute(postRequest);
    }

    public HttpResponse executeGetRequest() throws IOException {
        return this.executeGetRequest(this.urlRequest);
    }
}
