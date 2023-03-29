package com.example.numberpuzzle.game

import android.app.AlertDialog
import android.graphics.Color
import android.util.Log
import android.view.MotionEvent
import android.widget.EditText
import android.widget.Toast
import com.example.numberpuzzle.settings.checkSuccessfulGameBitmap
import com.example.numberpuzzle.settings.drawBoardBitmap
import com.example.numberpuzzle.settings.positionSize
import kotlin.math.abs
import kotlin.math.max

fun initBoard(){
    boardSize = if (positionSize != 10) positionSize else 4
    squareSize = (900 / boardSize)
    emptySquare = boardSize * boardSize
}

fun init(){
    board.clear()
    correctBoard.clear()
    for (i in 1 until emptySquare){
        board.add(i)
        correctBoard.add(i)
    }
    correctBoard.add(emptySquare)
    board.shuffle()
    checkSuccessfulGame()
    board.add(emptySquare)
    drawBoard()
}

fun checkSuccessfulGame() {
//    Log.i("tag", "board = $board")
    var sum = 0
    for (i in 0 until emptySquare - 1){
        for (j in 0 until emptySquare - 1){
            if (board[i] < board[j] && i > j)
                sum++
        }
    }
//    Log.i("tag", "sum = $sum")

    if (sum % 2 != 0){
        board.shuffle()
        checkSuccessfulGame()
    }
}

fun click(motionEvent: MotionEvent) {

    if (motionEvent.action == 0){
        clickCount++

        val x = (motionEvent.x.toInt() / squareSize).toInt()
        val y = (motionEvent.y.toInt() / squareSize).toInt()

        val boardIndex = x + (y * boardSize)
        val emptyIndex = getEmptyNeighbor(boardIndex)
        val temp = board[boardIndex]
        board[boardIndex] = board[emptyIndex]
        board[emptyIndex] = temp

        drawBoard()

        if (board == correctBoard)
            showVictoryPlate(clickCount.toString())
    }
    bindingGame.countTV.text = clickCount.toString()
    bindingGame.imageView.setImageBitmap(bitmap)
}

fun getEmptyNeighbor(index: Int): Int {
    var retValue = index
    var emptyIndex = board.indexOf(emptySquare)
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

fun drawBoard() {
    canvas.drawColor(Color.WHITE)
    paint2.textSize = 50f

    for (i in 0 until boardSize){
        for (j in 0 until boardSize){
            var index = (board[boardSize * i + j]).toString()
            if (index != emptySquare.toString()){
                canvas.drawRect(
                    (j * squareSize).toFloat(),
                    (i * squareSize).toFloat(),
                    (j * squareSize + squareSize).toFloat(),
                    (i * squareSize + squareSize).toFloat(),
                    paint)

                canvas.drawText(index,
                    (j * squareSize + squareSize / 2).toFloat(),
                    (i * squareSize + squareSize/2).toFloat(), paint2)
            }
        }
    }
}

fun reNewGame(){
    board.remove(emptySquare)
    clickCount = 0
    board.shuffle()
    checkSuccessfulGame()
    board.add(emptySquare)
    drawBoard()
    bindingGame.countTV.text = clickCount.toString()
    bindingGame.imageView.setImageBitmap(bitmap)
}


fun reNewGameBitmap(){
    boardBitmap.remove(bitmapCopy)
    board.remove(emptySquare)
    clickCount = 0
    board.shuffle()
    checkSuccessfulGameBitmap()
    drawBoardBitmap()
    bindingGame.countTV.text = clickCount.toString()
    bindingGame.imageView.setImageBitmap(bitmap)
}

fun showVictoryPlate(result: String) {
    val build = AlertDialog.Builder(APP_CAME)
    build.setTitle("You win!")
    build.setMessage("Your result $result")
    resultGame = result.toInt()

    var editText = EditText(APP_CAME)
    build.setView(editText)
//    nameUserGame = editText.text.toString()

    build.setPositiveButton("Ok"){_, _ ->
        nameUserGame = editText.text.toString()
    }

    build.show()
}


fun setStatisticData(arrayList: MutableMap<Int, String>) : MutableMap<Int, String>{
    var array = arrayList.toSortedMap()
    var map = array


    var list: IntArray = array.keys.toIntArray()

    if (list[0] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[1] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[2] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[3] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[4] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[5] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[6] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[7] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[8] > resultGame)
        map[resultGame] = nameUserGame
    else if (list[9] > resultGame)
        map[resultGame] = nameUserGame



    Log.i("tag", "map = $map")

    return map
}























/*
package com.example.numberpuzzle.game

import android.graphics.Color
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import com.example.numberpuzzle.settings.positionSize
import kotlin.math.abs
import kotlin.math.max

fun initBoard(){
    boardSize = if (positionSize != 10) positionSize else 4
    squareSize = (900 / boardSize)
    emptySquare = boardSize * boardSize
}

fun init(){
    board.clear()
    correctBoard.clear()
    for (i in 1 until emptySquare){
        board.add(i)
        correctBoard.add(i)
    }
    correctBoard.add(emptySquare)
    board.shuffle()
    checkSuccessfulGame()
    board.add(emptySquare)
    drawBoard()
}

fun initBitmap(){

}

fun checkSuccessfulGame() {
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
        checkSuccessfulGame()
    }
}

fun click(motionEvent: MotionEvent) {

    if (motionEvent.action == 0){
        clickCount++

        val x = (motionEvent.x.toInt() / squareSize).toInt()
        val y = (motionEvent.y.toInt() / squareSize).toInt()

        val boardIndex = x + (y * boardSize)
        val emptyIndex = getEmptyNeighbor(boardIndex)
        val temp = board[boardIndex]
        board[boardIndex] = board[emptyIndex]
        board[emptyIndex] = temp

        drawBoard()

        if (board == correctBoard)
            showVictoryPlate()
    }
    bindingGame.countTV.text = clickCount.toString()
    bindingGame.imageView.setImageBitmap(bitmap)
}

fun showVictoryPlate() {
    Toast.makeText(APP_CAME, "you win!", Toast.LENGTH_SHORT).show()
}

fun getEmptyNeighbor(index: Int): Int {
    var retValue = index
    var emptyIndex = board.indexOf(emptySquare)
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

fun drawBoard() {
    canvas.drawColor(Color.WHITE)
    paint2.textSize = 50f

    for (i in 0 until boardSize){
        for (j in 0 until boardSize){
            var index = (board[boardSize * i + j]).toString()
            if (index != emptySquare.toString()){
                canvas.drawRect(
                    (j * squareSize).toFloat(),
                    (i * squareSize).toFloat(),
                    (j * squareSize + squareSize).toFloat(),
                    (i * squareSize + squareSize).toFloat(),
                    paint)

                canvas.drawText(index,
                    (j * squareSize + squareSize / 2).toFloat(),
                    (i * squareSize + squareSize/2).toFloat(), paint2)
            }
        }
    }
}

fun reNewGame(){
    board.remove(emptySquare)
    clickCount = 0
    board.shuffle()
    checkSuccessfulGame()
    board.add(emptySquare)
    drawBoard()
    bindingGame.countTV.text = clickCount.toString()
    bindingGame.imageView.setImageBitmap(bitmap)
}

*/
