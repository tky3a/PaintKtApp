package com.example.paintktapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

// 1.viewを継承したクラス
class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var path: Path = Path() // 線を引く、図形をかく、グラフィック描画
    private var paint: Paint = Paint() // 色とか太さ
    private var drawX: Float = 0F
    private var drawY: Float = 0F

    // 2.onDraw(描画の準備)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.BLUE // 色
        paint.style = Paint.Style.STROKE // 描画のスタイルを線にする
        paint.strokeWidth = 20F // 幅
        canvas?.drawPath(path, paint)
    }

    // 3.実際の描画(タップ、移動時)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // タッチポジション
        drawX = event!!.x
        drawY = event.y

        when(event.action) {
            // タップ
            MotionEvent.ACTION_DOWN -> path.moveTo(drawX,drawY)
            // 移動
            MotionEvent.ACTION_MOVE -> path.lineTo(drawX, drawY)
        }
        // 再描画を実行させる呪文
        invalidate()

        // return super.onTouchEvent(event) // これはreturn falseという意味
        // return falseにした場合は、次の処理に移ろうとしてしまうので、同じ処理をする場合にreturn trueとうる
        return true
    }

    // 4. クリア処理(関数)
    fun clearCanvas(){
        path.reset()
        invalidate()
    }
}