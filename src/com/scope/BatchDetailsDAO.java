package com.scope;

import java.util.ArrayList;

public interface BatchDetailsDAO {
	int addBatch(BatchDetails b);
	ArrayList<BatchDetails> getSubmittedFiles();
	ArrayList<BatchDetails> getSubmittedFiles(int updateId);
	boolean updateFiles(int scopeId);
	boolean insertFileName(int scopeId,String fileName);

}
