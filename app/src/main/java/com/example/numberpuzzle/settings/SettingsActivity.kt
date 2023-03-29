package com.example.numberpuzzle.settings

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.numberpuzzle.R
import com.example.numberpuzzle.databinding.ActivitySettingsBinding
import com.example.numberpuzzle.game.*

class SettingsActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSettings = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(bindingSettings.root)
        APP_SETTINGS = this

        initBoard()
        initBitmap()
        initSettings()

        bindingSettings.customElement.setOnClickListener {
            chooseTypeElements(bindingSettings.customElement, bindingSettings.usersImageElement)
            chooseImagePuzzle = 0
        }

        bindingSettings.usersImageElement.setOnClickListener {
            chooseTypeElements(bindingSettings.usersImageElement, bindingSettings.customElement)
            chooseImagePuzzle = 1
        }

        bindingSettings.chooseImage.setOnClickListener {
            selectImage()
        }

        if (loadImage > 0)
            bindingSettings.chooseImage.setImageBitmap(imageBM)

        var pos = if (positionSize != 10) positionSize - 3 else 1
        bindingSettings.chooseSize.adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.size_array))
        bindingSettings.chooseSize.setSelection(pos)

        bindingSettings.chooseSize.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
//                    Toast.makeText(APP_SETTINGS, "you choose " + resources.getStringArray(R.array.size_array)[position], Toast.LENGTH_SHORT).show()
                    positionSize = position + 3
                    initBoard()
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
    }

    private val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        loadImage++
        imageUri = it.data?.data!!
        imageBM = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
        imageSet()
        bindingSettings.chooseImage.setImageBitmap(imageBM)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        getAction.launch(intent)
    }
}













//package com.example.numberpuzzle.settings
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.graphics.Bitmap
//import android.os.Build
//import android.os.Bundle
//import android.provider.MediaStore
//import android.view.View
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.annotation.RequiresApi
//import androidx.appcompat.app.AppCompatActivity
//import com.example.numberpuzzle.R
//import com.example.numberpuzzle.databinding.ActivitySettingsBinding
//import com.example.numberpuzzle.game.*
//
//class SettingsActivity : AppCompatActivity() {
//
//    @RequiresApi(Build.VERSION_CODES.Q)
//    @SuppressLint("ResourceType")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        bindingSettings = ActivitySettingsBinding.inflate(layoutInflater)
//        setContentView(bindingSettings.root)
//        APP_SETTINGS = this
//
//        bindingSettings.customElement.setOnClickListener {
//            chooseTypeElements(bindingSettings.customElement, bindingSettings.usersImageElement)
//            chooseImagePuzzle = 0
//        }
//
//        bindingSettings.usersImageElement.setOnClickListener {
//            chooseTypeElements(bindingSettings.usersImageElement, bindingSettings.customElement)
//            chooseImagePuzzle = 1
//        }
//
////        initBitmapBoard()
//        for (i in 1 until emptySquare){
//            board.add(i)
//            correctBoard.add(i)
//            boardBitmap.add(bitmap)
//        }
//        correctBoard.add(emptySquare)
//        board.shuffle()
//
//        bindingSettings.chooseImage.setOnClickListener {
//            selectImage()
//            initBoard()
//        }
//
//        var pos = if (positionSize != 10) positionSize - 3 else 1
//        bindingSettings.chooseSize.adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.size_array))
//        bindingSettings.chooseSize.setSelection(pos)
//
//        bindingSettings.chooseSize.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
//                Toast.makeText(this@SettingsActivity, "you choose " + resources.getStringArray(R.array.size_array)[position], Toast.LENGTH_SHORT).show()
//                positionSize = position + 3
//                initBoard()
//                initBitmapBoard()
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {}
//        }
//    }
//
//    @RequiresApi(Build.VERSION_CODES.Q)
//    private val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//
//        initBoard()
//        loadImage++
//
//        imageUri = it.data?.data!!
//        imageBM = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
//        resizedBmp = Bitmap.createScaledBitmap(imageBM, boardSize * squareSize, boardSize * squareSize, false)
//
//        val pixels = IntArray(boardSize * squareSize / 2 * boardSize * squareSize / 2)
//        resizedBmp.getPixels(pixels, 0, squareSize, 0, 0, squareSize, squareSize)
//
//        bitmapCopy = Bitmap.createBitmap(boardSize * squareSize / 2, boardSize * squareSize / 2, Bitmap.Config.ARGB_8888)
//
//        for (i in 0 until boardSize){
//            for (j in 0 until boardSize) {
//
//                bitmapCopy = Bitmap.createBitmap(boardSize * squareSize / 2, boardSize * squareSize / 2, Bitmap.Config.ARGB_8888)
//
//                resizedBmp.getPixels(pixels, 0, squareSize, j * squareSize, i * squareSize, squareSize, squareSize)
//
//                bitmapCopy.setPixels(pixels, 0, squareSize, 0, 0, squareSize, squareSize)
//
//                if (i != boardSize - 1 || j != boardSize - 1)
//                    boardBitmap[i * boardSize + j] = bitmapCopy
//            }
//        }
//
//        checkSuccessfulGamBitmap()
//        drawBoardBitmap()
//
////        binding.imageView.alpha = 0.55f  // на фон картинку ставим и альфа задаем и вот вам фон
////        binding.imageView2.setImageBitmap(resizedBmp)
////        bitmap = resizedBmp.copy(resizedBmp.config, true)
//
//        bindingSettings.chooseImage.setImageBitmap(resizedBmp)
//    }
//
//
//    @RequiresApi(Build.VERSION_CODES.Q)
//    private fun selectImage() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//
//        getAction.launch(intent)
//    }
//}





//package com.example.numberpuzzle.settings
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.graphics.Bitmap
//import android.os.Build
//import android.os.Bundle
//import android.provider.MediaStore
//import android.view.View
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.annotation.RequiresApi
//import androidx.appcompat.app.AppCompatActivity
//import com.example.numberpuzzle.R
//import com.example.numberpuzzle.databinding.ActivitySettingsBinding
//
//class SettingsActivity : AppCompatActivity() {
//
//    @SuppressLint("ResourceType")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        bindingSettings = ActivitySettingsBinding.inflate(layoutInflater)
//        setContentView(bindingSettings.root)
//        APP_SETTINGS = this
//
//        bindingSettings.customElement.setOnClickListener {
//            chooseTypeElements(bindingSettings.customElement, bindingSettings.usersImageElement)
//        }
//
//        bindingSettings.usersImageElement.setOnClickListener {
//            chooseTypeElements(bindingSettings.usersImageElement, bindingSettings.customElement)
//        }
//
//        var pos = if (positionSize != 10) positionSize - 3 else 1
//        bindingSettings.chooseSize.adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.size_array))
//        bindingSettings.chooseSize.setSelection(pos)
//
//        bindingSettings.chooseSize.onItemSelectedListener =
//            object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
//                    Toast.makeText(APP_SETTINGS, "you choose " + resources.getStringArray(R.array.size_array)[position], Toast.LENGTH_SHORT).show()
//                    positionSize = position + 3
//                }
//
//                override fun onNothingSelected(p0: AdapterView<*>?) {}
//            }
//    }
//}