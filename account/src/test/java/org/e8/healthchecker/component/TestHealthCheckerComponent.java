package org.e8.healthchecker.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class TestHealthCheckerComponent {
    @Autowired
    private HealthCheckerComponent comp;
    
    @Test
    public void whenQueryLatestId_thenReturnSetValue() throws EmptyHealthCheckerException {
        String latestId = comp.queryLatestId();
        Assert.assertEquals("e574abc3-2a08-4cd5-8324-34c1a5500c23", latestId);
        
        String latestId2 = comp.queryLatestId();
        Assert.assertEquals(latestId, latestId2);
    }
}
