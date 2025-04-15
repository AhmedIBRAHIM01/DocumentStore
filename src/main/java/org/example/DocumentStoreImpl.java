package org.example;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DocumentStoreImpl implements DocumentStore {
    private int nextId=1;
    private HashMap<Integer, Document> documentHashMap= new HashMap<>();

    protected DocumentStoreImpl() throws RemoteException {}

    @Override
    public synchronized int createDocument(String title, List<String> authors, String content) throws RemoteException {
        Document document= new Document(nextId,title,authors,content);
        documentHashMap.put(document.getId(),document);
        return nextId++;

    }

    @Override
    public Document getDocumentById(int id) throws RemoteException {
        return documentHashMap.get(id);
    }

    @Override
    public List<Document> findDocumentsByTitle(String title) throws RemoteException {
        List<Document> documents= new ArrayList<>();
        for(Document document: documentHashMap.values()){
            if(document.getTitle().equalsIgnoreCase(title)){
                documents.add(document);
            }
        }
        return documents;
    }
}
