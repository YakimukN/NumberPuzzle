package com.example.numberpuzzle

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.numberpuzzle.databinding.ActivityHelpBinding
import kotlin.math.abs
import kotlin.math.max

class HelpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelpBinding

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
































//package com.example.numberpuzzle
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.graphics.Bitmap
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.net.Uri
//import android.os.Build
//import android.os.Bundle
//import android.provider.MediaStore
//import android.util.Log
//import android.view.MotionEvent
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.annotation.RequiresApi
//import androidx.appcompat.app.AppCompatActivity
//import com.example.numberpuzzle.databinding.ActivityHelpBinding
//import kotlin.math.abs
//import kotlin.math.max
//
//class HelpActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityHelpBinding
//    private val boardSize = 3
//    private val squareSize = (900 / boardSize).toInt()
//    private val emptySquare = boardSize * boardSize
//
//    private var bitmap = Bitmap.createBitmap(boardSize * squareSize, boardSize * squareSize, Bitmap.Config.ARGB_8888)
//    private var canvas = Canvas(bitmap)
//    private var board: ArrayList<Int> = ArrayList()
//    private val correctBoard: ArrayList<Int> = ArrayList()
//    private var clickCount = 0
//
//    private lateinit var imageUri : Uri
//    private lateinit var imageBM: Bitmap
//
//    private var boardBitmap: ArrayList<Bitmap> = ArrayList(emptySquare)
//    private var loadImage = 0
//
//    private lateinit var bitmapCopy: Bitmap
//
//    private val paint = Paint().apply {
//        isAntiAlias = true
//        color = Color.parseColor("#333399")
//        style = Paint.Style.STROKE
//        strokeWidth = 12f
//        this.strokeWidth = strokeWidth
//        strokeCap = Paint.Cap.SQUARE
//    }
//
//    private val paint2 = Paint().apply {
//        isAntiAlias = true
//        color = Color.parseColor("#333399")
//        style = Paint.Style.FILL
//        this.strokeWidth = strokeWidth
//    }
//
//    @RequiresApi(Build.VERSION_CODES.Q)
//    @SuppressLint("ClickableViewAccessibility")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityHelpBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//
//        for (i in 1 until emptySquare){
//            board.add(i)
//            correctBoard.add(i)
//
//            boardBitmap.add(bitmap)
//        }
//        correctBoard.add(emptySquare)
//        board.shuffle()
////        checkSuccessfulGame()
////        board.add(emptySquare)
////        boardBitmap.add(bitmap)
////        drawBoard()
//        if (loadImage != 0)
//            drawBoardBitmap()
//
//        binding.imageView.setOnTouchListener { _, motionEvent ->
//            click(motionEvent)
//            true
//        }
//
//        binding.imageView.setImageBitmap(bitmap)
//
//        binding.chooseImage.setOnClickListener {
////            boardBitmap.clear()
////            board.clear()
////            correctBoard.clear()
//
//            selectImage()
//        }
//    }
//    @RequiresApi(Build.VERSION_CODES.Q)
//    private val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//
//        loadImage++
//
//        imageUri = it.data?.data!!
//        imageBM = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
//        val resizedBmp: Bitmap = Bitmap.createScaledBitmap(imageBM, boardSize * squareSize, boardSize * squareSize, false)
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
//        checkSuccessfulGame()
//        drawBoardBitmap()
//
////        binding.imageView.alpha = 0.55f  // на фон картинку ставим и альфа задаем и вот вам фон
////        binding.imageView2.setImageBitmap(resizedBmp)
////        bitmap = resizedBmp.copy(resizedBmp.config, true)
//
//        binding.chooseImage.setImageBitmap(bitmapCopy)
//    }
//    @RequiresApi(Build.VERSION_CODES.Q)
//    private fun selectImage() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//
//        getAction.launch(intent)
//    }
//
//    private fun drawBoardBitmap() {
//        canvas.drawColor(Color.WHITE)
//        paint2.textSize = 50f
//
//        for (i in 0 until boardSize){
//            for (j in 0 until boardSize){
//                var index = (boardBitmap[boardSize * i + j])
//                if (index != bitmapCopy){
//                    canvas.drawBitmap(
//                        boardBitmap[i * boardSize + j],
//                        (j * squareSize).toFloat(),
//                        (i * squareSize).toFloat(),
//                        paint)
//                }
//            }
//        }
//    }
//
//    private fun checkSuccessfulGame() {
//        Log.i("tag", "board = $board")
//        var sum = 0
//        for (i in 0 until emptySquare - 1){
//            for (j in 0 until emptySquare - 1){
//                if (board[i] < board[j] && i > j)
//                    sum++
//            }
//        }
//        Log.i("tag", "sum = $sum")
//
//        if (sum % 2 != 0){
//            board.shuffle()
//            checkSuccessfulGame()
//        } else {
//            board.add(emptySquare)
//            bitmapShuffle()
//        }
//    }
//
//    private fun bitmapShuffle(){
//
//        var arrayCopy : ArrayList<Bitmap> = ArrayList(emptySquare)
//
//        for (i in 0 until boardBitmap.size)
//            arrayCopy.add(boardBitmap[i])
//
//
//        for (i in 0 until emptySquare - 1){
//            var index = board[i]
//            boardBitmap[i] = arrayCopy[index - 1]
//        }
//
//
//        boardBitmap.add(bitmapCopy)
//        drawBoardBitmap()
//    }
//
//    private fun click(motionEvent: MotionEvent) {
//        if (motionEvent.action == 0){
//            clickCount++
//
//            val x = (motionEvent.x.toInt() / squareSize).toInt()
//            val y = (motionEvent.y.toInt() / squareSize).toInt()
//
//            val boardIndex = x + (y * boardSize)
//            val emptyIndex = getEmptyNeighborBitmap(boardIndex)
//            val temp = boardBitmap[boardIndex]
//            boardBitmap[boardIndex] = boardBitmap[emptyIndex]
//            boardBitmap[emptyIndex] = temp
//
//
//            val boardIndex2 = x + (y * boardSize)
//            val emptyIndex2 = getEmptyNeighbor(boardIndex2)
//            val temp2 = board[boardIndex2]
//            board[boardIndex2] = board[emptyIndex2]
//            board[emptyIndex2] = temp2
//
//
//            drawBoardBitmap()
//            Log.i("tag", "board = $board")
//            Log.i("tag", "curre = $correctBoard")
//
//            if (board == correctBoard)
//                showVictoryPlate()
//        }
//        binding.countTV.text = clickCount.toString()
//        binding.imageView.setImageBitmap(bitmap)
//    }
//
//    private fun showVictoryPlate() {
//        Toast.makeText(this, "you win!", Toast.LENGTH_SHORT).show()
//    }
//
//    private fun getEmptyNeighborBitmap(index: Int): Int {
//
//        var retValue = index
//        var emptyIndex = boardBitmap.indexOf(bitmapCopy)
//        var absValue = abs(emptyIndex - index)
//
//        if (absValue == boardSize) {
//            retValue = emptyIndex
//
//        } else if (absValue == 1){
//            var maxIndex = max(index, emptyIndex)
//            if (maxIndex % boardSize != 0)
//                retValue = emptyIndex
//            else
//                retValue = index
//        }
//        return retValue
//
//    }
//
//
//
//    fun getEmptyNeighbor(index: Int): Int {
//        var retValue = index
//        val emptyIndex = board.indexOf(emptySquare)
//        val absValue = abs(emptyIndex - index)
//
//        if (absValue == boardSize) {
//            retValue = emptyIndex
//
//        } else if (absValue == 1){
//            var maxIndex = max(index, emptyIndex)
//            if (maxIndex % boardSize != 0)
//                retValue = emptyIndex
//            else
//                retValue = index
//        }
//        return retValue
//    }
//
//
//}
//
//
//


//
//package com.example.numberpuzzle
//
////import android.annotation.SuppressLint
////import androidx.appcompat.app.AppCompatActivity
////import android.os.Bundle
////import com.example.numberpuzzle.databinding.ActivityGameBinding
////
////class GameActivity : AppCompatActivity() {
////
////    @SuppressLint("ClickableViewAccessibility")
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        bindingGame = ActivityGameBinding.inflate(layoutInflater)
////        setContentView(bindingGame.root)
////
////        APP_CAME = this
//////        initSettings()
////        init()
////
////        bindingGame.imageView.setOnTouchListener { _, motionEvent ->
////            click(motionEvent)
////            true
////        }
////        bindingGame.reNewBtn.setOnClickListener {
////            reNewGame()
////        }
////        bindingGame.imageView.setImageBitmap(bitmap)
////    }
////}
////
////
////
////
////
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.graphics.Bitmap
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.net.Uri
//import android.os.Build
//import android.os.Bundle
//import android.provider.MediaStore
//import android.util.Log
//import android.view.MotionEvent
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.annotation.RequiresApi
//import androidx.appcompat.app.AppCompatActivity
//import com.example.numberpuzzle.databinding.ActivityHelpBinding
//import kotlin.math.abs
//import kotlin.math.max
//
//class HelpActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityHelpBinding
//    private val boardSize = 3
//    private val squareSize = (900 / boardSize).toInt()
//    private val emptySquare = boardSize * boardSize
//
//    private var bitmap = Bitmap.createBitmap(boardSize * squareSize, boardSize * squareSize, Bitmap.Config.ARGB_8888)
//    private var canvas = Canvas(bitmap)
//    private var board: ArrayList<Int> = ArrayList()
//    private val correctBoard: ArrayList<Int> = ArrayList()
//    private var clickCount = 0
//
//    private lateinit var imageUri : Uri
//    private lateinit var imageBM: Bitmap
//
//    private var boardBitmap: ArrayList<Bitmap> = ArrayList(emptySquare)
//    private var loadImage = 0
//
//    private lateinit var bitmapCopy: Bitmap
//
//    private val paint = Paint().apply {
//        isAntiAlias = true
//        color = Color.parseColor("#333399")
//        style = Paint.Style.STROKE
//        strokeWidth = 12f
//        this.strokeWidth = strokeWidth
//        strokeCap = Paint.Cap.SQUARE
//    }
//
//    private val paint2 = Paint().apply {
//        isAntiAlias = true
//        color = Color.parseColor("#333399")
//        style = Paint.Style.FILL
//        this.strokeWidth = strokeWidth
//    }
//
//    @RequiresApi(Build.VERSION_CODES.Q)
//    @SuppressLint("ClickableViewAccessibility")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityHelpBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        for (i in 1 until emptySquare){
//            board.add(i)
//            correctBoard.add(i)
//
//            boardBitmap.add(bitmap)
//        }
//        correctBoard.add(emptySquare)
//        board.shuffle()
////        checkSuccessfulGame()
////        board.add(emptySquare)
////        boardBitmap.add(bitmap)
////        drawBoard()
//        if (loadImage != 0)
//            drawBoardBitmap()
//
//        binding.imageView.setOnTouchListener { _, motionEvent ->
//            click(motionEvent)
//            true
//        }
//
////        binding.reNewBtn.setOnClickListener {
////            clickCount = 0
////            board.remove(emptySquare)
////            board.shuffle()
////            checkSuccessfulGame()
////            board.add(emptySquare)
////            drawBoard()
////
////            binding.countTV.text = clickCount.toString()
////            binding.imageView.setImageBitmap(bitmap)
////        }
//
//        binding.imageView.setImageBitmap(bitmap)
//
//        binding.chooseImage.setOnClickListener {
//            selectImage()
//        }
//    }
//    @RequiresApi(Build.VERSION_CODES.Q)
//    private val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//
//        loadImage++
//
//        imageUri = it.data?.data!!
//        imageBM = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
//        val resizedBmp: Bitmap = Bitmap.createScaledBitmap(imageBM, boardSize * squareSize, boardSize * squareSize, false)
//
//
//
//        val pixels = IntArray(boardSize * squareSize / 2 * boardSize * squareSize / 2)
//        resizedBmp.getPixels(pixels,
//            0,
//            squareSize,
//            0,
//            0,
//            squareSize,
//            squareSize)
//
//
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
//
//        checkSuccessfulGame()
//        drawBoardBitmap()
//
//
//
////        binding.imageView.alpha = 0.55f  // на фон картинку ставим и альфа задаем и вот вам фон
////        binding.imageView2.setImageBitmap(resizedBmp)
////        bitmap = resizedBmp.copy(resizedBmp.config, true)
//
//        binding.chooseImage.setImageBitmap(bitmapCopy)
//    }
//    @RequiresApi(Build.VERSION_CODES.Q)
//    private fun selectImage() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//
//        getAction.launch(intent)
//    }
//
//    private fun drawBoardBitmap() {
//        canvas.drawColor(Color.WHITE)
//        paint2.textSize = 50f
//
//        for (i in 0 until boardSize){
//            for (j in 0 until boardSize){
//                var index = (boardBitmap[boardSize * i + j])
//                if (index != bitmapCopy){
//                    canvas.drawBitmap(
//                        boardBitmap[i * boardSize + j],
//                        (j * squareSize).toFloat(),
//                        (i * squareSize).toFloat(),
//                        paint)
//                }
//            }
//        }
//    }
//
//    private fun checkSuccessfulGame() {
//        Log.i("tag", "board = $board")
//        var sum = 0
//        for (i in 0 until emptySquare - 1){
//            for (j in 0 until emptySquare - 1){
//                if (board[i] < board[j] && i > j)
//                    sum++
//            }
//        }
//        Log.i("tag", "sum = $sum")
//
//        if (sum % 2 != 0){
//            board.shuffle()
//            checkSuccessfulGame()
//        } else {
//            board.add(emptySquare)
//            bitmapShuffle()
//        }
//    }
//
//    private fun bitmapShuffle(){
//
//
//        var arrayCopy : ArrayList<Bitmap> = ArrayList(emptySquare)
//
//        for (i in 0 until boardBitmap.size)
//            arrayCopy.add(boardBitmap[i])
//
//
//        for (i in 0 until emptySquare - 1){
//            var index = board[i]
//            boardBitmap[i] = arrayCopy[index - 1]
//        }
//
//
//        boardBitmap.add(bitmapCopy)
//        drawBoardBitmap()
//    }
//
//    private fun click(motionEvent: MotionEvent) {
//        if (motionEvent.action == 0){
//            clickCount++
//
//            val x = (motionEvent.x.toInt() / squareSize).toInt()
//            val y = (motionEvent.y.toInt() / squareSize).toInt()
//
//            val boardIndex = x + (y * boardSize)
//            val emptyIndex = getEmptyNeighborBitmap(boardIndex)
//            val temp = boardBitmap[boardIndex]
//            boardBitmap[boardIndex] = boardBitmap[emptyIndex]
//            boardBitmap[emptyIndex] = temp
//
//
//            val boardIndex2 = x + (y * boardSize)
//            val emptyIndex2 = getEmptyNeighbor(boardIndex2)
//            val temp2 = board[boardIndex2]
//            board[boardIndex2] = board[emptyIndex2]
//            board[emptyIndex2] = temp2
//
//
//            drawBoardBitmap()
//            Log.i("tag", "board = $board")
//            Log.i("tag", "curre = $correctBoard")
//
//            if (board == correctBoard)
//                showVictoryPlate()
//        }
//        binding.countTV.text = clickCount.toString()
//        binding.imageView.setImageBitmap(bitmap)
//    }
//
//    private fun showVictoryPlate() {
//        Toast.makeText(this, "you win!", Toast.LENGTH_SHORT).show()
//    }
//
//    private fun getEmptyNeighborBitmap(index: Int): Int {
//
//        var retValue = index
//        var emptyIndex = boardBitmap.indexOf(bitmapCopy)
//        var absValue = abs(emptyIndex - index)
//
//        if (absValue == boardSize) {
//            retValue = emptyIndex
//
//        } else if (absValue == 1){
//            var maxIndex = max(index, emptyIndex)
//            if (maxIndex % boardSize != 0)
//                retValue = emptyIndex
//            else
//                retValue = index
//        }
//        return retValue
//
//    }
//
//
//    fun getEmptyNeighbor(index: Int): Int {
//        var retValue = index
//        var emptyIndex = board.indexOf(emptySquare)
//        var absValue = abs(emptyIndex - index)
//
//        if (absValue == boardSize) {
//            retValue = emptyIndex
//
//        } else if (absValue == 1){
//            var maxIndex = max(index, emptyIndex)
//            if (maxIndex % boardSize != 0)
//                retValue = emptyIndex
//            else
//                retValue = index
//        }
//        return retValue
//    }
//
//
//}