package com.mazzocchitomas.simpleinterestmicroservice.model.error;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorResponse {
    private int status;
    private String message;
    private Map<String, Object> extras;

    public ErrorResponse(int status, String message) {
        this(status, message, new HashMap<>());
    }

    @JsonIgnore
    public ErrorResponse putExtra(String key, Object value) {
        extras.put(key, value);
        return this;
    }
}
