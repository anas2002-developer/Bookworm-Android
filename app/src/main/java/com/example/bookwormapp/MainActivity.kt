package com.example.bookwormapp

import android.app.Service
import android.app.usage.NetworkStats
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var DL: DrawerLayout
    lateinit var vNV: NavigationView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DL = findViewById(R.id.DL)
        vNV = findViewById(R.id.vNV)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "BookWorm"      //getSupportActionBar
//        supportActionBar?.setHomeButtonEnabled(true)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //adding functionality to home button
        val toggle = ActionBarDrawerToggle(
            this@MainActivity,
            DL,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        DL.addDrawerListener(toggle)

        //hamburger icon
        toggle.syncState()

        if (savedInstanceState == null) {
            loadFrag(DashboardFragment())       //initial fragment
            vNV.setCheckedItem(R.id.itemDashboard)     //initial checkeditem
        }

        findViewById<Button>(R.id.btnCheckConnectivity).setOnClickListener {
           isConnected()
        }

        vNV.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.itemDashboard -> {
                    loadFrag(DashboardFragment())
                    supportActionBar?.title = "Dashboard"
                }

                R.id.itemFavourites -> {
                    loadFrag(FavouritesFragment())
                    supportActionBar?.title = "Favourites"
                }

                R.id.itemProfile -> {
                    loadFrag(ProfileFragment())
                    supportActionBar?.title = "Profile"
                }

                R.id.itemAbout -> {
                    loadFrag(AboutFragment())
                    supportActionBar?.title = "About"
                }
                R.id.itemShare -> {
                    Toast.makeText(this@MainActivity, "Share", Toast.LENGTH_SHORT).show()
                }
                R.id.itemSettings -> {
                    Toast.makeText(this@MainActivity, "Settings", Toast.LENGTH_SHORT).show()
                }
            }


            //closing drawer
            DL.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

    }

    //for checking connectivity to internet
    private fun isConnected() {
        val connectivityManager: ConnectivityManager =
            this.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

            if (networkInfo?.isConnected!=null){
                Toast.makeText(this@MainActivity, "Connected", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@MainActivity, "Not Connected", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun loadFrag(frag: Fragment) {

        //getSupportFragmentManager() java
        supportFragmentManager.beginTransaction()
            .replace(R.id.FL, frag)
            .commit()            //add(for first time) or replace methods
    }

    override fun onBackPressed() {

        val currFrag = supportFragmentManager.findFragmentById(R.id.FL)
        if (currFrag != DashboardFragment()) {
            loadFrag(DashboardFragment())
            supportActionBar?.title = "Dashboard"
        }
        //closing drawer on back press
        else if (DL.isDrawerOpen(GravityCompat.START)) {
            DL.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}