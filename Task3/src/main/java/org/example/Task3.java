package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.TestDto;
import org.example.dto.TestsDto;
import org.example.dto.ValueDto;
import org.example.dto.ValuesDto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Task3 {
    public static ValuesDto valuesDto;

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file1 = new File("src/main/resources/tests.json");
        TestsDto testsDto = objectMapper.readValue(file1, TestsDto.class);

        File file2 = new File("src/main/resources/values.json");
        valuesDto = objectMapper.readValue(file2, ValuesDto.class);

        List<TestDto> reports = recursion(testsDto.tests);
        String json = objectMapper.writeValueAsString(reports);

        File file3 = new File("src/main/resources/reports.json");
        FileWriter fileWriter = new FileWriter(file3, false);
        fileWriter.write(json);
        fileWriter.flush();
    }

    public static List<TestDto> recursion(List<TestDto> tests) {
        if (tests == null) {
            return null;
        }

        for (TestDto test : tests) {
            test.value = getValueById(test.id);
            recursion(test.values);
        }

        return tests;
    }

    public static String getValueById(int id) {
        for (ValueDto value : valuesDto.values) {
            if (value.id == id) {
                return value.value;
            }
        }

        return "";
    }
}
