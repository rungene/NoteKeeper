package com.rungene.android.notekeeper

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.rungene.android.notekeeper.databinding.DrawerLayoutBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var appBarConfiguration: AppBarConfiguration
   // private lateinit var binding: ActivityMainBinding
    private lateinit var bind: DrawerLayoutBinding
   private lateinit var drawerLayout : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = DrawerLayoutBinding.inflate(layoutInflater)
        setContentView(bind.root)

        setSupportActionBar(findViewById(R.id.toolbar))
       drawerLayout  = findViewById(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)


        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph,
            drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)



        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            navController.navigate(R.id.action_FirstFragment_to_SecondFragment,null)
        }
        navView.setNavigationItemSelectedListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (findViewById<DrawerLayout>(R.id.drawer_layout).isDrawerOpen(GravityCompat.START)) {
            findViewById<DrawerLayout>(R.id.drawer_layout).closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_notes -> {
            handleSelection("Notes")
            }
            R.id.nav_courses -> {
                handleSelection("Courses")
            }
            R.id.nav_share -> {
                handleSelection("Don't you think you've shared enough")
            }
            R.id.nav_send -> {
                handleSelection("Send")
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun handleSelection(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}