package rdp.fit.bstu.application;

import android.media.Image;

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
    public static Data[] JSONDeserialise(String path, String filename) throws IOException, JSONException {
        File file = new File(path, String filename);
        BufferedReader bufferedReader;
        try (FileReader fileReader = new FileReader(file)) {
            bufferedReader = new BufferedReader(fileReader);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null){
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        // This responce will have Json Format String
        String responce = stringBuilder.toString();
        JSONObject jsonObject  = new JSONObject(responce);
        Data[] data = jsonObject.get("Datas").toString();
        return null;
    }
    public static void JSONSerialise(String path, String filename,Data[] data) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Datas", data);
        String userString = jsonObject.toString();
        //!!SET PATH!!
        File file = new File(path, filename);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(userString);
        bufferedWriter.close();
    }
}
