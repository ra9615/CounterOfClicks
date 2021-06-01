package tests.webTests;


import nedra_test.controller.MyController;
import nedra_test.entity.Click;
import nedra_test.service.ClickService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class MyControllerTest {

    @Mock
    private ClickService clickService;

    @InjectMocks
    private MyController myController;

    private MockMvc mockMvc;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
    }

    @Test
    public void countTest() throws Exception {

        Click click = new Click();

        when(clickService.getClickPlusOne()).thenReturn(click);

        mockMvc.perform(MockMvcRequestBuilders.get("/count")).
                andExpect(status().isOk())
                .andExpect(view().name("sum_of_clicks"))
                .andExpect(model().attribute("click", instanceOf(Click.class)));
    }

    @Test
    public void FirstViewTest() throws Exception {

        Click click = new Click();

        when(clickService.getClick()).thenReturn(click);

        mockMvc.perform(MockMvcRequestBuilders.get("/")).
                andExpect(status().isOk())
                .andExpect(view().name("sum_of_clicks"))
                .andExpect(model().attribute("click", instanceOf(Click.class)));
    }
}
