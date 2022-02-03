package com.jhtuhin.mycontact;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhtuhin.mycontact.DetailsFragmentArgs;
import com.jhtuhin.mycontact.databinding.FragmentDetailsBinding;
import com.jhtuhin.mycontact.models.TheContact;

public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        final TheContact contacts=DetailsFragmentArgs.fromBundle(getArguments()).getContact();
        binding.photoIV.setImageResource(contacts.getImage());
        binding.personNameTV.setText(contacts.getName());
        binding.phoneTV.setText(contacts.getMobile());
        binding.emailTV.setText(contacts.getEmail());
        binding.addressTV.setText(contacts.getStreetAddress());
        return binding.getRoot();
    }
}