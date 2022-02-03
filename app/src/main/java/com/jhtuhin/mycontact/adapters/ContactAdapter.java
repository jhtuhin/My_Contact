package com.jhtuhin.mycontact.adapters;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.jhtuhin.mycontact.HomeFragmentDirections;
import com.jhtuhin.mycontact.databinding.ContactRowBinding;
import com.jhtuhin.mycontact.models.TheContact;

import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
   private final List<TheContact> theContactList;

    public ContactAdapter(List<TheContact> theContactList) {
        this.theContactList = theContactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final ContactRowBinding binding=ContactRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ContactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        TheContact theContact=theContactList.get(position);
        holder.bind(theContact);
    }

    @Override
    public int getItemCount() {
        return theContactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
            ContactRowBinding binding;

        public ContactViewHolder(@NonNull ContactRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            //final TheContact theContact= theContactList.get(getAdapterPosition());

            binding.callBtn.setOnClickListener(v -> {
                final int pos=getAdapterPosition();
                final Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+theContactList.get(pos).getMobile()));
                try{
                    v.getContext().startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(v.getContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            binding.smsBtn.setOnClickListener(v -> {
                final int pos=getAdapterPosition();
                final Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+theContactList.get(pos).getMobile()));
                try{
                    v.getContext().startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(v.getContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            binding.emailBtn.setOnClickListener(v -> {
                final int pos=getAdapterPosition();
                final Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{theContactList.get(pos).getEmail()});
                intent.putExtra(Intent.EXTRA_SUBJECT,"test");
                try{
                    v.getContext().startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(v.getContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            binding.detailIV.setOnClickListener(v -> {
                final int pos=getAdapterPosition();
                final HomeFragmentDirections.DetailAction action = HomeFragmentDirections.detailAction(theContactList.get(pos));
                action.setName(theContactList.get(pos).getName());
                Navigation.findNavController(v).navigate(action);
            });
        }

        public void bind(TheContact theContact) {
            binding.nameTV.setText(theContact.getName());
        }
    }
}
