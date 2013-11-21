package com.planetdebug;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fdList {
	List<Map<String, String>> fdsGroup = new ArrayList<Map<String, String>>();
	List<List<Map<String, String>>> fdsDetails = new ArrayList<List<Map<String, String>>>();
	public String fdKey = "OID_CLASS_FD";
	public String fdDataKey = "Information";
	public String fdSlotKey = "FD_Slot";
	public fdList (){
		int i =0;
		for (i = 1; i<20; i++)
		{	
			Map<String, String> flow = new HashMap<String, String>();
			List<Map<String, String>> fdInfo = new ArrayList<Map<String, String>>();

			flow.put(this.fdKey, "FD " + i + " Service " +i);
			this.fdsGroup.add(flow);
			
			int slot = 0;
			for (slot=0;slot<4; slot++)
			{   
				Map <String, String> slotInfo = new HashMap<String, String>();
				slotInfo.put(this.fdSlotKey, "Slot "+slot );
				slotInfo.put(this.fdDataKey,  "Working Fine");
				
				fdInfo.add(slotInfo);
			}
			this.fdsDetails.add(fdInfo);
		}
		
		
	}
	List<Map<String, String>>  getDataHdr() {
		return this.fdsGroup;
	}
	List<List<Map<String, String>>> getData(){
		return this.fdsDetails;//this.flowDomainData;
	}
}