package com.planetdebug;
public class gblData{
    private String nodeIp=null;
	private static gblData instance = new gblData();

    private gblData() {}

    public static gblData getInstance() {
        return instance;
    }
    public String getNodeIp(){
    	return nodeIp;
    }
    public void setNodeIp(String ip){
    	nodeIp = ip;
    }
}