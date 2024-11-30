package med.voll.api.controllers;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.config.dto.DetailsConsultationsDTO;
import med.voll.api.domain.physician.Specialty;
import med.voll.api.services.ConsultReservService;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ConsultationsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DetailsConsultationsDTO> dataReservConsultation;

    @Autowired
    private JacksonTester<ConsultationsDataDTO> dataDetailsConsultation;

    @MockBean
    private ConsultReservService consultReservService;

    @Test
    @DisplayName("Return http 400 ")
    @WithMockUser
    void testReservation1() throws Exception {

        var response = mvc.perform(MockMvcRequestBuilders.post("/api/v1/consultations")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

    @Test
    @DisplayName("Return http 200")
    @WithMockUser
    void testReservation2() throws Exception {

        var date = LocalDateTime.now().plusHours(1);
        var specialty = Specialty.CARDIOLOGY;
        var dataDetail = new DetailsConsultationsDTO(null, 2l, 5l, date);
        when(consultReservService.reserv(any())).thenReturn(dataDetail);

        var response = mvc
                .perform(MockMvcRequestBuilders.post("/api/v1/consultations").contentType(MediaType.APPLICATION_JSON)
                        .content(dataDetailsConsultation.write(new ConsultationsDataDTO(2l, 5l, date, specialty))
                                .getJson()))
                .andReturn().getResponse();

        var jsonExpected = dataReservConsultation.write(dataDetail).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonExpected);

    }
}
