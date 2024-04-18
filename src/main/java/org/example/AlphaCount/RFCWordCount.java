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
import java.util.concurrent.atomic.AtomicReference;

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

        System.out.println("Response code: " + response.statusCode());
        String responseBody = response.body();
        System.out.println("Response body: " + responseBody);
        return responseBody;
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        AtomicReference<Integer> count = new AtomicReference<>(0);

        for (int i = 1 ; i <= 100; i++) {
            int finalI = i;
            String url = "https://www.rfc-editor.org/rfc/rfc" + finalI + ".txt";
            Thread thread = Thread.ofVirtual().start(() -> {
                try {
                    System.out.println("Started virtual thread to fetch");
                    String rfcContent = fetchFromUrl(url);

                    for (char c : rfcContent.toCharArray()) {
                        if (Character.isLowerCase(c)) {
                            count.getAndSet(count.get() + 1);
                            System.out.println("Current count of words is : "+ count);
                        }
                    }
                    System.out.println("Completed fetching for current url");
                } catch (IOException e) {
                    System.err.println("Error fetching RFC " + finalI + ": " + e.getMessage());
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.join();
        }
        System.out.println("The count of all characters is: " + count);
    }
}
