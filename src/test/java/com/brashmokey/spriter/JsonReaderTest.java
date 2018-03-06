package com.brashmokey.spriter;

import static org.junit.Assert.*;

import com.brashmonkey.spriter.JsonReader;
import org.json.JSONObject;
import org.junit.Test;

import java.io.*;

public class JsonReaderTest {

    @Test
    public void should_load_json_object_from_json_string () throws IOException {
        StringBuilder textBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test.scon")));
        int c = 0;
        while ((c = reader.read()) != -1) {
            textBuilder.append((char) c);
        }
        reader.close();

        JSONObject object = JsonReader.parse(textBuilder.toString());

        assertTrue(object instanceof JSONObject);
        assertTrue(object.toMap().keySet().contains("scon_version"));
    }

    @Test
    public void should_load_json_object_from_input_stream () throws IOException {
        JSONObject object = JsonReader.parse(new FileInputStream(new File("src/test/resources/test.scon")));

        assertTrue(object instanceof JSONObject);
        assertTrue(object.toMap().keySet().contains("scon_version"));
    }
}
