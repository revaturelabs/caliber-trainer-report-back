package com.revature.tables;

<<<<<<< HEAD

/*
 *  This bean will be used to retrieve the data points necessary 
 * 
 *  Description: Percent of each QC technical status per batch
 * 
 *  Objective: Determine a trainer's consistency through the historical results of their batch's QC score
 * 
 */



=======
import java.util.ArrayList;

/*
 *  This bean will be used to retrieve the data points necessary
 *
 *  Description: Percent of each QC technical status per batch
 *
 *  Objective: Determine a trainer's consistency through the historical results of their batch's QC score
 *
 */
>>>>>>> c00a915f3d15d598ceee9f640c497a2d7ce01169
public class TechnicalStatusPerBatch {
	
	private String batchId; // batch Id to differentiate batches 
	private String batchName; // this will be a human readable name for the batch (ex: id is "Ix2x2UAB", name would be "Batch 1")
	private String technicalStatus; // consists of "superstar, good, average, poor" 
	
	public TechnicalStatusPerBatch() {
		batchId = "";
		batchName = "";
		technicalStatus = "";
	}
	
	public TechnicalStatusPerBatch(String batchId, String batchName, String technicalStatus) {
		
		this.batchId = batchId;
		this.batchName = batchName;
		this.technicalStatus = technicalStatus;
	}
	
	
	
	public String getBatchId() {
		return batchId;
	}
	
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	
	public String getBatchName() {
		return batchName;
	}
	
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	public String getTechnicalStatus() {
		return technicalStatus;
	}
	
	public void setTechnicalStatus(String technicalStatus) {
		this.technicalStatus = technicalStatus;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((technicalStatus == null) ? 0 : technicalStatus.hashCode());
		return result;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechnicalStatusPerBatch other = (TechnicalStatusPerBatch) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (technicalStatus == null) {
			if (other.technicalStatus != null)
				return false;
		} else if (!technicalStatus.equals(other.technicalStatus))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "TechnicalStatusPerBatch [batchId=" + batchId + ", batchName=" + batchName + ", technicalStatus="
				+ technicalStatus + "]";
	}
	
	
	

    private ArrayList<String> batchId; // batch Id to differentiate batches

    private ArrayList<String> batchName; // this will be a human readable name for the batch (ex: id is "Ix2x2UAB",
    // name would be "Batch 1")

    private ArrayList<int[]> technicalStatus; // consists of "superstar, good, average, poor"

    public TechnicalStatusPerBatch() {
        batchId = new ArrayList<>();
        batchName = new ArrayList<>();
        technicalStatus = new ArrayList<>();
    }

    /**
     * Gets batchName.
     *
     * @return Value of batchName.
     */
    public ArrayList<String> getBatchName() {
        return batchName;
    }

    /**
     * Sets new batchName.
     *
     * @param batchName New value of batchName.
     */
    public void setBatchName(ArrayList<String> batchName) {
        this.batchName = batchName;
    }

    /**
     * Gets technicalStatus.
     *
     * @return Value of technicalStatus.
     */
    public ArrayList<int[]> getTechnicalStatus() {
        return technicalStatus;
    }

    /**
     * Sets new technicalStatus.
     *
     * @param technicalStatus New value of technicalStatus.
     */
    public void setTechnicalStatus(ArrayList<int[]> technicalStatus) {
        this.technicalStatus = technicalStatus;
    }

    /**
     * Gets batchId.
     *
     * @return Value of batchId.
     */
    public ArrayList<String> getBatchId() {
        return batchId;
    }

    /**
     * Sets new batchId.
     *
     * @param batchId New value of batchId.
     */
    public void setBatchId(ArrayList<String> batchId) {
        this.batchId = batchId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
        result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
        result = prime * result + ((technicalStatus == null) ? 0 : technicalStatus.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TechnicalStatusPerBatch other = (TechnicalStatusPerBatch) obj;
        if (batchId == null) {
            if (other.batchId != null)
                return false;
        } else if (!batchId.equals(other.batchId))
            return false;
        if (batchName == null) {
            if (other.batchName != null)
                return false;
        } else if (!batchName.equals(other.batchName))
            return false;
        if (technicalStatus == null) {
            return other.technicalStatus == null;
        } else return technicalStatus.equals(other.technicalStatus);
    }


    @Override
    public String toString() {
        return "TechnicalStatusPerBatch [batchId=" + batchId + ", batchName=" + batchName + ", technicalStatus="
                + technicalStatus + "]";
    }
}
