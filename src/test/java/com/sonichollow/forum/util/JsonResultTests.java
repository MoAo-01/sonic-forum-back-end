package com.sonichollow.forum.util;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonResultTests {
    @Test
    void testJsonResult() {
        System.out.println(new JsonResult<Void>(200, "success"));
        System.out.println(new JsonResult<Void>("error"));
        System.out.println(new JsonResult<Void>(404));
        System.out.println(new JsonResult<Map>(
                200, "success",
                new HashMap<String, String>() {
                    {
                        put("username", "Alice");
                        put("age", "20");
                    }
                }
        ));
    }
}
