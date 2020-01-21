package com.example.android.navigation


import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

        binding.playButton.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_titleFragment_to_gameFragment)
        }

        setHasOptionsMenu(true)

        return binding.root  //outputs the inflated view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController())
                || super.onOptionsItemSelected(item)

    }

}
