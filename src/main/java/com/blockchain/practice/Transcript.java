package com.blockchain.practice;

public  class Transcript{
    String agentConsent;
    String visitorConsent;
    String caseId;
    String visitorId;
    String previousBlockId;
    String currentBlockId;
    String transcriptJson;

    public Transcript() {
    }

    public Transcript(String agentConsent, String visitorConsent, String caseId, String visitorId, String previousBlockId, String currentBlockId, String transcriptJson) {
        this.agentConsent = agentConsent;
        this.visitorConsent = visitorConsent;
        this.caseId = caseId;
        this.visitorId = visitorId;
        this.previousBlockId = previousBlockId;
        this.currentBlockId = currentBlockId;
        this.transcriptJson = transcriptJson;
    }

    public String getAgentConsent() {
        return agentConsent;
    }

    public void setAgentConsent(String agentConsent) {
        this.agentConsent = agentConsent;
    }

    public String getVisitorConsent() {
        return visitorConsent;
    }

    public void setVisitorConsent(String visitorConsent) {
        this.visitorConsent = visitorConsent;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getPreviousBlockId() {
        return previousBlockId;
    }

    public void setPreviousBlockId(String previousBlockId) {
        this.previousBlockId = previousBlockId;
    }

    public String getCurrentBlockId() {
        return currentBlockId;
    }

    public void setCurrentBlockId(String currentBlockId) {
        this.currentBlockId = currentBlockId;
    }

    public String getTranscriptJson() {
        return transcriptJson;
    }

    public void setTranscriptJson(String transcriptJson) {
        this.transcriptJson = transcriptJson;
    }
}