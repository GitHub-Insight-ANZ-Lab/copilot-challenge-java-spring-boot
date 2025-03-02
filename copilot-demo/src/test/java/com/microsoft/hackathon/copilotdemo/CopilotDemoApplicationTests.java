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

}