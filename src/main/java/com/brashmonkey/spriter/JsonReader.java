package com.brashmonkey.spriter;

import org.json.*;

import java.io.*;

/** JSON parser.
 * @author mrdlink */
public class JsonReader {

    public JSONObject parse (String json) {
        return new JSONObject(json);
    }

    public JSONObject parse (InputStream input) throws IOException {
        StringBuilder textBuilder = new StringBuilder();

        try {
            Reader reader = new BufferedReader(new InputStreamReader(input, "ISO-8859-1"));
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return new JSONObject(textBuilder.toString());
    }
}
