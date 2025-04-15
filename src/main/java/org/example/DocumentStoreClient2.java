package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DocumentStoreClient2 {
    public static void main(String[] args) {
        try {
            Registry registry= LocateRegistry.getRegistry("Localhost", 1099);
            DocumentStore documentStore = (DocumentStore) registry.lookup("DocumentStore");

            Scanner scanner= new Scanner(System.in);
            while(true){
                System.out.println("<<<Welcome in DocumentStore>>>");
                System.out.println("1: to create a new Document.");
                System.out.println("2. to retrieve Document by ID");
                System.out.println("3. search by Title");
                System.out.println("4. exit");
                System.out.print("Choice: ");
                String choice= scanner.nextLine();

                switch (choice.trim()){
                    case "1":
                        System.out.print("Title:");
                        String title= scanner.nextLine();
                        System.out.print("Authors: (use a ',' to split the names");
                        List<String> authors= Arrays.asList(scanner.nextLine().split("//s*,//s*"));
                        System.out.print("Content:");
                        String content= scanner.nextLine();
                        int id= documentStore.createDocument(title,authors,content);
                        System.out.println("Document created with ID: "+ id);
                        break;
                    case "2":
                        System.out.print("Enter the ID:....");
                        int DId= Integer.parseInt(scanner.nextLine());
                        Document document= documentStore.getDocumentById(DId);
                        if(document!=null){
                            System.out.println(document);
                        }else{
                            System.out.println("Not found!");
                        }
                        break;

                    case "3":
                        System.out.println("Enter the Title:....");
                        title= scanner.nextLine();
                        List<Document> documents= documentStore.findDocumentsByTitle(title);
                        if(!documents.isEmpty()){
                            for(Document document1: documents){
                                System.out.println(document1);
                            }
                        }else{
                            System.out.println("No such documents found!");
                        }
                        break;
                    case "4":
                        return;

                    default:
                        System.out.println("Invalid input!");




                }
            }


        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
