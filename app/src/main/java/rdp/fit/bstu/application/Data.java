package rdp.fit.bstu.application;

import android.media.Image;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Data {
    public String _Name;
    public String _Recipe;
    public String _Image;
    public String _Category;
    public String _Ingridients;
    public String _Time;
    public static Data[] JSONDeserialise(String path, String filename) throws IOException {
        //TODO: Realising Deserialise
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = DATA.class.getResourceAsStream(path);
        if(isFileExists(new File(this.getFilesDir,path))) {
            DATA data = DATA.getInstance();
            data = mapper.readValue(is, DATA.class);
            return data;
        }
        return DATA.getInstance();
        return null;
    }
    public static void JSONSerialise(String path, String filename, Data[] data) throws IOException {
        //TODO: Realising Serialising
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path, filename), data);
        return;
    }
}
