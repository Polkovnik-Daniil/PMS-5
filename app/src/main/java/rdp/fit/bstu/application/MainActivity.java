package rdp.fit.bstu.application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Data> datas = new ArrayList<Data>();
        Data data1 = new Data();
        Data data2 = new Data();
        data1._Name = "odmvb";
        data1._Category= "ofdnv";
        data1._Ingridients="fobn";
        data1._Recipe="123";
        data1._Image="f12436obn";
        data2._Name = "1235";
        data2._Category= "of1324впdnv";
        data2._Ingridients="аилошт";
        data2._Recipe="авим";
        data2._Image="авмлшот";
        datas.add(data1);
        datas.add(data2);
        //!!SET PATH!!
        Log.d("PATH \t","Path\t"+getApplicationInfo().dataDir + "JSON.json");
        try {
            Data.JSONSerialise(getApplicationInfo().dataDir, "JSON.json", datas);
            ArrayList<Data> data = Data.JSONDeserialise("/data/data/rdp.fit.bstu.application/", "JSON.json");
            Log.d("","Path\t"+getApplicationInfo().dataDir + "JSON.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}