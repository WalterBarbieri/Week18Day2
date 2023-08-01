package w18d2esercizio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class W18d2esercizioApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void checkItalianLanguage() throws Exception {
		String response = "Una prentoazione vale solo per un giorno e può essere effettuata se la postazione risulta libera per quel giorno; l'utente può ricercare la postazione indicando tipo di postazione e città: un utente puù avere più prenotazioni ma non nella stessa data; una richiesta di prenotazione puù essere effettuata fino a due giorni prima.";
		mockMvc.perform(MockMvcRequestBuilders.get("/esercizio1/italiano"))
				.andExpect(MockMvcResultMatchers.content().string(response));
	}

	@Test
	void checkEnglishLanguage() throws Exception {
		String response = "A booking last 1 day and can be issued if the location is free; user can search for a location by location type and city; a user can have multiple bookings, but not on the same day; a booking can be issued until 2 days prior the desidered date.";
		mockMvc.perform(MockMvcRequestBuilders.get("/esercizio1/english"))
				.andExpect(MockMvcResultMatchers.content().string(response));
	}

	@Test
	void checkUnsupportedLanguage() throws Exception {
		String response = "Language not supported";
		mockMvc.perform(MockMvcRequestBuilders.get("/esercizio1/armeno"))
				.andExpect(MockMvcResultMatchers.content().string(response));
	}

}
