package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestDto {
    public int id;
    public String title;
    public String value;
    public List<TestDto> values;
}
