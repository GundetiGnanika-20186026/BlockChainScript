package com.blockchain.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//mysql -u root -p
public class JdbcOperations {

    public String insertTranscript(String query,String blockId){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchain","root", "gnani@247");
            Statement statement = connection.createStatement();
            if(statement.executeUpdate(query) == 1) {
                return "transcript is saved with the id "+blockId;
            }else return "error while saving";
        }catch(Exception e){
            e.printStackTrace();
            return(e.getMessage());
        }

    }

    public ArrayList<String> getTranscript(String currentBlockId){
        ArrayList<String> finalTranscript = new ArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchain", "root", "gnani@247");
            Statement statement = connection.createStatement();
            String nextId = currentBlockId;
           while(!nextId.equals("null")) {
               String transcriptQuery = "select transcript,previous_blockId from final where blockId='"+nextId+"'";
               ResultSet resultSet = statement.executeQuery(transcriptQuery);
               boolean empty = true;
               while(resultSet.next()){
                   finalTranscript.add(resultSet.getString("transcript"));
                   nextId = resultSet.getString("previous_blockId");
                   empty = false;
               }
               if(empty) {
                   break;
               }
           }
            return finalTranscript;

        }catch(Exception e){
            e.printStackTrace();
            return finalTranscript;
        }
    }
}
