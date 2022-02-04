package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    private var homeFragment= HomeFragment()
    private var profileFragment=ProfileFragment()
    private var favoriteFragment=FavoriteFragment()
    private var comingSoonFragment = ComingSoonFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener{
                when(it.itemId){
                R.id.profile ->replaceFragment(profileFragment)
                R.id.home -> replaceFragment(homeFragment)
                R.id.favorite -> replaceFragment(favoriteFragment)
                R.id.comingsoon -> replaceFragment(comingSoonFragment)
            }
            true
        }

    }
    fun replaceFragment(fragment: Fragment){
        if (fragment !=null){
            supportFragmentManager.commit {
                replace(R.id.container,fragment)
                setReorderingAllowed(true)
            }
        }
    }
}