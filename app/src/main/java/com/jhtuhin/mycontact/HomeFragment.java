package com.jhtuhin.mycontact;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhtuhin.mycontact.adapters.ContactAdapter;
import com.example.mycontact.databinding.FragmentHomeBinding;
import com.jhtuhin.mycontact.models.TheContact;


public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        com.example.mycontact.databinding
                .FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);
        final ContactAdapter contactAdapter=new ContactAdapter(TheContact.getAllContact());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.contactRV.setLayoutManager(linearLayoutManager);
        binding.contactRV.setAdapter(contactAdapter);
        return binding.getRoot();
    }
}