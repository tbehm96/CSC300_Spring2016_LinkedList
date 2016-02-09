package com.example.awesomefat.linkedlist;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LinkedList
{
    private Node head;
    private LinearLayout layout;
    public int count;
    public LinkedList(LinearLayout layout)
    {
        this.head = null;
        this.layout = layout;
        this.count = 0;
    }

    public void display()
    {
        this.layout.removeAllViews();
        if(this.head == null)
        {
            View v = ListCore.inflater.inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText("Empty List");
            this.layout.addView(v);
        }
        else
        {
            this.head.display(this.layout);
        }
        View v = ListCore.inflater.inflate(R.layout.node, null);
        TextView tf = (TextView) v.findViewById(R.id.theValueTF);
        tf.setText("_____________");
        this.layout.addView(v);
    }

    public Node getAtIndex(int i)
    {
        return null;
    }

    public int count()
    {
        int count = 0;
        if(head != null)
        {
            count++;
            Node currNode = head;
            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
                count++;
            }
        }
        return count;
    }

    public void addFront(String value)
    {
        Node n = new Node(value);
        n.setNextNode(this.head);
        this.head = n;
        this.count++;
    }

    public Node removeFront()
    {
        Node nodeToReturn = this.head;
        if(this.head != null)
        {
            this.head = this.head.getNextNode();
            nodeToReturn.setNextNode(null);
            this.count--;
        }

        return nodeToReturn;
    }

    public void addEnd(String value)
    {
        if(this.head == null)
        {
            this.addFront(value);
        }
        else
        {
            Node n = new Node(value);
            Node currNode = head;
            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            currNode.setNextNode(n);
            this.count++;
        }
    }

    public Node removeEnd()
    {
        if(head == null)
        {
            return head;
        }
        else
        {
            this.count--;
            Node nodeToReturn = head;

            if(head.getNextNode() == null)
            {
                head = null;
                return nodeToReturn;
            }
            else
            {
                Node currNode = head;
                while (currNode.getNextNode() != null && currNode.getNextNode().getNextNode() != null)
                {
                    currNode = currNode.getNextNode();
                }
                nodeToReturn = currNode.getNextNode();
                currNode.setNextNode(null);
                return nodeToReturn;
            }
        }
    }

}