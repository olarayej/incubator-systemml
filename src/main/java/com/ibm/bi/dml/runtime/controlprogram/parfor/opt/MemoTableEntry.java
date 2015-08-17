/**
 * IBM Confidential
 * OCO Source Materials
 * (C) Copyright IBM Corp. 2010, 2013
 * The source code for this program is not published or otherwise divested of its trade secrets, irrespective of what has been deposited with the U.S. Copyright Office.
 */


package com.ibm.bi.dml.runtime.controlprogram.parfor.opt;

import com.ibm.bi.dml.runtime.controlprogram.ProgramBlock;

/**
 * 
 * 
 */
public class MemoTableEntry 
{
	@SuppressWarnings("unused")
	private static final String _COPYRIGHT = "Licensed Materials - Property of IBM\n(C) Copyright IBM Corp. 2010, 2013\n" +
                                             "US Government Users Restricted Rights - Use, duplication  disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	
	//physical plan representations
	private long    _id         = -1;
	private OptNode _rtOptNode  = null;
	private ProgramBlock _rtPB  = null;
	
	//statistics
	private double  _estLMemory = -1;
	private double  _estLTime   = -1;
	
	public MemoTableEntry( long id, OptNode rtnode, ProgramBlock pb, double lm, double lt )
	{
		_id = id;
		_rtOptNode = rtnode;
		_rtPB = pb;
		_estLMemory = lm;
		_estLTime = lt;
	}
	
	public long getID()
	{
		return _id;
	}
	
	public void setID( long id )
	{
		_id = id;
	}

	public OptNode getRtOptNode() 
	{
		return _rtOptNode;
	}

	public void setRtOptNode(OptNode rtOptNode) 
	{
		_rtOptNode = rtOptNode;
	}
	
	public ProgramBlock getRtProgramBlock()
	{
		return _rtPB;
	}
	
	public void setRtProgramBlock( ProgramBlock pb )
	{
		_rtPB = pb;
	}

	public double getEstLMemory() 
	{
		return _estLMemory;
	}

	public void setEstLMemory(double estLMemory) 
	{
		_estLMemory = estLMemory;
	}

	public double getEstLTime()
	{
		return _estLTime;
	}

	public void setEstLTime(double estLTime) 
	{
		_estLTime = estLTime;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("ID = ");
		sb.append(_id);
		sb.append("RtOptNode = ");
		sb.append(_rtOptNode.explain(0, false));
		sb.append("RtProg = ");
		sb.append(_rtPB.getClass().toString());

		return sb.toString();
	}
}