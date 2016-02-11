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

    public int indexOf(Node n)
    {
        if(this.head != null)
        {
            int pos = 0;
            Node currNode = this.head;
            do
            {
                if(currNode == n)
                {
                    return pos;
                }
                else
                {
                    pos++;
                    currNode = currNode.getNextNode();
                }
            }
            while(currNode != null);
        }
        return -1;
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

    public Node getAtIndex(int index)
    {
        Node n = this.head;
        for (int i = 0; i < index; i++)
        {
            n = n.getNextNode();
        }
        return n;
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

    public Node removeAtIndex(int index)
    {
        if(head == null)
        {
            return null;
        }
        else
        {
            Node nodeToReturn = head;
            if(head.getNextNode() == null)
            {
                if (index == 0)
                {
                    return removeFront();
                }
                else
                {
                    return null;
                }
            }
            else
            {
                if (index == 0)
                {
                    return removeFront();
                }
                Node currNode = head;
                for (int i = 0; i < index - 1; i++)
                {
                    if (currNode.getNextNode() != null && currNode.getNextNode().getNextNode() != null)
                    {
                        currNode = currNode.getNextNode();
                    }
                    else
                    {
                        return null;
                    }
                }
                nodeToReturn = currNode.getNextNode();
                if (nodeToReturn.getNextNode() == null)
                {
                    count--;
                    currNode.setNextNode(null);
                    return nodeToReturn;
                }
                else
                {
                    count--;
                    currNode.setNextNode(nodeToReturn.getNextNode());
                    nodeToReturn.setNextNode(null);
                    return nodeToReturn;
                }
            }
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