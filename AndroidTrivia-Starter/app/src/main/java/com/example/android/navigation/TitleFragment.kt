package com.example.android.navigation


import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding=
                DataBindingUtil.inflate<FragmentTitleBinding>( //Defines the binding variable
                                                               // to the fragment layout binding
                inflater, // inflates the layout
                R.layout.fragment_title, //provides the layout for the fragment
                container, // (optional parameter) clarifies the parent ViewGroup
                false)

        return binding.root  //outputs the inflated view
    }


}
