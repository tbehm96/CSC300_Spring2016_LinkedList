package com.example.awesomefat.linkedlist;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by awesomefat on 1/28/16.
 */
public class LinkedList
{
    private Node head;
    private LinearLayout layout;

    public LinkedList(LinearLayout layout)
    {
        this.head = null;
        this.layout = layout;
    }

    public void display()
    {
        //this.layout.removeAllViews();
        if(this.head == null)
        {
            View v = ListCore.inflater.inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText("Empty List");
            this.layout.addView(v);
        }
        else
        {
            //display the list in a reasonable format
            this.head.display(this.layout);
        }
        View v = ListCore.inflater.inflate(R.layout.node, null);
        TextView tf = (TextView) v.findViewById(R.id.theValueTF);
        tf.setText("_____________");
        this.layout.addView(v);
    }

    public void addFront(String value)
    {
        //this adds a new Node to the front of the list with payload == value
        Node n = new Node(value);
        n.setNextNode(this.head);
        this.head = n;
    }

    public Node removeFront()
    {

        Node nodeToReturn = this.head;
        if(this.head != null)
        {
            this.head = this.head.getNextNode();
        }
        nodeToReturn.setNextNode(null);
        return nodeToReturn;
    }

    public void addEnd(String value)
    {
        Node n = new Node(value);
        if (this.head == null)
        {
            this.head = n;
            return;
        }
        Node currNode = this.head;
        while (currNode.getNextNode() != null)
            currNode = currNode.getNextNode();
        currNode.setNextNode(n);
    }

    public Node removeEnd()
    {
        if (this.head == null)
        {
            return null;
        }
        if (this.head.getNextNode() == null)
        {
            Node n = this.head;
            this.head = null;
            return n;
        }
        Node nodeA = this.head;
        Node nodeB = nodeA.getNextNode();
        while (nodeB != null && nodeB.getNextNode() != null)
        {
            nodeA = nodeA.getNextNode();
            nodeB = nodeB.getNextNode();
        }
        nodeA.setNextNode(null);
        return nodeB;
    }
}