package com.blockchain.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TranscriptConroller {
    TranscriptService transcriptService = new TranscriptService();

    @GetMapping("{visitorId}/{currentBlockId}/chainscripts")
    public ArrayList<String> getTranscript(@PathVariable("visitorId") String visitorId, @PathVariable("currentBlockId") String currentBlockId){
        return  transcriptService.getTranscript(visitorId, currentBlockId);
    }

    //"consent:true,caseId:1234567,transcript:{my new transcript},previous_blockId:5678" --> body

    @PostMapping("{visitorId}/chainscript")
    public String saveTranscript(@PathVariable("visitorId") String visitorId, @RequestBody String postBody) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Transcript transcript = objectMapper.readValue(postBody, Transcript.class);
//        return "";
        return transcriptService.addTranscript(visitorId, transcript);
    }
}
