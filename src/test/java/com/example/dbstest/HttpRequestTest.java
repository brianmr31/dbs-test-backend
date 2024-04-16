package com.example.dbstest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    
    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello",
			String.class)).contains("Hello");
	}

    @Test
	void greetingShouldReturnDefaultMessageError() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:"+ port + "/hello",
			String.class)).doesNotContain("Wkwkwkwkkw");
	}

    @Test
	void getMessage() throws Exception {
        MessageData tmp = this.restTemplate.getForObject("http://localhost:"+ port + "/hello", MessageData.class);
		assertThat( tmp.msg ).isEqualTo("Hello");
	}

    @Test
	void testHttpRequestTest() throws Exception {
        // Map<String,  String> newObj = new HashMap<String, String>();
        String newObj = this.restTemplate.getForObject("http://localhost:" + port + "/employees/0/10/name/NONE", String.class);
        JSONObject jsonObject= new JSONObject( newObj );

		assertThat( jsonObject.get("number")  ).isEqualTo(0);
	}

    @Test
	void testHttpRequestTest2() throws Exception {
        String newObj = this.restTemplate.getForObject("http://localhost:" + port + "/employees/0/10/name/NONE", String.class);
        JSONObject jsonObject= new JSONObject( newObj );
        JSONArray content = jsonObject.getJSONArray( "content" );
		assertThat( content.length() ).isEqualTo(4);
	}

}
