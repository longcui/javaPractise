package http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class HttpClientTest {

	/**
	 * using apache common HttpClient
	 * @throws IOException
	 */
    @Test
    public void test1() throws IOException {
		final int BUFFER_SIZE = 4096;

		HttpClient httpclient = HttpClientBuilder.create().build();

		String encoding = Base64.getEncoder().encodeToString("geir:Nikiki123".getBytes());
    	HttpGet httpGet = new HttpGet("http://localhost/linq-web/report/getDashboardReport/report/pdf/dashboardReportDynamic.xml?filename=dashboard.pdf&siteId=&selectedProjectDate=29.01.2018&assignmentId=57&isPdf=true&templateId=10");
    	httpGet.setHeader("Authorization", "Basic " + encoding);

    	System.out.println("executing request " + httpGet.getRequestLine());
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Response Code : "
				+ response.getStatusLine().getStatusCode());
		HttpEntity entity = response.getEntity();

		InputStream inputStream = entity.getContent();

		// opens an output stream to save into file
		FileOutputStream outputStream = new FileOutputStream("d:/aa.pdf");

		int bytesRead = -1;
		byte[] buffer = new byte[BUFFER_SIZE];
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		outputStream.close();
		inputStream.close();

		System.out.println("File downloaded");
    }
}
