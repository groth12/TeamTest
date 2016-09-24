package com.example.mooooood.hellogoodbye;
/*****************************************************************
 * ADK file: HelloGoodbye
 * Author: Denise Fullerton
 *
 * Created on August 28, 2016, 7:19 PM
 * Last Modified on September 6, 2016, 5:07 PM
 *
 * Purpose: Example Android Application to practice and demonstrate understanding of resources,
 *          design, and activities in the Android Development Kit. This project includes a two button
 *          user that will change the image displayed along with two text boxes that change with
 *          the images.
 *
 * Algorithm:
 *          Not sure how to explain this
 *
 *************************************************************************/

// imports statements for activity, bundle, menu, menuItem
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View; // View is base class of all user interface components
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;


/*********************************************************************************************
 * Description: MainActivity is the main function that extends AppCompatActivity that contains
 *              functions, internal classes, and resources including drawable (an image resource
 *              file), xml layout file (app design), xml value file (constant strings, colors,
 *              and styles app style information)
 *              The specific function is to take the information from all resources and run the
 *              application.
 * Variables used:
 *              private TextView greetingTextview - used for bottom text box in application
 *              private TextView topTextView - used for top text box in application
 *              private ImageView imgView - used to display the image in center of app display
 *              private boolean isHello - used for bottom button toggle, sets to true or false at
 *              button touch
 *              private boolean isButtonTop - used for top button toggle, sets to true or false at
 *              button touch
 **********************************************************************************************/

public class MainActivity extends AppCompatActivity {


    // Java global class variables - just learned-thanks Jo
    // DECLARED FOR TEXT AND IMAGE REFERENCE FOR CONTENT LAYOUT
    private TextView greetingTextView;
    private TextView topTextView;
    private ImageView imgView;

    // BOOLEAN TO CHANGE TOP TEXT BOX WHEN BUTTON PUSHED
    private boolean isHello;
    // BOOLEAN TO CHANGE BOTTOM TEXT BOX WHEN BUTTON PUSHED
    private boolean isButtonTop;


    /****************************************************************************
     *  Description:    onCreate - initial app display when application is run, changes
     *                  updates display when state of variables/app changes
     *  Parameters:     savedInstanceState - saves the state of the current instance of the app
     *  Variables used: greetingTextView, topTextView, imgView - private variables instantiated
     *                  at start of program to store state of event listener
     *                  Button exclaimButn - variable for to store state of bottom button
     *                  Button top_btn - variable to store state of top button
     *
     ******************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TASK 1: INFLATE THE MAIN SCREEN LAYOUT USED BY THE APP
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ESTABLISHING REFERENCES TO BOTH TEXT BOXES AND THE IMAGE BOX
        greetingTextView = (TextView) findViewById(R.id.textView);
        topTextView = (TextView) findViewById(R.id.textView2);
        imgView = (ImageView)findViewById(R.id.imageView);

        // INITIALIZE GREETINGS FOR TEXT BOXES
        initializeGreeting();

        // REGISTER THE LISTENER EVENT FOR THE BUTTONS
        // BOTTOM BUTTON EVENT LISTENER
        Button exclaimBtn = (Button) findViewById(R.id.button);
        exclaimBtn.setOnClickListener(toggleGreeting);

        // TOP BUTTON EVENT LISTENER
        Button top_btn = (Button) findViewById(R.id.button2);
        top_btn.setOnClickListener(toggleTopButton);
    }

    /***************************************************************************************
     * Description: Inner class OnClickListener for toggleGreeting object
     *              set to listen for state change when bottom button
     *              in the app is touched. Instantiated one time for each event listener
     *              When the bottom button is touched, the image display and top text box changes
     *
     * Varibles used:   boolean isHello to change state of toggleGreeting when the bottom button is
     *                  touched
     *
     * Functions used:  setText(string) has string parameter that uses R (resource) object pulling from the
     *                  value/string xml file using the xml id names
     *                  setImageResource(image) has an image parameter that uses R (resource)
     *                  object pulling from drawable/'image name' -
     *                  (reference for setImageResource -http://stackoverflow.com/questions/
     *                  14325317/how-to-set-background-of-selected-unselected-button-in-the
     *                  -xml-file  answer #2
     *
     *****************************************************************************************/
    private final View.OnClickListener toggleGreeting = new View.OnClickListener(){
        public void onClick(View btn){
            // CHANGES TOGGLE STATE FOR THE BOTTOM BUTTON WHICH SETS TOP TEXT AND CHANGES CENTER
            // IMAGE USING BOOLEAN isHello
            isHello = !isHello;
            if (isHello) {
                greetingTextView.setText(R.string.hello);
                topTextView.setText(R.string.clearText);
                imgView.setImageResource(R.drawable.creepdoll);
            }else{
                greetingTextView.setText(R.string.nothing);
                topTextView.setText(R.string.clearText);
                imgView.setImageResource(R.drawable.see);
            }
        }
    };
    /***************************************************************************************
     * Description: Inner class OnClickListener for toggleTopButton object
     *              set to listen for state change when top
     *              in the app is touched. Instantiated one time for each event listener
     *              When the bottom button is touched, the image display and top text box changes
     *
     * Variables used:   boolean isHello to change state of toggleGreeting when the bottom button is
     *                  touched
     *
     * Functions used:  setText(string) has string parameter that uses R (resource) object pulling from the
     *                  value/string xml file using the xml id names
     *                  setImageResource(image) has an image parameter that uses R (resource)
     *                  object pulling from drawable/'image name' -
     *                  (reference for setImageResource -http://stackoverflow.com/questions/
     *                  14325317/how-to-set-background-of-selected-unselected-button-in-the
     *                  -xml-file  answer #2
     *
     *****************************************************************************************/
    private final View.OnClickListener toggleTopButton = new View.OnClickListener(){
        public void onClick(View topBtn) {
            // CHANGES TOGGLE STATE FOR THE TOP BUTTON WHICH SETS BOTTOM TEXT AND CHANGES CENTER
            // IMAGE USING BOOLEAN isButtonTop
            isButtonTop = !isButtonTop;
            if(isButtonTop){
                greetingTextView.setText(R.string.clearText);
                topTextView.setText(R.string.smile);
                imgView.setImageResource(R.drawable.creepysmile);
            }else{
                greetingTextView.setText(R.string.clearText);
                topTextView.setText(R.string.hauntedTxt);
                imgView.setImageResource(R.drawable.haunted);
            }
        }
    };



    // Setting default boolean values when app initializes for buttons toggle states
    private void initializeGreeting(){
        isHello = true;
        isButtonTop = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
