package com.example.gridllayoutwithtitlerecyclerview

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DimenRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val yourItemsList: List<Any> = listOf(
            "Custom",
            YourItemType("Email", R.drawable.email_home),
            YourItemType("Phone", R.drawable.call_home),
            YourItemType("Website", R.drawable.website_home),
            YourItemType("Email", R.drawable.email_home),
            YourItemType("Phone", R.drawable.call_home),
            YourItemType("Website", R.drawable.website_home),
            "Custom",
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            "Utilities",
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            "Social",
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            "Music",
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home),
            LargeItemType("Apple", R.drawable.apple_home),
            LargeItemType("Text", R.drawable.text_home),
            LargeItemType("Wifi", R.drawable.wifi_home)
            )


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val spanCount = 12 // Number of columns in the grid

        val gridLayoutManager = GridLayoutManager(this, spanCount)
        recyclerView.layoutManager = gridLayoutManager


        val adapter = YourAdapter(yourItemsList)

        // Adjust the span size of the items, large items, and titles
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    YourAdapter.VIEW_TYPE_ITEM -> spanCount / 3 // Item takes 4 spans out of 12 (3 columns)
                    YourAdapter.VIEW_TYPE_TITLE -> spanCount // Title takes the whole row (12 spans)
                    YourAdapter.VIEW_TYPE_LARGE_ITEM -> spanCount / 5 // Large item takes the whole row (12 spans)
                    else -> 1
                }
            }
        }

        recyclerView.adapter = adapter
    }
}
