package nedra_test.service;

import nedra_test.dao.ClickDAO;
import nedra_test.entity.Click;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClickServiceImpl implements ClickService {

    @Autowired
    private ClickDAO clickDAO;

    @Override
    public Click getClick() {
        return clickDAO.getClick();
    }

    @Override
    public Click getClickPlusOne() {
        return clickDAO.getClickPlusOne();
    }

}
