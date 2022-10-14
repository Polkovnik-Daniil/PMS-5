package rdp.fit.bstu.application;

import android.util.Log;

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

    public Data(){

    }
    public Data(String _Name, String _Recipe, String _Image, String _Category, String _Ingridients, String _Time) {
        this._Name = _Name;
        this._Recipe = _Recipe;
        this._Image = _Image;
        this._Category = _Category;
        this._Ingridients = _Ingridients;
        this._Time = _Time;
    }

    public static ArrayList<Data> JSONDeserialise(String path, String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //InputStream is = Data.class.getResourceAsStream(path + filename);
        InputStream is = new FileInputStream(path + filename);
        if(isFileExists(new File(path, filename))) {
            ArrayList<Data> data = mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Data.class));
            return data;
        }
        return null;
    }
    public static Boolean JSONSerialise(String path, String filename, ArrayList<Data> data) throws IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(path, filename), data);
            return true;
        }catch (Exception exception){
            Log.d("Exception!", exception.getMessage());
            return false;
        }
    }
    public static boolean isFileExists(File file) {
            return file.exists() && !file.isDirectory();
        }
}
