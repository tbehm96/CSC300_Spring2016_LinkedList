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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.addFrontButton = (Button)this.findViewById(R.id.addFrontButton);
        this.addEndButton = (Button)this.findViewById(R.id.addEndButton);
        this.removeFrontButton = (Button)this.findViewById(R.id.removeFrontButton);
        this.removeEndButton = (Button)this.findViewById(R.id.removeEndButton);
        this.newValueEditText = (EditText)this.findViewById(R.id.newValueET);

        ListCore.inflater = this.getLayoutInflater();

        LinearLayout svLL = (LinearLayout)this.findViewById(R.id.scrollViewLL);
        ListCore.ll = new LinkedList(svLL);
        ListCore.ll.addEnd("6");
        ListCore.ll.addEnd("7");
        ListCore.ll.addEnd("8");
        ListCore.ll.display();

    }

    public void aButtonClicked(View sender)
    {
        if(sender == this.addFrontButton)
        {
            System.out.println("**** add front button pressed");
            System.out.println("adding: " + this.newValueEditText.getText());
            ListCore.ll.addFront(this.newValueEditText.getText().toString());
        }
        else if(sender == this.addEndButton)
        {
            System.out.println("**** add end button pressed");
            System.out.println("adding: " + this.newValueEditText.getText());
            ListCore.ll.addEnd(this.newValueEditText.getText().toString());
        }
        else if(sender == this.removeFrontButton)
        {
            System.out.println("**** remove front button pressed");
            ListCore.ll.removeFront();
        }
        else if(sender == this.removeEndButton)
        {
            System.out.println("**** remove end button pressed");
            ListCore.ll.removeEnd();
        }
        ListCore.ll.display();
    }
}