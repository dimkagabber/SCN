package com.equalize.xpi.esr.mapping;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sap.aii.mapping.api.StreamTransformationException;

public abstract class AbstractPlain2Plain extends AbstractMappingBase {

	@Override
	protected void executeMappingSteps() throws StreamTransformationException {
		try {			
			ArrayList<String> inputContents = parsePlainInput(input.getInputPayload().getInputStream());
			StringBuilder outSB = generateOutput(inputContents);
			
			OutputStream outStream = output.getOutputPayload().getOutputStream();
			outStream.write(outSB.toString().getBytes(plainOutputEncoding));
			
		} catch (Exception e) {
			trace.addInfo(e.getMessage());
			throw new StreamTransformationException("Mapping Exception: " + e.getMessage(), e);
		}		
	}

	protected abstract StringBuilder generateOutput(ArrayList<String> inContents);

}
