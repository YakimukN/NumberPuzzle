//package com.example.numberpuzzle.settings
//
//import android.widget.RadioButton
//import com.example.numberpuzzle.game.*
//
//fun chooseTypeElements(first: RadioButton, second: RadioButton) {
//    first.isChecked = true
//    second.isChecked = false
//}
//
//fun initBitmapBoard(){
//    boardBitmap.clear()
//    board.clear()
//    correctBoard.clear()
//
//    for (i in 1 until emptySquare){
//        board.add(i)
//        correctBoard.add(i)
//        boardBitmap.add(bitmap)
//    }
//    correctBoard.add(emptySquare)
//    board.shuffle()
//}
//
package com.example.numberpuzzle.settings

import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
import android.view.MotionEvent
import android.widget.RadioButton
import com.example.numberpuzzle.game.*
import kotlin.math.abs
import kotlin.math.max

fun initBitmap(){
    initBoard()
    board.clear()
    correctBoard.clear()
    boardBitmap.clear()
    for (i in 1 until emptySquare){
        board.add(i)
        correctBoard.add(i)
        boardBitmap.add(bitmap)
    }
    correctBoard.add(emptySquare)
    board.shuffle()
}

fun initSettings(){
    if (chooseImagePuzzle == 0)
        chooseTypeElements(bindingSettings.customElement, bindingSettings.usersImageElement)
    else chooseTypeElements(bindingSettings.usersImageElement, bindingSettings.customElement)

    if (loadImage > 0)
        bindingSettings.chooseImage.setImageBitmap(imageBM)
}

fun chooseTypeElements(first: RadioButton, second: RadioButton) {
    first.isChecked = true
    second.isChecked = false
}

fun checkSuccessfulGameBitmap() {
    Log.i("tag", "board = $board")
    var sum = 0
    for (i in 0 until emptySquare - 1){
        for (j in 0 until emptySquare - 1){
            if (board[i] < board[j] && i > j)
                sum++
        }
    }
    Log.i("tag", "sum = $sum")

    if (sum % 2 != 0){
        board.shuffle()
        checkSuccessfulGameBitmap()
    } else {
        board.add(emptySquare)
        bitmapShuffle()
    }
}

fun bitmapShuffle(){

    var arrayCopy : ArrayList<Bitmap> = ArrayList(emptySquare)

    for (i in 0 until boardBitmap.size)
        arrayCopy.add(boardBitmap[i])


    for (i in 0 until emptySquare - 1){
        var index = board[i]
        boardBitmap[i] = arrayCopy[index - 1]
    }


    boardBitmap.add(bitmapCopy)
    drawBoardBitmap()
}

fun drawBoardBitmap() {
    canvas.drawColor(Color.WHITE)
    paint2.textSize = 50f

    for (i in 0 until boardSize){
        for (j in 0 until boardSize){
            var index = (boardBitmap[boardSize * i + j])
            if (index != bitmapCopy){
                canvas.drawBitmap(
                    boardBitmap[i * boardSize + j],
                    (j * squareSize).toFloat(),
                    (i * squareSize).toFloat(),
                    paint)
            }
        }
    }
}


fun getEmptyNeighborBitmap(index: Int): Int {

    var retValue = index
    var emptyIndex = boardBitmap.indexOf(bitmapCopy)
    var absValue = abs(emptyIndex - index)

    if (absValue == boardSize) {
        retValue = emptyIndex

    } else if (absValue == 1){
        var maxIndex = max(index, emptyIndex)
        if (maxIndex % boardSize != 0)
            retValue = emptyIndex
        else
            retValue = index
    }
    return retValue

}

fun clickBitmap(motionEvent: MotionEvent) {
    if (motionEvent.action == 0){
        clickCount++

        val x = (motionEvent.x.toInt() / squareSize).toInt()
        val y = (motionEvent.y.toInt() / squareSize).toInt()

        val boardIndex = x + (y * boardSize)
        val emptyIndex = getEmptyNeighborBitmap(boardIndex)
        val temp = boardBitmap[boardIndex]
        boardBitmap[boardIndex] = boardBitmap[emptyIndex]
        boardBitmap[emptyIndex] = temp


        val boardIndex2 = x + (y * boardSize)
        val emptyIndex2 = getEmptyNeighbor(boardIndex2)
        val temp2 = board[boardIndex2]
        board[boardIndex2] = board[emptyIndex2]
        board[emptyIndex2] = temp2


        drawBoardBitmap()
        Log.i("tag", "board = $board")
        Log.i("tag", "curre = $correctBoard")

        if (board == correctBoard)
            showVictoryPlate(clickCount.toString())
    }
    bindingGame.countTV.text = clickCount.toString()
    bindingGame.imageView.setImageBitmap(bitmap)
}


fun imageSet(){
    initBitmap()

    resizedBmp = Bitmap.createScaledBitmap(imageBM, boardSize * squareSize, boardSize * squareSize, false)
    val pixels = IntArray(boardSize * squareSize / 2 * boardSize * squareSize / 2)
    resizedBmp.getPixels(pixels, 0, squareSize, 0, 0, squareSize, squareSize)

    bitmapCopy = Bitmap.createBitmap(boardSize * squareSize / 2, boardSize * squareSize / 2, Bitmap.Config.ARGB_8888)

    for (i in 0 until boardSize){
        for (j in 0 until boardSize) {

            bitmapCopy = Bitmap.createBitmap(boardSize * squareSize / 2, boardSize * squareSize / 2, Bitmap.Config.ARGB_8888)

            resizedBmp.getPixels(pixels, 0, squareSize, j * squareSize, i * squareSize, squareSize, squareSize)

            bitmapCopy.setPixels(pixels, 0, squareSize, 0, 0, squareSize, squareSize)

            if (i != boardSize - 1 || j != boardSize - 1)
                boardBitmap[i * boardSize + j] = bitmapCopy
        }
    }

    checkSuccessfulGameBitmap()
    drawBoardBitmap()

//    bindingSettings.chooseImage.setImageBitmap(resizedBmp)
}