package org.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DocumentSotoreServer {
    public static final int rmiRegistryPort = 1099;
    private static final int rmiObjectPort = 0;
    public static void main(String[] args) {
        try {
            Registry registry= LocateRegistry.createRegistry(rmiRegistryPort);
            System.out.println("Registry on Port:"+ rmiRegistryPort);
            DocumentStoreImpl documentStore= new DocumentStoreImpl();
            DocumentStore stub= (DocumentStore) UnicastRemoteObject.exportObject(documentStore,rmiObjectPort);
            registry.rebind("DocumentStore", stub);
            System.out.println("DocumentStore is connecting.");


        }catch (RemoteException e){
            e.printStackTrace();
            System.exit(1);
        }











    }
}
