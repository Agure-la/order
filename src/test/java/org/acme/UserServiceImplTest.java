package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;

@QuarkusTest
@QuarkusTestResource(value = H2DatabaseTestResource.class, parallel = true)
public class UserServiceImplTest {
}
