package rdp.fit.bstu.application;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public String _Name = null;
    public String _Recipe = null;
    public String _Image = null;
    public String _Category = null;
    public String _Ingridients = null;
    public String _Time = null;
    public static ArrayList<Data> JSONDeserialise(String path, String filename) throws IOException {
        //TODO: Realising Deserialise
        ObjectMapper mapper = new ObjectMapper();
        //InputStream is = Data.class.getResourceAsStream(path + filename);
        InputStream is = new FileInputStream(path + filename);
        if(isFileExists(new File(path, filename))) {
            ArrayList<Data> data = mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Data.class));
            return data;
        }
        return null;
    }
    public static void JSONSerialise(String path, String filename, ArrayList<Data> data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path, filename), data);
        return;
    }
    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }
}
