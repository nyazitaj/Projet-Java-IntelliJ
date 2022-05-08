package com.edu.mns.control.dfs.dfsrcontrol;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DfsrControlApplicationTests {

	private MockMvc mvc;

	// Testing if the employe list is shown or not
	@Test
	private void listAllUtilisateur_checkIfSuccessful() throws Exception {
		mvc.perform(get("/liste-employe")).andExpect(jsonPath("$[0].id").exists());
	}

}
