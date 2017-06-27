package com.example.lg.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap googleMap;
    SupportMapFragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.83926, 128.63189),17));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public static final int ITEM_SATTELLITE=1;
    public static final int ITEM_NORMAL=2;
    public static final int ITEM_COEXMALL=3;
    public static final int ITEM_IPARKMALL=4;

        @Override
        public boolean onCreateOptionsMenu(Menu menu){
            super.onCreateOptionsMenu(menu);
            menu.add(0, ITEM_SATTELLITE,0,"위성지도");
            menu.add(0,ITEM_NORMAL,0,"일반 지도");
            SubMenu hotMenu=menu.addSubMenu("핫 플레이스");
            hotMenu.add(0, ITEM_COEXMALL,0,"코엑스몰");
            hotMenu.add(0, ITEM_IPARKMALL,0,"아이파크몰");
            return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case ITEM_SATTELLITE: googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case ITEM_NORMAL : googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case ITEM_IPARKMALL : googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.839269, 128.631892),17));
        }
        return false;
    }
}
