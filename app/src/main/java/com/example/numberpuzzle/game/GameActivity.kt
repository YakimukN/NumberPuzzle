//package com.example.numberpuzzle.game
//
//import android.annotation.SuppressLint
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.numberpuzzle.databinding.ActivityGameBinding
//import com.example.numberpuzzle.settings.chooseImagePuzzle
//
//class GameActivity : AppCompatActivity() {
//
//    @SuppressLint("ClickableViewAccessibility")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        bindingGame = ActivityGameBinding.inflate(layoutInflater)
//        setContentView(bindingGame.root)
//
//        APP_CAME = this
//        initBoard()
//
//        if (chooseImagePuzzle == 0){
////            initBoard()
//            init()
//
//            bindingGame.imageView.setOnTouchListener { _, motionEvent ->
//                click(motionEvent)
//                true
//            }
//            bindingGame.reNewBtn.setOnClickListener {
//                reNewGame()
//            }
//            bindingGame.imageView.setImageBitmap(bitmap)
//        } else {
//
//            bindingGame.imageView.setOnTouchListener { _, motionEvent ->
//                clickBitmap(motionEvent)
//                true
//            }
//            bindingGame.imageView.setImageBitmap(bitmap)
//        }
//
//    }
//}


package com.example.numberpuzzle.game

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberpuzzle.databinding.ActivityGameBinding
import com.example.numberpuzzle.settings.clickBitmap
import com.example.numberpuzzle.settings.imageSet

class GameActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingGame = ActivityGameBinding.inflate(layoutInflater)
        setContentView(bindingGame.root)

        APP_CAME = this

        if (chooseImagePuzzle == 0){
            initBoard()
            init()

            bindingGame.imageView.setOnTouchListener { _, motionEvent ->
                click(motionEvent)
                true
            }
            bindingGame.reNewBtn.setOnClickListener {
                reNewGame()
            }
            bindingGame.imageView.setImageBitmap(bitmap)
        } else {
            imageSet()
            bindingGame.imageView.setOnTouchListener { _, motionEvent ->
                clickBitmap(motionEvent)
                true
            }
            bindingGame.reNewBtn.setOnClickListener {
                reNewGameBitmap()
            }
            bindingGame.imageView.setImageBitmap(bitmap)
        }

    }
}