package com.learn.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

//单元测试
public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48884855184228/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxqsessionid=53a34a8be876886b9b8bb346cd0680a9; UM_distinctid=18731c276a6a6b-033c7830ea2376-26031851-144000-18731c276a7a23; sensorsdata2015jssdkcross={\"distinct_id\":\"415482524245288\",\"first_id\":\"181d941a5ad5c8-0d6cca8d731cb98-26021a51-1327104-181d941a5ae365\",\"props\":{\"$latest_traffic_source_type\":\"社交网站流量\",\"$latest_search_keyword\":\"未取到值\",\"$latest_referrer\":\"https://open.weixin.qq.com/\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxZDk0MWE1YWQ1YzgtMGQ2Y2NhOGQ3MzFjYjk4LTI2MDIxYTUxLTEzMjcxMDQtMTgxZDk0MWE1YWUzNjUiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU0ODI1MjQyNDUyODgifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"415482524245288\"},\"$device_id\":\"181d941a5ad5c8-0d6cca8d731cb98-26021a51-1327104-181d941a5ae365\"}; zsxq_access_token=E20AB526-F676-B00A-5659-3866D1B332B1_7F75FA560B85B75E; abtest_env=product");
        get.addHeader("content-Type","application/json;charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412588824581448/answer");
        post.addHeader("cookie","zsxqsessionid=53a34a8be876886b9b8bb346cd0680a9; UM_distinctid=18731c276a6a6b-033c7830ea2376-26031851-144000-18731c276a7a23; sensorsdata2015jssdkcross={\"distinct_id\":\"415482524245288\",\"first_id\":\"181d941a5ad5c8-0d6cca8d731cb98-26021a51-1327104-181d941a5ae365\",\"props\":{\"$latest_traffic_source_type\":\"社交网站流量\",\"$latest_search_keyword\":\"未取到值\",\"$latest_referrer\":\"https://open.weixin.qq.com/\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxZDk0MWE1YWQ1YzgtMGQ2Y2NhOGQ3MzFjYjk4LTI2MDIxYTUxLTEzMjcxMDQtMTgxZDk0MWE1YWUzNjUiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU0ODI1MjQyNDUyODgifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"415482524245288\"},\"$device_id\":\"181d941a5ad5c8-0d6cca8d731cb98-26021a51-1327104-181d941a5ae365\"}; zsxq_access_token=E20AB526-F676-B00A-5659-3866D1B332B1_7F75FA560B85B75E; abtest_env=product");
        post.addHeader("content-Type","application/json;charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"俺不会\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response =  httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
