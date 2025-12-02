package com.microsoft.hackathon.copilotdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;;

@SpringBootTest()
@AutoConfigureMockMvc
class CopilotDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	// Create a test to check if the /hello GET operation that accepts key as query parameter and returns "hello <key>" is working correctly.
	@Test
	void testHelloWithKey() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("key", "world"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("hello world"));
	}

	// Create a test to check if the /hello GET operation returns "key not passed" when no key is provided
	@Test
	void testHelloWithoutKey() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("key not passed"));
	}

	// Create a test to check if the /hello GET operation returns "key not passed" when an empty key is provided
	@Test
	void testHelloWithEmptyKey() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("key", ""))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("key not passed"));
	}

	// Test the /hello endpoint with special characters in the key
	@Test
	void testHelloWithSpecialCharacters() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("key", "test@#$%"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("hello test@#$%"));
	}

	// Test the /hello endpoint with numeric key
	@Test
	void testHelloWithNumericKey() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("key", "12345"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("hello 12345"));
	}

	// Test the /hello endpoint with whitespace-only key returns the key with whitespace preserved
	@Test
	void testHelloWithWhitespaceKey() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("key", "   "))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("hello    "));
	}

	// Test the /hello endpoint returns Method Not Allowed for POST requests
	@Test
	void testHelloPostMethodNotAllowed() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/hello").param("key", "world"))
				.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	}

}