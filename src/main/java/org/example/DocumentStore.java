package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DocumentStore extends Remote {
 int createDocument(String title, List<String> authors,String content) throws RemoteException;
 Document getDocumentById(int id) throws RemoteException;

 List<Document> findDocumentsByTitle(String title) throws RemoteException;
}
