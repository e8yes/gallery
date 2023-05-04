package org.e8.healthchecker.component;

import java.util.ArrayList;
import java.util.List;
import org.e8.healthchecker.entity.HealthCheckerEntity;
import org.e8.healthchecker.repository.HealthCheckerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckerComponent {

    @Autowired
    private HealthCheckerRepository repo;

    public String queryLatestId() throws EmptyHealthCheckerException {
        List<String> ids = new ArrayList();
        for (HealthCheckerEntity hc : repo.findAll()) {
            ids.add(hc.getId());
        }

        if (ids.isEmpty()) {
            throw new EmptyHealthCheckerException();
        }

        return ids.get(ids.size() - 1);
    }
}
