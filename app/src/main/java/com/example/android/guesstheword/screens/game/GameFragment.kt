/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {


    private lateinit var viewModel: GameViewModel

    // The list of words - the front of the list is the next word to guess

    private lateinit var binding: GameFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.i("GameFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )



        viewModel.word.observe(viewLifecycleOwner) {
            value->
            value?.let {
                binding.wordText.text = value
            }
            binding.scoreText.text = viewModel.score.value.toString()
        }

        viewModel.nextWord()

        binding.correctButton.setOnClickListener { viewModel.nextWord() }
        binding.skipButton.setOnClickListener { viewModel.onSkip() }
        binding.endGameButton.setOnClickListener {
            endGame()
        }
        return binding.root

    }

    private fun endGame() {
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score.value!!
        findNavController().navigate(action)
    }


}
