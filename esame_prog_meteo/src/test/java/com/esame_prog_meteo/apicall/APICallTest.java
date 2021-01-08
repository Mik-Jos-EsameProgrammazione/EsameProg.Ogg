package com.esame_prog_meteo.apicall;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class APICallTest {
	
	APICall call = null;
	
	@BeforeEach
	void setUp() throws Exception {
		call = new APICall();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws IOException {
		assertNotNull(call.chiama("Montegiorgio", "19424eeea64914627b18e861c3ae0688"));
		
	}
	
	@Test
	void test1() {
		assertThrows(IOException.class, () -> { call.chiama("Montegiorgio", "");});
	}
}
