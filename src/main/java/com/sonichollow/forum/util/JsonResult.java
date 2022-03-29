package com.sonichollow.forum.util;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer state;
    private String message;
    private E data;

    JsonResult(Integer state) {
        this.state = state;
    }

    JsonResult(String message) {
        this.message = message;
    }

    JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }
}
