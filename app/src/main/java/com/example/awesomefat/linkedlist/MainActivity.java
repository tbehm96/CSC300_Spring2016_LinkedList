package com.example.awesomefat.linkedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button addFrontButton;
    private Button addEndButton;
    private Button removeFrontButton;
    private Button removeEndButton;
    private EditText newValueEditText;
    private LinkedList ll;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        //give ourselves programmatic access to the buttons and edit text
        this.addFrontButton = (Button)this.findViewById(R.id.addFrontButton);
        this.addEndButton = (Button)this.findViewById(R.id.addEndButton);
        this.removeFrontButton = (Button)this.findViewById(R.id.removeFrontButton);
        this.removeEndButton = (Button)this.findViewById(R.id.removeEndButton);
        this.newValueEditText = (EditText)this.findViewById(R.id.newValueET);

        ListCore.inflater = this.getLayoutInflater();

        LinearLayout svLL = (LinearLayout)this.findViewById(R.id.scrollViewLL);
        this.ll = new LinkedList(svLL);
        this.ll.removeFront();
        this.ll.display();
        this.ll.addEnd("6");
        this.ll.addEnd("7");
        this.ll.addEnd("8");
        this.ll.display();
        this.ll.removeEnd();
        this.ll.display();

        System.out.println("**** " + this.ll.count);
        System.out.println("**** " + this.ll.count());

        View v;
        for(int i = 0; i < 10; i++)
        {
            v = this.getLayoutInflater().inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText("" + i);
            svLL.addView(v);
        }

    }

    public void aButtonClicked(View sender)
    {
        if(sender == this.addFrontButton)
        {
            System.out.println("**** add front button pressed");
            String value = this.newValueEditText.getText().toString();
            System.out.println("adding: " + value);
            this.ll.addFront(value);
            this.ll.display();
        }
        else if(sender == this.addEndButton)
        {
            System.out.println("**** add end button pressed");
            String value = this.newValueEditText.getText().toString();
            System.out.println("adding: " + value);
            this.ll.addEnd(value);
            this.ll.display();
        }
        else if(sender == this.removeFrontButton)
        {
            System.out.println("**** remove front button pressed");
            this.ll.removeFront();
            this.ll.display();
        }
        else if(sender == this.removeEndButton)
        {
            System.out.println("**** remove end button pressed");
            this.ll.removeEnd();
            this.ll.display();
        }
    }
}