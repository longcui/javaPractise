package javaCore.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class InsertNodeAtGivenPositionTest {

    @Test
    public void test1() throws IOException {
        InsertNodeAtGivenPosition.SinglyLinkedList singlyLinkedList = new InsertNodeAtGivenPosition.SinglyLinkedList();
        singlyLinkedList.insertNode(1);
        singlyLinkedList.insertNode(3);
        singlyLinkedList.insertNode(4);

        InsertNodeAtGivenPosition.SinglyLinkedListNode newSinglyLinkedListNode = InsertNodeAtGivenPosition.insertNodeAtPosition(singlyLinkedList.head, 2, 1);

        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        InsertNodeAtGivenPosition.printSinglyLinkedList(newSinglyLinkedListNode, " ", bufferedWriter);
        bufferedWriter.flush();     //need to call flush to write to StringWriter
        Assert.assertEquals("1 2 3 4", stringWriter.toString());
    }

    @Test
    public void test2() throws IOException {
        InsertNodeAtGivenPosition.SinglyLinkedList singlyLinkedList = new InsertNodeAtGivenPosition.SinglyLinkedList();

        InsertNodeAtGivenPosition.SinglyLinkedListNode newSinglyLinkedListNode = InsertNodeAtGivenPosition.insertNodeAtPosition(singlyLinkedList.head, 2, 1);

        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        InsertNodeAtGivenPosition.printSinglyLinkedList(newSinglyLinkedListNode, " ", bufferedWriter);
        bufferedWriter.flush();     //need to call flush to write to StringWriter
        Assert.assertEquals("", stringWriter.toString());
    }

    @Test
    public void test3() throws IOException {
        InsertNodeAtGivenPosition.SinglyLinkedList singlyLinkedList = new InsertNodeAtGivenPosition.SinglyLinkedList();
        singlyLinkedList.insertNode(1);
        singlyLinkedList.insertNode(3);

        InsertNodeAtGivenPosition.SinglyLinkedListNode newSinglyLinkedListNode = InsertNodeAtGivenPosition.insertNodeAtPosition(singlyLinkedList.head, 2, 44);

        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        InsertNodeAtGivenPosition.printSinglyLinkedList(newSinglyLinkedListNode, " ", bufferedWriter);
        bufferedWriter.flush();     //need to call flush to write to StringWriter
        Assert.assertEquals("1 3 2", stringWriter.toString());
    }

}