package com.okellyson.carregister.config;

import org.springframework.util.Assert;

public class GenericService {

    public void notIfNull(Object obj, String message) {

        Assert.notNull(obj, message);

    }

}
