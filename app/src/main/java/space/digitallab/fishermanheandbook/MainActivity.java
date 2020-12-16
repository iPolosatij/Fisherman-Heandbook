package space.digitallab.fishermanheandbook;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ListView listView;
    private String[] array;
    private ArrayAdapter<String> arrayAdapter;
    private LinearLayout logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        array = getResources().getStringArray(R.array.first);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(Arrays.asList(array)));
        listView.setAdapter(arrayAdapter);
        logo = findViewById(R.id.conteiner);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        //add menu action button
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        logo.setBackground(getResources().getDrawable(R.color.white));

        if(id == R.id.nav_fish){

            array = getResources().getStringArray(R.array.fishes);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
        }else if(id == R.id.nav_bait){

            array = getResources().getStringArray(R.array.bait);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
        }else if(id == R.id.nav_tackle){

            array = getResources().getStringArray(R.array.tackle);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
        }else if(id == R.id.nav_lure) {

            array = getResources().getStringArray(R.array.lure);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
        } else if(id == R.id.nav_story) {

            array = getResources().getStringArray(R.array.story);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
        }else if(id == R.id.nav_tip) {

            array = getResources().getStringArray(R.array.tip);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}