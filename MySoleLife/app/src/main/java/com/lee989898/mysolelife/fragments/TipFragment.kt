package com.lee989898.mysolelife.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.lee989898.mysolelife.R
import com.lee989898.mysolelife.contentsList.ContentListActivity
import com.lee989898.mysolelife.databinding.FragmentTipBinding

class TipFragment : Fragment() {

    lateinit var binding: FragmentTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTipBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.category1.setOnClickListener {


            val intent = Intent(context, ContentListActivity::class.java)
            startActivity(intent)

        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipFragment_to_homeFragment)

        }

        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipFragment_to_talkFragment)

        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipFragment_to_bookmarkFragment)

        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipFragment_to_storeFragment)

        }

        return binding.root
    }


}