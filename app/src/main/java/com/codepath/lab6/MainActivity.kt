package com.codepath.lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codepath.lab6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load ParksFragment by default
        replaceFragment(ParksFragment.newInstance())

        // Handle Bottom Navigation
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_parks -> replaceFragment(ParksFragment.newInstance())
                R.id.navigation_campgrounds -> replaceFragment(CampgroundFragment.newInstance())
                else -> replaceFragment(ParksFragment.newInstance())
            }
            true
        }
    }

    // Helper function for fragment transactions
    private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}