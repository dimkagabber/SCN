package com.equalize.xpi.esr.mapping;

import java.io.OutputStream;

import org.w3c.dom.Document;

import com.sap.aii.mapping.api.StreamTransformationException;

public abstract class AbstractDOM2Plain extends AbstractMappingBase{

	@Override
	protected void executeMappingSteps() throws StreamTransformationException {
		try {
			Document inputDoc = parseInputXML(input.getInputPayload().getInputStream());
			OutputStream outStream = output.getOutputPayload().getOutputStream();
			
			StringBuilder outSB = generateOutput(inputDoc);						
			outStream.write(outSB.toString().getBytes(plainOutputEncoding));
			
		} catch (Exception e) {
			trace.addInfo(e.getMessage());
			throw new StreamTransformationException("Mapping Exception: " + e.getMessage(), e);
		}
	}

	protected abstract StringBuilder generateOutput (Document inDoc);
}
