package gruppe5.arduinosocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //variables
    private Button btnKaffe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of button(s)
        btnKaffe = (Button) findViewById(R.id.btnKaffe);




        //ClickListener for the coffeebutton.
            //hardcoded. find solution for dynamic clicklistener creation (new for each connection)
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the button was clicked, so activate the module.
                // send coded message to server
                    // lock into a more secure and fluid solution

            }
        };


        //button/listener overview.
        btnKaffe.setOnClickListener(listener);
    }
}
