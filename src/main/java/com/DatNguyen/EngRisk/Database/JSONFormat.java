package com.DatNguyen.EngRisk.Database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class JSONFormat {
    // Read File
    public String VocabJsonFormat(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    // Get The JSON File
    public JSONObject getJSON() throws IOException, ParseException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Data.json");

        if (inputStream == null) {
            throw new FileNotFoundException("File 'Data.json' not found in the resources directory");
        }

        String data = new String(inputStream.readAllBytes());
        JSONParser parser = new JSONParser();
        Object parsedObject = parser.parse(data);

        if (parsedObject instanceof JSONArray) {
            // If the parsed object is an array, take the first element as a JSONObject
            JSONArray jsonArray = (JSONArray) parsedObject;
            if (!jsonArray.isEmpty()) {
                return (JSONObject) jsonArray.get(0);
            } else {
                throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN);
            }
        } else if (parsedObject instanceof JSONObject) {
            // If the parsed object is already a JSONObject, return it
            return (JSONObject) parsedObject;
        } else {
            throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN);
        }
    }

    Map<String, Object> jsonToMap() throws IOException, ParseException {
        JSONObject json = getJSON();
        Map<String, Object> result = jsonToMap(json);
        return result;
    }

    Map<String, Object> jsonToMap(JSONObject json) throws JsonProcessingException {
        Map<String, Object> result = new ObjectMapper().readValue(json.toJSONString(), HashMap.class);
        return result;
    }


}
