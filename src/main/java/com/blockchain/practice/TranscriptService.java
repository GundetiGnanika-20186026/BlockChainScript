package com.blockchain.practice;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;

public class TranscriptService {

    public ArrayList<String> getTranscript(String visitorId, String currentBlockId){
        JdbcOperations jdbcOperations = new JdbcOperations();
        return jdbcOperations.getTranscript(currentBlockId);
    }

    public String addTranscript(String visitorId, Transcript transcript){
        try {
//            String[] tokens = jsonPostBody.split(",");
//            String caseId = tokens[0].split("=")[1];
//            String previousBlockId = tokens[1].split("=")[1];
//            String agentConsent = tokens[2].split("=")[1];
//            String visitorConsent = tokens[3].split("=")[1];
//            String transcript = tokens[4].split("=")[1];

            JdbcOperations jdbcOperations = new JdbcOperations();
            if (transcript.agentConsent.equals("yes") && transcript.visitorConsent.equals("yes")) {
                String blockId = md5Function(transcript.transcriptJson);
                return jdbcOperations.insertTranscript("insert into final values (" + visitorId + ",'" + transcript.caseId + "','" + transcript.transcriptJson + "','"+blockId+"','"+transcript.previousBlockId+"')",blockId);
            } else {
                return "unable to save the transcript as consent is false";
            }
        }catch (Exception e){
            e.printStackTrace();
            return (e.getMessage());
        }

    }

    public String md5Function(String transcript) throws java.security.NoSuchAlgorithmException, UnsupportedEncodingException {
            byte[] bytesOfMessage = transcript.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            String digest = md.digest(bytesOfMessage).toString();
            return digest;

    }
}
