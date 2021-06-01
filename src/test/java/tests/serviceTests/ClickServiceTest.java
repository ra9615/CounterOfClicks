package tests.serviceTests;


import config.TestConfig;
import nedra_test.dao.ClickDAO;
import nedra_test.entity.Click;
import nedra_test.service.ClickServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class ClickServiceTest {

    @Autowired
    private ClickServiceImpl clickServiceImpl;

    @Autowired
    private ClickDAO clickDAO;


    @Test
    void getClickPlusOneTest() {
        given(this.clickDAO.getClickPlusOne()).willReturn(new Click(10));
        Click click = clickServiceImpl.getClickPlusOne();
        assertThat(click.getSum_of_clicks()).isEqualTo(10);
    }

    @Test
    void getClickTest() {
        given(this.clickDAO.getClick()).willReturn(new Click(1));
        Click click = clickServiceImpl.getClick();
        assertThat(click.getSum_of_clicks()).isEqualTo(1);
    }

}
