package com.example.remitlytask;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class JsonSolutionTest {

    @Test
    public void testVerifyInputJson_AllowedResource() {
        String filePath = "C:\\Users\\wojci\\IdeaProjects\\Remitly-Task\\src\\test\\resources\\remitlytask\\allowedData.JSON";

        boolean result = JsonSolution.verifyInputJson(filePath);

        assertTrue(result);
    }

    @Test
    public void testVerifyInputJson_DeniedResource() {
        String filePath = "C:\\Users\\wojci\\IdeaProjects\\Remitly-Task\\src\\test\\resources\\remitlytask\\badData.JSON";

        boolean result = JsonSolution.verifyInputJson(filePath);

        assertFalse(result);
    }

    @Test
    public void testVerifyInputJson_FileNotFound() {
        String filePath = "nonexistent_file.json";

        boolean result = JsonSolution.verifyInputJson(filePath);

        assertFalse(result, "Expected file not found exception.");
    }

}
