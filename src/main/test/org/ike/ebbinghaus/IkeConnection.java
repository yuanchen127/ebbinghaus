package org.ike.ebbinghaus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @Author: ike
 * @Date: 2019-02-15 0015 14:37
 */
@Slf4j
public class IkeConnection {
    public static void main(String[] args) throws IOException {
        String var1 = "http://localhost:8084/resource/test";
        URL url = new URL(var1);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        String response = StreamUtils.copyToString(conn.getInputStream(), Charset.forName("UTF-8"));
        log.info("response> {}",response);
    }
}
