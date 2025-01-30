package com.ecommerce.api.tests.base;

import com.ecommerce.api.utils.RequestBuilder;
import org.testng.annotations.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected String authToken;

    @BeforeClass
    public void setUp() {
        logger.info("Initializing test setup");
        authToken = RequestBuilder.getAuthToken();
    }
}
