package org.example.AlphaCount;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;


public class RFCWordCount {

    private static String fetchFromUrl(String url) throws IOException, InterruptedException {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }
        };

        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }

        HttpClient client = HttpClient.newBuilder()
                .sslContext(sslContext)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println("Response code: " + response.statusCode());
        String responseBody = response.body();
     //   System.out.println("Response body: " + responseBody);
        return responseBody;
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        AtomicInteger ch = new AtomicInteger(0);
        int[] freq = new int[26];
        for( int i =0 ;i < 26; i++ ){
            freq[i] = 0;
        }
        AtomicIntegerArray arr = new AtomicIntegerArray(freq);
        long startTime = System.nanoTime();

        for (int i = 1 ; i <= 100; i++) {
            int finalI = i;
            String url = "https://www.rfc-editor.org/rfc/rfc" + finalI + ".txt";
            Thread thread = Thread.ofVirtual().start(() -> {
                try {
                   // System.out.println("Started virtual thread to fetch");
                    String rfcContent = fetchFromUrl(url);

                    for (char c : rfcContent.toCharArray()) {
                        if (Character.isLowerCase(c)) {
                            int val = arr.get(c-'a');
                            arr.set(c-'a', val+1);
                        }
                    }
                 //   System.out.println("Completed fetching for current url");
                } catch (IOException e) {
                    System.err.println("Error fetching RFC " + finalI + ": " + e.getMessage());
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.join();
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000;

        System.out.println("The aggregated counting takes " + executionTime + "ms");

        for( int i =0 ;i < 26 ; i++ ){
            char curr = (char) ('a' + i);
            System.out.println("Count of " + curr + " is :" + arr.get(i) );
        }
    }
}
