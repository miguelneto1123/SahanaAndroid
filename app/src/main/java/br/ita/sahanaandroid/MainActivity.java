package br.ita.sahanaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Date;
import java.util.ArrayList;

import br.ita.sahanaandroid.dominio.entidades.Event;


public class MainActivity extends Activity {
    ListView listView ;


    ArrayList<String> eventList = new ArrayList<String>();
    ArrayList<LatLng> positionList = new ArrayList<LatLng>();

    private void eventGenerator() {
        Event noveJulho = new Event();
        noveJulho.setDate(new Date(117, 06, 8));
        noveJulho.setFechado(true);
        noveJulho.setNome("Furacão na Nove de Julho");
        noveJulho.setTipo("Furacão");
        noveJulho.setLatitude(-23.198192);
        noveJulho.setLongitude(-45.8948292);

        Event paraibuna = new Event();
        paraibuna.setDate(new Date(117, 06, 7));
        paraibuna.setFechado(true);
        paraibuna.setNome("Incêndio na Paraibuna");
        paraibuna.setTipo("Incêndio");
        paraibuna.setLatitude(-23.1981);
        paraibuna.setLongitude(-45.89482);

        Event nelson = new Event();
        nelson.setDate(new Date(117, 06, 21));
        nelson.setFechado(false);
        nelson.setNome("Terremoto na Nelson D´Avila");
        nelson.setTipo("Terremoto");
        nelson.setLatitude(-23.191);
        nelson.setLongitude(-45.8942);

        Event andromeda = new Event();
        andromeda.setDate(new Date(117, 06, 7));
        andromeda.setFechado(true);
        andromeda.setNome("Maremoto na Andromeda");
        andromeda.setTipo("Maremoto");
        andromeda.setLatitude(-23.1915);
        andromeda.setLongitude(-45.89452);

        eventList.add(noveJulho.getNome()+"   "+noveJulho.getData()+" "+noveJulho.getTipo());
        eventList.add(paraibuna.getNome()+"   "+paraibuna.getData()+" "+paraibuna.getTipo());
        eventList.add(nelson.getNome()+"   "+nelson.getData()+" "+nelson.getTipo());
        eventList.add(andromeda.getNome()+"   "+andromeda.getData()+" "+andromeda.getTipo());

        positionList.add(new LatLng(noveJulho.getLatitude(),noveJulho.getLongitude()));
        positionList.add(new LatLng(paraibuna.getLatitude(),paraibuna.getLongitude()));
        positionList.add(new LatLng(nelson.getLatitude(),nelson.getLongitude()));
        positionList.add(new LatLng(andromeda.getLatitude(),andromeda.getLongitude()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        eventGenerator();
        // Defined Array values to show in ListView
        String[] values = new String[] { eventList.get(0),
                eventList.get(1),
                eventList.get(2),
                eventList.get(3)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, eventList);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                Bundle bundle = new Bundle();
                bundle.putFloatArray("position",new float[]{
                        (float)positionList.get(position).latitude,
                        (float)positionList.get(position).longitude});
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

}