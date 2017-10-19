package gruppe5.arduinosocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //variables
    private Button btnCoffee;
    private Button btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of button(s)
        btnCoffee = (Button) findViewById(R.id.btnCoffee);
        btnPlus = (Button) findViewById(R.id.btnPlus);



        //ClickListener for the btnCoffee.
            //hardcoded. find solution for dynamic clicklistener creation (new for each connection)
        View.OnClickListener coffeeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the button was clicked, so activate the module.
                // send coded message to server
                    // lock into a more secure and fluid solution

            }
        };

        View.OnClickListener plusListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // the button was clicked, so activate the module.
                //opens new layout with fields to add a new module/appliance
                    //try to make it usable.
            }

        };


        //button/listener overview.
        btnCoffee.setOnClickListener(coffeeListener);
        btnPlus.setOnClickListener(plusListener);
    }
}
