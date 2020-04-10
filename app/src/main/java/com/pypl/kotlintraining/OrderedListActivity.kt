package com.pypl.kotlintraining

import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.text.Layout
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.text.style.LeadingMarginSpan
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_ordered_list.*

class OrderedListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordered_list)

        createBulletSpan()
        createNumberSpan()
    }

    private val WIDTH = 50
    private fun createNumberSpan() {
        val item = arrayOf("Item1", "Item2", "Item3", "Item4")
        val builder = SpannableStringBuilder()
        item.forEachIndexed { index, item ->
            builder.append(
                "$item \n\n",
                OrderedListSpan(WIDTH, "${index + 1}."),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        textview4.text = builder
    }

    private fun createBulletSpan() {

        val item = arrayOf("Item1", "Item2", "Item3", "Item4")
        val builder = SpannableStringBuilder()
        item.forEach { item ->
            builder.append(" $item \n\n", BulletSpan(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        textview2.text = builder
    }

    class OrderedListSpan(private val width: Int, private val leadingText: String) :
        LeadingMarginSpan {
        override fun drawLeadingMargin(
            c: Canvas?,
            p: Paint?,
            x: Int,
            dir: Int,
            top: Int,
            baseline: Int,
            bottom: Int,
            text: CharSequence?,
            start: Int,
            end: Int,
            first: Boolean,
            layout: Layout?
        ) {
            val spanStart = (text as Spanned).getSpanStart(this)
            val isFirstChar = spanStart == start

            if (isFirstChar) {
                c?.drawText(leadingText, x.toFloat(), baseline.toFloat(), p!!)
            }
        }

        override fun getLeadingMargin(first: Boolean) = width

    }
}
