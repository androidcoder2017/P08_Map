package com.example.a15056112.p08_map;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnNorth, btnCentral, btnEest;
    Spinner sp;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNorth = (Button) findViewById(R.id.buttonNorth);
        btnCentral = (Button)findViewById(R.id.buttonCentral);
        btnEest = (Button)findViewById(R.id.buttonEast);

        sp = (Spinner)findViewById(R.id.spinner);


        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;


                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);
                ui.setZoomControlsEnabled(true);

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                }


            }
        });

        btnNorth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng poi_admiratly = new LatLng(1.441073, 103.772070);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_admiratly, 15));

                final Marker admiratly = map.addMarker(new
                        MarkerOptions()
                        .position(poi_admiratly)
                        .title("HQ -North")
                        .snippet("Block 333, Admiralty Ave 3, 765654\nOperating hours: 10am-5pm\nTel:65433456")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Toast.makeText(MainActivity.this, admiratly.getTitle() + "\n" + admiratly.getSnippet(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

            }
        });

        btnCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng poi_Orchard = new LatLng(1.297802, 103.847441);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Orchard, 15));

                final Marker orchard = map.addMarker(new
                            MarkerOptions()
                            .position(poi_Orchard)
                            .title("Central")
                            .snippet("Block 3A, Orchard Ave 3, 134542\nOperating hours: 11am-8pm\nTel:67788652")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            Toast.makeText(MainActivity.this, orchard.getTitle() + "\n" + orchard.getSnippet() , Toast.LENGTH_SHORT).show();
                            return false;
                        }
                });
            }
        });

        btnEest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng poi_Tampines = new LatLng(1.367149, 103.928021);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Tampines, 15));

                final Marker tampines = map.addMarker(new
                        MarkerOptions()
                        .position(poi_Tampines)
                        .title("East")
                        .snippet("Block 555, Tampines Ave 3, 287788\nOperating hours: 9am-5pm\nTel:66776677")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Toast.makeText(MainActivity.this, tampines.getTitle() + "\n" + tampines.getSnippet(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(sp.getSelectedItemPosition() == 1) {
                    LatLng poi_admiratly = new LatLng(1.441073, 103.772070);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_admiratly, 15));

                    final Marker admiratly = map.addMarker(new
                            MarkerOptions()
                            .position(poi_admiratly)
                            .title("HQ -North")
                            .snippet("Block 333, Admiralty Ave 3, 765654\nOperating hours: 10am-5pm\nTel:65433456")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                    map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            Toast.makeText(MainActivity.this, admiratly.getTitle() + "\n" + admiratly.getSnippet(), Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    });

                } else if(sp.getSelectedItemPosition() == 2) {
                    LatLng poi_Orchard = new LatLng(1.297802, 103.847441);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Orchard, 15));

                    final Marker orchard = map.addMarker(new
                            MarkerOptions()
                            .position(poi_Orchard)
                            .title("Central")
                            .snippet("Block 3A, Orchard Ave 3, 134542\nOperating hours: 11am-8pm\nTel:67788652")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                    map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            Toast.makeText(MainActivity.this, orchard.getTitle() + "\n" + orchard.getSnippet() , Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    });

                } else if(sp.getSelectedItemPosition() == 3) {
                    LatLng poi_Tampines = new LatLng(1.367149, 103.928021);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Tampines, 15));

                    final Marker tampines = map.addMarker(new
                            MarkerOptions()
                            .position(poi_Tampines)
                            .title("East")
                            .snippet("Block 555, Tampines Ave 3, 287788\nOperating hours: 9am-5pm\nTel:66776677")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            Toast.makeText(MainActivity.this, tampines.getTitle() + "\n" + tampines.getSnippet(), Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    });
                } else {
                    LatLng poi_CausewayPoint = new LatLng(1.436065, 103.786263);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint,
                            15));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
