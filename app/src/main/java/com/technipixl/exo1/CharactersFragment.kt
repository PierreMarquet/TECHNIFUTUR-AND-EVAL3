package com.technipixl.exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.technipixl.exo1.databinding.FragmentCharactersBinding
import com.technipixl.exo1.marvel.Character
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class CharactersFragment : Fragment() {

    private var binding: FragmentCharactersBinding? = null

    private val marvelService by lazy { AssetsServiceImpl() }

    val datas = mutableListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getCharacterAsync()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater, container, false)
        return binding?.root


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun getCharacterAsync(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = marvelService.getAssets()
            withContext(Dispatchers.Main){
                try {
                    if (response.isSuccessful){
                        response.body()?.data?.results?.forEach{
                            datas.add(it)
                        }
                        setupRecyclerView()
                    }

                }catch (httpException: HttpException){
                    print(httpException)
                }catch (e: Throwable){
                    print(e)
                }
            }
        }
    }

    private fun setupRecyclerView(){
        binding?.charactersRecyclerView?.layoutManager = LinearLayoutManager(context)
        val adapter = CharactersAdapter(datas)
        binding?.charactersRecyclerView?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }
}