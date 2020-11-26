package com.nilson.apptres;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;




        // Cesfam de hualpen, concepcion, talcahuano, chiguayante
        //Cesfam Floresta
        Double latEstatica = -36.792005;
        Double lonestatica = -73.11391;
        String titulo = "Cesfam la floresta";
        LatLng cesfamFloresta = new LatLng(latEstatica, lonestatica);
        mMap.addMarker(new MarkerOptions().position(cesfamFloresta).title(titulo));

        //Cesfam Hualpen
        latEstatica = -36.7826579;
        lonestatica = -73.1034645;
        titulo = "Cesfam Hualpen";
        LatLng cesfamHualpen = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(cesfamHualpen).title(titulo));

       // Cesfam Santa Sabina
        latEstatica =-36.7924037;
        lonestatica =-73.0442655;
        titulo = "Cesfam Santa Sabina";
        LatLng cesfamSantaSabina = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(cesfamSantaSabina).title(titulo));

        //Sapu Lorenzo Arenas
        latEstatica =-36.808838;
        lonestatica =-73.0715865;
        titulo = "Sapu Lorenzo Arenas";
        LatLng SapuLorenzoArenas = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(SapuLorenzoArenas).title(titulo));

        //SAR tucapel
        latEstatica =-36.8108738;
        lonestatica =-73.0539268;
        titulo = "SAR Tucapel";
        LatLng SarTucapel = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(SarTucapel).title(titulo));

        //Cesfam Tucapel
        latEstatica =-36.8253418;
        lonestatica =-73.0456227;
        titulo = "Cesfam Tucapel";
        LatLng CesfamTucapel = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(CesfamTucapel).title(titulo));

        //Cesfam Ohiggins
        latEstatica =-36.8285806;
        lonestatica =-73.0563049;
        titulo = "Cesfam OHiggins";
        LatLng CesfamOh = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(CesfamOh).title(titulo));

        //Cesfam Nonguen
        latEstatica =-36.8309754;
        lonestatica =-73.0064785;
        titulo = "Cesfam Villa Nonguen";
        LatLng CesfamNonguen = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(CesfamNonguen).title(titulo));

        //cecof 8 de mayo
        latEstatica =-36.7788232;
        lonestatica =-73.0985427;
        titulo = "Cecof 8 de mayo";
        LatLng cecof8 = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(cecof8).title(titulo));

        //Cesfam talcahuano sur
        latEstatica =-36.7988043;
        lonestatica =-73.0969226;
        titulo = "Cesfam Talcahuano Sur";
        LatLng cesfamthn = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(cesfamthn).title(titulo));

        //-consultorio esmeralda
        latEstatica =-36.778458;
        lonestatica =-73.0924863;
        titulo = "Consultorio esmeralda";
        LatLng consulem = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(consulem).title(titulo));

        //Cesfam PAulina Avendaño
        latEstatica =-36.7507825;
        lonestatica =-73.1018096;
        titulo = "Cesfam Paulina Avendaño";
        LatLng Cesfampau = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(Cesfampau).title(titulo));

        //hospital higueras
        latEstatica =-36.7406123;
        lonestatica =-73.1088746;
        titulo = "Cesfam Paulina Avendaño";
        LatLng Hospitalh = new LatLng(latEstatica,lonestatica);
        mMap.addMarker(new MarkerOptions().position(Hospitalh).title(titulo));



        //permite hacer un zoom definido para ver mas cerca la posicion
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(, 18));
        //cambia el tipo de mapa a satelital.
        // mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        //agrega los persmisos para la app gps


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);




    }





}