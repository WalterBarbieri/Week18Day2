package w18d2proveMattina;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class W18d2proveMattinaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldGetUsersList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(status().isFound());
	}

}
