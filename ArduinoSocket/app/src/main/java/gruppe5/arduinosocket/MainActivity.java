package gruppe5.arduinosocket;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    //variables
    private Button btnCoffee;
    private Button btnPlus;
    private boolean coffeeOn = false;
    private static Socket s;
    private static PrintWriter printWriter;

    private static String ip = "192.168.0.24";
    String message = "";

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
                if(!coffeeOn){
                    message = "O";
                    myTask mt = new myTask();
                    mt.execute();

                    Toast.makeText(getApplicationContext(), "Turning on...", Toast.LENGTH_LONG).show();
                    coffeeOn = true;
                }
                else if (coffeeOn){
                    message ="/";
                    myTask mt = new myTask();
                    mt.execute();

                    Toast.makeText(getApplicationContext(), "Turning off...", Toast.LENGTH_LONG).show();
                    coffeeOn = false;
                }


            }
        };

        View.OnClickListener plusListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the button was clicked, so activate the module.
                //opens new layout with fields to add a new module/appliance
                //try to make it usable.
            }

        };


        //button/listener overview.
        btnCoffee.setOnClickListener(coffeeListener);
        btnPlus.setOnClickListener(plusListener);
    }


    class myTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                s = new Socket(ip, 5000);
                printWriter = new PrintWriter(s.getOutputStream());
                printWriter.write(message);
                printWriter.flush();
                printWriter.close();
                s.close();


            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;

        }

    }
}