package org.example.AlphaCount;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

public class RFCWordCount {

    private static String fetchFromUrl(String url) throws IOException, InterruptedException {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            final HttpGet httpGet = new HttpGet(url);
            System.out.println("Executing request " + httpGet.getRequestLine());

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                StatusLine statusLine = response.getStatusLine();
                System.out.println(statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
                String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                System.out.println("Response body: " + responseBody);
                return responseBody;
            }
        }
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
                            System.out.println(count);
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
/*
httpClient = HttpClients.custom()
            .setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContexts.custom()
                    .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                    .build()
                )
            ).build();

////////////////////////////////////////////////////////////////////////////////////

 private static String fetchFromUrl(String url) throws IOException, InterruptedException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //making get call to given url
        HttpGet httpget = new HttpGet(url);
        System.out.println("Executing request " + httpget.getRequestLine());

        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };

        String responseBody = httpclient.execute(httpget, responseHandler);
        System.out.println("----------------------------------------");
        System.out.println(responseBody);
        return responseBody;
    }

////////////////////////////////////////////////////////////////////////////////////

HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

////////////////////////////////////////////////////////////////////////////////////

    private static String fetchFromUrl(String url) throws IOException, InterruptedException {
        System.out.println("In fetch function");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println( "After fetching from httpClient " + response.body());
        return response.body();
    }

////////////////////////////////////////////////////////////////////////////////////

    private static String getContentFromUrl(String urlString) throws IOException {
        StringBuilder content = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } finally {
            connection.disconnect();
        }

        return content.toString();
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////

 private static String fetchFromUrl(String url) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        String res = "";
        System.out.println("In fetch function");

        try {
            System.out.println("Try block 1 ");
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Try block 2 ");
            if (response.statusCode() == 200) {
                String responseBody = response.body().substring(0, 1000);
                System.out.println(responseBody);
                res = responseBody;
            } else {
                System.err.println("Request failed with status code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Catch block");
            e.printStackTrace();
        }
        return res;
    }

 */