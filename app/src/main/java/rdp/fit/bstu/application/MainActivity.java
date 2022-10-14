package rdp.fit.bstu.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayList<Data> datas = InitList();
        try {
            Data.JSONSerialise("/data/data/rdp.fit.bstu.application/", "JSON1.json", datas);
            ArrayList<Data> data = Data.JSONDeserialise("/data/data/rdp.fit.bstu.application/", "JSON1.json");
            Log.d("PATH","Path\t"+getApplicationInfo().dataDir + "JSON.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataListAdapter dla = new  DataListAdapter(this, R.layout.adapter_view_layout, datas);
        listView.setAdapter(dla);
    }

    protected ArrayList<Data> InitList(){
        ArrayList<Data> datas = new ArrayList<Data>();

        Data data1 = new Data("TORT", "CLADKOE","MNOGO","NE ODIN","NE PROSTAYA","12-43-1242");
        Data data2 = new Data("CHOCOLATE", "SLADKOE","MNOGO", "NE ODNI","GDE-TO", "12-43-1242");

        data1._Name = "TORT";
        data1._Category= "CLADKOE";
        data1._Ingridients="MNOGO";
        data1._Recipe="NE ODIN";
        data1._Image="NE PROSTAYA";

        data2._Name = "CHOCOLATE";
        data2._Category= "SLADKOE";
        data2._Ingridients="MNOGO";
        data2._Recipe="NE ODNI";
        data2._Image="GDE-TO";

        datas.add(data1);
        datas.add(data2);

        return datas;
    }
}