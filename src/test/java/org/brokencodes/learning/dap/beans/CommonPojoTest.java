package org.brokencodes.learning.dap.beans;

import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

class CommonPojoTest {

    private static final String POJO_PACKAGE = "org.brokencodes.learning.dap.beans";

    @Test
    void commonTest() {
        ValidatorBuilder.create()
                .with(new GetterTester())
                .with(new SetterTester())
                .build()
                .validate(POJO_PACKAGE);
    }

}