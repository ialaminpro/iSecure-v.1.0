package com.thealamin.isecure;
        import android.content.Intent;
        import android.support.v4.app.FragmentActivity;
        import android.os.Bundle;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String lat, lng;
    double lati,longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

      /*  getlocation location = new getlocation();
        location.gps();
        TurnOnOffLocation tol = new TurnOnOffLocation();


        lat = tol.mLatitudeLabel;
        lng = tol.mLongitudeLabel;
        lati = Double.parseDouble(lat);
        longi = Double.parseDouble(lng);  */

        Intent refresh = new Intent(this, TurnOnOffLocation.class);
        startActivity(refresh);



    }





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng yourlocation = new LatLng(23.745572, 90.404612);
        mMap.addMarker(new MarkerOptions().position(yourlocation).title("Your Location"));

        LatLng ramana = new LatLng(23.745572, 90.404612);
        mMap.addMarker(new MarkerOptions().position(ramana).title("ramana model thana, 01713373125 "));

        LatLng Dhanmondi = new LatLng(23.743205, 90.381611);
        mMap.addMarker(new MarkerOptions().position(Dhanmondi).title("Dhanmondi Model Thana,01713373126"));

        LatLng Sahabag = new LatLng(23.736491, 90.395725);
        mMap.addMarker(new MarkerOptions().position(Sahabag).title("Sahabag Model Thana"));

        LatLng NewMarket = new LatLng(23.733149, 90.386807);
        mMap.addMarker(new MarkerOptions().position(NewMarket).title("New Market Thana,01713373125"));

        LatLng Lalbag = new LatLng(23.716816, 90.382251);
        mMap.addMarker(new MarkerOptions().position(Lalbag).title("Lalbag Thana01713373134"));

        LatLng Kotwali = new LatLng(23.707333, 90.409203);
        mMap.addMarker(new MarkerOptions().position(Kotwali).title("Kotwali Model Thana 01713373135"));

        LatLng Hajaribag = new LatLng(23.734797, 90.365236);
        mMap.addMarker(new MarkerOptions().position(Hajaribag).title("Hajaribag Thana01713373136 "));

        LatLng Kamarangiracar = new LatLng(23.718635, 90.365681);
        mMap.addMarker(new MarkerOptions().position(Kamarangiracar).title("Kamarangiracar Thana01713373137 "));

        LatLng Sutrapur = new LatLng(23.702426, 90.418255);
        mMap.addMarker(new MarkerOptions().position(Sutrapur).title("Sutrapur model Thana01713373143 "));

        LatLng Demra = new LatLng(23.724957, 90.494755);
        mMap.addMarker(new MarkerOptions().position(Demra).title("Demra Thana01713373144"));

        LatLng Syamapur = new LatLng(23.691827, 90.431401);
        mMap.addMarker(new MarkerOptions().position(Syamapur).title("Syamapur Thana01713373145 "));

        LatLng Jatrabari = new LatLng(23.710431, 90.435549);
        mMap.addMarker(new MarkerOptions().position(Jatrabari).title("Jatrabari Thana01713373146 "));

        LatLng Motijheel = new LatLng(23.730024, 90.417339);
        mMap.addMarker(new MarkerOptions().position(Motijheel).title("Motijheel Thana01713373152"));

        LatLng Sabujbag = new LatLng(23.741897, 90.428153);
        mMap.addMarker(new MarkerOptions().position(Sabujbag).title("Sabujbag Thana01713373153 "));

        LatLng Khilgaon = new LatLng(23.751009, 90.425211);
        mMap.addMarker(new MarkerOptions().position(Khilgaon).title("Khilgaon Thana01713373154  "));

        LatLng Paltan = new LatLng(23.736112, 90.416126);
        mMap.addMarker(new MarkerOptions().position(Paltan).title("Paltan Thana 01713373155 "));

        LatLng Uttora = new LatLng(23.866945, 90.400612);
        mMap.addMarker(new MarkerOptions().position(Uttora).title("Uttara Thana01713373161  "));

        LatLng Airport = new LatLng(23.850321, 90.409117);
        mMap.addMarker(new MarkerOptions().position(Airport).title("Airport Thana01713373162   "));

        LatLng Turag = new LatLng(23.889224, 90.370925);
        mMap.addMarker(new MarkerOptions().position(Turag).title("Turag Thana01713373163 "));

        LatLng Uttarkhan = new LatLng(23.871048, 90.432698);
        mMap.addMarker(new MarkerOptions().position(Uttarkhan).title("Uttarkhan Thana01713373164"));

        LatLng Daksinakhan = new LatLng(23.859701, 90.426182);
        mMap.addMarker(new MarkerOptions().position(Daksinakhan).title("Daksinakhan Thana01713373165"));

        LatLng Gulshan = new LatLng(23.791270, 90.415468);
        mMap.addMarker(new MarkerOptions().position(Gulshan).title("Gulshan Model Thana01713373171"));

        LatLng Cantonment = new LatLng(23.824612, 90.405555);
        mMap.addMarker(new MarkerOptions().position(Cantonment).title("Dhaka Cantonment Thana-01713373172 "));

        LatLng Budda = new LatLng(23.771479, 90.427392);
        mMap.addMarker(new MarkerOptions().position(Budda).title("Badda Thana 01713373173"));

        LatLng Khilkhet = new LatLng(23.828152, 90.419540);
        mMap.addMarker(new MarkerOptions().position(Khilkhet).title("Khilkhet Thana 01713373174"));

        LatLng Tejgaon = new LatLng(23.761319, 90.389476);
        mMap.addMarker(new MarkerOptions().position(Tejgaon).title("Tejgaon Model Thana 01713373180"));

        LatLng Tejgaoni = new LatLng(23.765381, 90.400640);
        mMap.addMarker(new MarkerOptions().position(Tejgaoni).title("Tejgaon Industrial Area Thana01713373181"));

        LatLng Mohammadapur = new LatLng(23.755701, 90.363906);
        mMap.addMarker(new MarkerOptions().position(Mohammadapur).title("Mohammadapur Model Thana01713373182"));

        LatLng Adabar = new LatLng(23.771186, 90.359425);
        mMap.addMarker(new MarkerOptions().position(Adabar).title("Adabar Thana 01713373183"));

        LatLng Mirpur = new LatLng(23.804345, 90.363140);
        mMap.addMarker(new MarkerOptions().position(Mirpur).title("Mirpur Thana 01713373189"));

        LatLng Pallabi = new LatLng(23.826101, 90.366508);
        mMap.addMarker(new MarkerOptions().position(Pallabi).title("Pallabi Thana 01713373190"));

        LatLng Kafrul = new LatLng(23.801352, 90.381521);
        mMap.addMarker(new MarkerOptions().position(Kafrul).title("Kafrul Thana 01713373191"));

        LatLng Shah = new LatLng(23.805457, 90.348875);
        mMap.addMarker(new MarkerOptions().position(Shah).title("Shah Ali Thana 01713373192"));




        // Add a marker in Sydney and move the camera
        LatLng Dhaka = new LatLng(23.811265, 90.410914);
        LatLng haka = new LatLng(23.804373, 90.378301);


        mMap.addMarker(new MarkerOptions().position(Dhaka).title("Marker in Bangladesh"));
        mMap.addMarker(new MarkerOptions().position(haka).title("Marker in ngladesh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(haka));
    }
}