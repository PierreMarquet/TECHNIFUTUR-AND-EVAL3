package com.technipixl.exo1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.technipixl.exo1.databinding.CharactersItemViewBinding
import com.technipixl.exo1.marvel.Character

class CharactersAdapter(val characters: List<Character>): RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    class CharactersViewHolder(var binding: CharactersItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character){

            binding.textView.text = character.name

            Picasso.get()
                .load(character.thumbnail?.path + "." + character.thumbnail?.extension)
                .fit()
                .centerCrop()
                .into(binding.imageView2)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        var binding: CharactersItemViewBinding = CharactersItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }

}