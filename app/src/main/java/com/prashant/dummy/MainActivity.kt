package com.prashant.dummy

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var progressTextView: TextView
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var myBox: LinearLayout
    lateinit var myText: TextView
    lateinit var myBox1: LinearLayout
    lateinit var myText1: TextView
    lateinit var myBox2: LinearLayout
    lateinit var myText2: TextView
    lateinit var myBox3: LinearLayout
    lateinit var myText3: TextView
    lateinit var myBox4: LinearLayout
    lateinit var myText4: TextView
    lateinit var myBox5: LinearLayout
    lateinit var myText5: TextView
    lateinit var myBox6: LinearLayout
    lateinit var myText6: TextView
    lateinit var myBox7: LinearLayout
    lateinit var myText7: TextView


    private var clickCount = 0
    private var clickCount1 = 0
    private var clickCount2 = 0
    private var clickCount3 = 0
    private var clickCount4 = 0
    private var clickCount5 = 0
    private var clickCount6 = 0
    private var clickCount7 = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar = findViewById(R.id.seekBar)
        progressTextView = findViewById(R.id.progressTextView)
        myBox=findViewById(R.id.myBox)
        myText=findViewById(R.id.myText)
        myBox1=findViewById(R.id.myBox1)
        myText1=findViewById(R.id.myText1)
        myBox2=findViewById(R.id.myBox2)
        myText2=findViewById(R.id.myText2)
        myBox3=findViewById(R.id.myBox3)
        myText3=findViewById(R.id.myText3)
        myBox4=findViewById(R.id.myBox4)
        myText4=findViewById(R.id.myText4)
        myBox5=findViewById(R.id.myBox5)
        myText5=findViewById(R.id.myText5)
        myBox6=findViewById(R.id.myBox6)
        myText6=findViewById(R.id.myText6)
        myBox7=findViewById(R.id.myBox7)
        myText7=findViewById(R.id.myText7)



        val items = listOf(
            "Available|Hey Let Us Connect",
            "Away|Stay Discreet And Watch",
            "Busy|Do Not Disturb|Will Catch Up Later",
            "SOS|Emergency!Need Assistance!HELP"
        )
        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.check

        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val itemSelected = parent.getItemAtPosition(position)
            }

        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.check -> {
                    return@setOnItemSelectedListener true
                }
                R.id.explore -> {
                    val intent = Intent(this@MainActivity, Explore_Activity::class.java)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    startActivity(intent)
                    finish()
                    return@setOnItemSelectedListener true
                }


                else -> {


                }
            }
            return@setOnItemSelectedListener false

        }

        select()
        val editText = findViewById<TextInputEditText>(R.id.input4)
        val wordCountTextView = findViewById<TextView>(R.id.wordCountTextView)
        val maxCharacterCount = 250 // Set the maximum word count limit

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not used in this example
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Count the words in the entered text
                val characterCount = s?.length ?: 0


                // Update the word count
                wordCountTextView.text = "$characterCount/$maxCharacterCount"
            }

            override fun afterTextChanged(s: Editable?) {
                // Not used in this example
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressTextView.text = progress.toString()

                // Get the width of the SeekBar thumb
                val thumbWidth = seekBar?.thumb?.intrinsicWidth ?: 0

                // Calculate the position of the progress tracker
                val progressTrackerX =
                    seekBar?.x?.plus(seekBar.width.times(progress).div(seekBar.max))
                        ?.minus(thumbWidth.div(2)) ?: 0f

                // Update the position of the progress tracker
                progressTextView.x = progressTrackerX
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    fun select(){
        myBox.setOnClickListener {
            clickCount++
            if (clickCount % 2 == 1) {

                myBox.setBackgroundResource(R.drawable.box_selected)
                myText.setTextColor(Color.WHITE)

            } else {
                // Box deselected, change its color back
                myBox.setBackgroundResource(R.drawable.chat)
                myText.setTextColor(Color.rgb(43,44,97))

            }
        }
        myBox1.setOnClickListener {
            clickCount1++
            if (clickCount1 % 2 == 1) {

                myBox1.setBackgroundResource(R.drawable.box_selected)
                myText1.setTextColor(Color.WHITE)

            } else {
                // Box deselected, change its color back
                myBox1.setBackgroundResource(R.drawable.chat)
                myText1.setTextColor(Color.rgb(43,44,97))

            }
        }
        myBox2.setOnClickListener {
            clickCount2++
            if (clickCount2 % 2 == 1) {

                myBox2.setBackgroundResource(R.drawable.box_selected)
                myText2.setTextColor(Color.WHITE)

            } else {
                // Box deselected, change its color back
                myBox2.setBackgroundResource(R.drawable.chat)
                myText2.setTextColor(Color.rgb(43,44,97))

            }
        }
        myBox3.setOnClickListener {
            clickCount3++
            if (clickCount3 % 2 == 1) {

                myBox3.setBackgroundResource(R.drawable.box_selected)
                myText3.setTextColor(Color.WHITE)

            } else {
                // Box deselected, change its color back
                myBox3.setBackgroundResource(R.drawable.chat)
                myText3.setTextColor(Color.rgb(43,44,97))

            }
        }
        myBox4.setOnClickListener {
            clickCount4++
            if (clickCount4 % 2 == 1) {

                myBox4.setBackgroundResource(R.drawable.box_selected)
                myText4.setTextColor(Color.WHITE)

            } else {
                // Box deselected, change its color back
                myBox4.setBackgroundResource(R.drawable.chat)
                myText4.setTextColor(Color.rgb(43,44,97))

            }
        }
        myBox5.setOnClickListener {
            clickCount5++
            if (clickCount5 % 2 == 1) {

                myBox5.setBackgroundResource(R.drawable.box_selected)
                myText5.setTextColor(Color.WHITE)

            } else {
                // Box deselected, change its color back
                myBox5.setBackgroundResource(R.drawable.chat)
                myText5.setTextColor(Color.rgb(43,44,97))

            }
        }
        myBox6.setOnClickListener {
            clickCount6++
            if (clickCount6 % 2 == 1) {

                myBox6.setBackgroundResource(R.drawable.box_selected)
                myText6.setTextColor(Color.WHITE)

            } else {
                // Box deselected, change its color back
                myBox6.setBackgroundResource(R.drawable.chat)
                myText6.setTextColor(Color.rgb(43,44,97))

            }
        }
        myBox7.setOnClickListener {
            clickCount7++
            if (clickCount7 % 2 == 1) {

                myBox7.setBackgroundResource(R.drawable.box_selected)
                myText7.setTextColor(Color.WHITE)

            } else {
                // Box deselected, change its color back
                myBox7.setBackgroundResource(R.drawable.chat)
                myText7.setTextColor(Color.rgb(43,44,97))

            } }
    }

}



