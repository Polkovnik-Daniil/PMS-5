package rdp.fit.bstu.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //!!SET PATH!!
        try {
            Data[] data = Data.JSONDeserialise("/data/app/rdp.fit.bstu.application-EouPMJ3XPB78WGxWoqxR9g==/", "JSON.json");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}