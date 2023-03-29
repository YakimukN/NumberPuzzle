package com.example.numberpuzzle.game

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import com.example.numberpuzzle.databinding.ActivityGameBinding
import com.example.numberpuzzle.databinding.ActivitySettingsBinding
import com.example.numberpuzzle.databinding.ActivityStatisticBinding

@SuppressLint("StaticFieldLeak")
lateinit var bindingGame: ActivityGameBinding
@SuppressLint("StaticFieldLeak")
lateinit var bindingStatistic: ActivityStatisticBinding

var bitmap: Bitmap = Bitmap.createBitmap(boardSize * squareSize, boardSize * squareSize, Bitmap.Config.ARGB_8888)
var canvas = Canvas(bitmap)
var board: ArrayList<Int> = ArrayList()
val correctBoard: ArrayList<Int> = ArrayList()
var clickCount = 0




lateinit var imageUri : Uri
lateinit var imageBM: Bitmap

var boardBitmap: ArrayList<Bitmap> = ArrayList(emptySquare)
var loadImage = 0

lateinit var bitmapCopy: Bitmap


//val resizedBmp: Bitmap = Bitmap.createScaledBitmap(imageBM, boardSize * squareSize, boardSize * squareSize, false)
lateinit var resizedBmp: Bitmap

var chooseImagePuzzle = 0

val paint = Paint().apply {
    isAntiAlias = true
    color = Color.parseColor("#333399")
    style = Paint.Style.STROKE
    this.strokeWidth = strokeWidth
    strokeCap = Paint.Cap.SQUARE
}
val paint2 = Paint().apply {
    isAntiAlias = true
    color = Color.parseColor("#333399")
    style = Paint.Style.FILL
    this.strokeWidth = strokeWidth
}


var resultGame = 10
var nameUserGame = "nnn"


//package com.example.numberpuzzle.game
//
//import android.annotation.SuppressLint
//import android.graphics.Bitmap
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.net.Uri
//import com.example.numberpuzzle.databinding.ActivityGameBinding
//
//@SuppressLint("StaticFieldLeak")
//lateinit var bindingGame: ActivityGameBinding
//
//var bitmap: Bitmap = Bitmap.createBitmap(boardSize * squareSize, boardSize * squareSize, Bitmap.Config.ARGB_8888)
//var canvas = Canvas(bitmap)
//var board: ArrayList<Int> = ArrayList()
//val correctBoard: ArrayList<Int> = ArrayList()
//var clickCount = 0
//
//var resizedBmp: Bitmap = Bitmap.createScaledBitmap(imageBM, boardSize * squareSize, boardSize * squareSize, false)
//
//lateinit var imageUri : Uri
//lateinit var imageBM: Bitmap
//
//var boardBitmap: ArrayList<Bitmap> = ArrayList(emptySquare)
//var loadImage = 0
//
//lateinit var bitmapCopy: Bitmap
//
//
//val paint = Paint().apply {
//    isAntiAlias = true
//    color = Color.parseColor("#333399")
//    style = Paint.Style.STROKE
//    this.strokeWidth = strokeWidth
//    strokeCap = Paint.Cap.SQUARE
//}
//val paint2 = Paint().apply {
//    isAntiAlias = true
//    color = Color.parseColor("#333399")
//    style = Paint.Style.FILL
//    this.strokeWidth = strokeWidth
//}




